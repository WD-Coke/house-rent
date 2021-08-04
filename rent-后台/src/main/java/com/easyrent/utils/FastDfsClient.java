package com.easyrent.utils;

import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;

import java.io.IOException;

public class FastDfsClient {
    private TrackerServer trackerServer = null;
    private TrackerClient trackerClient= null;
    private StorageClient storageClient = null;
    public FastDfsClient(String conf) throws Exception {
        String s;
        if (conf.contains("classpath:")){

          conf = conf.replace("classpath:",this.getClass().getResource("/").toURI().getPath());
          s = new String(conf.getBytes(),"utf-8");
        }else{
            s = new String(conf.getBytes(),"utf-8");
        }
        ClientGlobal.init(s);
        trackerClient = new TrackerClient();
        trackerServer = trackerClient.getTrackerServer();
        StorageServer storageServer = null;
        storageClient = new StorageClient(trackerServer,storageServer);
    }
    public String upLoadFile(String fileName, String extName, NameValuePair[] metas)throws IOException, MyException {
        String[] jpgs = storageClient.upload_file(fileName, extName, null);
        return resultValue(jpgs);
    }
    public String upLoadFile(byte[] bytes, String extName, NameValuePair[] metas)throws IOException, MyException {
        String[] jpgs = storageClient.upload_file(bytes, extName, null);
        return resultValue(jpgs);
    }
    public String upLoadFile(String fileName)throws IOException, MyException {
        String[] jpgs = storageClient.upload_file(fileName, null, null);
        return resultValue(jpgs);
    }
    public String resultValue(String[] jpgs){
        String result ="";
        jpgs[0] =jpgs[0]+"/";
        for (String string:jpgs
        ) {
            result =result+string;
        }
        return result;
    }
}
