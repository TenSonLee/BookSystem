package com.jl.graduatedesign.vo;

import java.util.List;

public class PagedResponse<T> {
    private Boolean rel;

    private String msg;

    private List<T> list;

    private Integer count;

    @Override
    public String toString() {
        return "PagedResponse{" +
                "rel=" + rel +
                ", msg='" + msg + '\'' +
                ", list=" + list +
                ", count=" + count +
                '}';
    }

    public Boolean getRel() {
        return rel;
    }

    public void setRel(Boolean rel) {
        this.rel = rel;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
