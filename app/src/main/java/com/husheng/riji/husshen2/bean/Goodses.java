package com.husheng.riji.husshen2.bean;

import java.util.List;

public class Goodses {

    private List<Goods> result_list;

    private int total_results;

    public List<Goods> getResult_list() {
        return result_list;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    public void setResult_list(List<Goods> result_list) {
        this.result_list = result_list;
    }
}
