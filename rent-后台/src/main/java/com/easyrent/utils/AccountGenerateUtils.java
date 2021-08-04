package com.easyrent.utils;

import java.sql.PreparedStatement;
import java.util.*;

public class AccountGenerateUtils {
    private static final char[] NUM = {'0','1','2','3','4','5','6','7','8','9'};
    public static String account(int size){
        char[] result = new char[10];
        for (int i = 0; i< size; i++) {
            int ramdom =(int)(Math.random()*10);
            if (ramdom!=0||i!=0){
                result[i]=NUM[ramdom];
            }
        }
        return new String(result);
    }

}
