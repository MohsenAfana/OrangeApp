package com.dev.orangeapp.Models;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class TvChannelJson implements Serializable {
    private Integer id;
    private String name;
    private Integer number;
    private Integer tvGenreId;
    private Integer nginxSecureLink;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getTvGenreId() {
        return tvGenreId;
    }

    public void setTvGenreId(Integer tvGenreId) {
        this.tvGenreId = tvGenreId;
    }

    public Integer getNginxSecureLink() {
        return nginxSecureLink;
    }

    public void setNginxSecureLink(Integer nginxSecureLink) {
        this.nginxSecureLink = nginxSecureLink;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
