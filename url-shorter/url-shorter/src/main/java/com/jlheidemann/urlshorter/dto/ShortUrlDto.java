package com.jlheidemann.urlshorter.dto;

import java.util.Date;

/**
 *
 * @author jean.heidemann
 */
public class ShortUrlDto {
    private String url;
    private Date expiresAt;

    public ShortUrlDto() {
    }

    public ShortUrlDto(String url, Date expiresAt) {
        this.url = url;
        this.expiresAt = expiresAt;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(Date expiresAt) {
        this.expiresAt = expiresAt;
    }
    
    
}
