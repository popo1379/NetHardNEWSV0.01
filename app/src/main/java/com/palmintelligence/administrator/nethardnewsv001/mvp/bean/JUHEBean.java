package com.palmintelligence.administrator.nethardnewsv001.mvp.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.transform.Result;

/**
 * Created by Administrator on 2017/2/24 0024.
 */
public class JUHEBean {

    private String reason;
    private Result result;
    private Integer errorCode;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }


    public class Result {
        private String stat;
        private List<GamesBean> data = null;
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        public String getStat() {
            return stat;
        }

        public void setStat(String stat) {
            this.stat = stat;
        }

        public List<GamesBean> getData() {
            return data;
        }

        public void setData(List<GamesBean> data) {
            this.data = data;
        }

        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }
    }










}
