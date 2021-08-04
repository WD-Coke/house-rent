package com.easyrent.controller;

import com.easyrent.mapper.OrderCheckMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import java.io.*;
import java.util.*;

/**
 * 定时任务
 */

@Controller
public class OrderTaskController {
    @Autowired
    OrderCheckMapper orderCheckMapper;

    /**
     * 订单定时检测
     */
    @Scheduled(cron = "0 0 0 * * ? ")
    public void doTask(){
        System.out.println("开始执行订单检测");
    orderCheckMapper.setHouseState();
    orderCheckMapper.setOrderState();
    }

    /**
     * ip定时检测
     */
    @Scheduled(cron = "0 0/5 * * * ? ")
    public void doIpCount(){
        System.out.println("开始执行ip检测");
        File file = new File("./filter.txt");
        Map<String,Integer> map = new HashMap<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line="";
            while ((line=bufferedReader.readLine())!=null){
                if (map.containsKey(line)){
                    map.put(line,map.get(line)+1);
                }else{
                    map.put(line,1);
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Set<String> strings = map.keySet();
        Iterator<String> iterator = strings.iterator();
        while(iterator.hasNext()){
            String key = iterator.next();
            if (map.get(key)>180){
                File file1 = new File("./ban.txt");
                try {
                    if (!file.exists()) file.createNewFile();
                    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file1, true));
                    bufferedWriter.write(key+"\n");
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        file.delete();
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
