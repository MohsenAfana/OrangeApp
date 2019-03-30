package com.dev.orangeapp;

import com.dev.orangeapp.Models.TvCategory;
import com.dev.orangeapp.Models.VideoCategory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CatJsonObject {
    private List<TvCategory> tvCategory = null;
    private List<VideoCategory> videoCategory = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<TvCategory> getTvCategory() {
        return tvCategory;
    }

    public void setTvCategory(List<TvCategory> tvCategory) {
        this.tvCategory = tvCategory;
    }

    public CatJsonObject withTvCategory(List<TvCategory> tvCategory) {
        this.tvCategory = tvCategory;
        return this;
    }

    public List<VideoCategory> getVideoCategory() {
        return videoCategory;
    }

    public void setVideoCategory(List<VideoCategory> videoCategory) {
        this.videoCategory = videoCategory;
    }

    public CatJsonObject withVideoCategory(List<VideoCategory> videoCategory) {
        this.videoCategory = videoCategory;
        return this;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public CatJsonObject withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }
}
