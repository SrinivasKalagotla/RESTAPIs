package org.api.football;

import java.util.List;

public class ApiData {
    private List<Match> data;
    private int total_pages;

    public List<Match> getData() {
        return data;
    }

    public void setData(List<Match> data) {
        this.data = data;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }
}
