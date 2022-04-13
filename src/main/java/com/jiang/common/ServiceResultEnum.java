package com.jiang.common;

public enum ServiceResultEnum {

    DATA_NOT_EXIST("未查询到记录！");

    private String result;

    ServiceResultEnum(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
