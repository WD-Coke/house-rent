package com.easyrent.utils;

import com.easyrent.pojo.House;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public class FileUploadUtils {
    public static void upload(String path, MultipartFile file[] ,House house){
        File filepath = new File(path);
        if (!filepath.exists()){
            filepath.mkdir();
        }
        if (file==null){
            return;
        }
        String beforestr ="http://47.115.31.127:9009/";
        int i =0;
        try {
            for ( ;i<file.length;i++){
                if (file[i].getOriginalFilename()!=null&&file[i].getOriginalFilename().length()!=0) {
                    String exName = file[i].getOriginalFilename().substring(file[i].getOriginalFilename().lastIndexOf(".")+1);
                    FastDfsClient fastDfsClient = new FastDfsClient("classpath:conf/client.conf");
//                    String uuid = UUID.randomUUID().toString();
//                    File file1 = new File(filepath + File.separator + uuid + exName);
//                    System.out.println(file1.getAbsolutePath());
//                    file[i].transferTo(file1);
                    String s = fastDfsClient.upLoadFile(file[i].getBytes(), exName, null);
//                    String comName = beforestr + filepath + File.separator + uuid + exName;
                    house.getClass().getMethod("setPic" + (i + 1), String.class).invoke(house, beforestr+s);
//                    System.out.println(house.getClass().getMethod("getPic"+(i+1)).invoke(house));
                }
                else break;
            }
            if (i!=0){
                house.setHousemainpic(house.getPic1());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
