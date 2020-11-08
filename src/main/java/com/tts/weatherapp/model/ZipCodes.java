package com.tts.weatherapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ZipCodes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long search_id;
    private String zipCodes;

    public ZipCodes() {
    }

    public ZipCodes(long search_id, String zipCodes) {
        this.search_id = search_id;
        this.zipCodes = zipCodes;
    }

    public long getSearch_id() {
        return search_id;
    }

    public void setSearch_id(long search_id) {
        this.search_id = search_id;
    }

    public String getZipCodes() {
        return zipCodes;
    }

    public void setZipCodes(String zipCodes) {
        this.zipCodes = zipCodes;
    }

    @Override
    public String toString() {
        return "ZipCodes [search_id=" + search_id + ", zipCodes=" + zipCodes + "]";
    }
}