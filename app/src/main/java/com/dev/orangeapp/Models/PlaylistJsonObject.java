package com.dev.orangeapp.Models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class PlaylistJsonObject {
    private List<TvChannels> tvChannels = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<TvChannels> getTvChannels() {
        return tvChannels;
    }

    public void setTvChannels(List<TvChannels> tvChannels) {
        this.tvChannels = tvChannels;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
