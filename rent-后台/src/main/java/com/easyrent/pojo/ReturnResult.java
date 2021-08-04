package com.easyrent.pojo;

public class ReturnResult {
    public String message;
    public String status;
    public Object data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ReturnResult() {
    }

    public ReturnResult(String message, String status, Object data) {
        this.message = message;
        this.status = status;
        this.data = data;
    }
}
