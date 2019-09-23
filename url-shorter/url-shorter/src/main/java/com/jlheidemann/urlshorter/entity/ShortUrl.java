package com.jlheidemann.urlshorter.entity;

import java.util.Date;

/**
 *
 * @author jean.heidemann
 */
public class ShortUrl {
    private long id;
    private String url;
    private String newUrl;
    private Date expiresAt;

    public ShortUrl() {
    }

    public ShortUrl(String url, String newUrl, Date expiresAt) {
        this.url = url;
        this.newUrl = newUrl;
        this.expiresAt = expiresAt;
    }

    public ShortUrl(long id, String url, String newUrl, Date expiresAt) {
        this.id = id;
        this.url = url;
        this.newUrl = newUrl;
        this.expiresAt = expiresAt;
    }
    
    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNewUrl() {
        return newUrl;
    }

    public void setNewUrl(String newUrl) {
        this.newUrl = newUrl;
    }

    public Date getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(Date expiresAt) {
        this.expiresAt = expiresAt;
    }
    
    
}
