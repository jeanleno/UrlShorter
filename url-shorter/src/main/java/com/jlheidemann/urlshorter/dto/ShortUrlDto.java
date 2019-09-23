package com.jlheidemann.urlshorter.dto;

import java.util.Date;

/**
 *
 * @author jeanl
 */
public class ShortUrlDto {
    private String newUrl;
    private Date expiresAt;

    public ShortUrlDto() {
    }

    public ShortUrlDto(String newUrl, Date expiresAt) {
        this.newUrl = newUrl;
        this.expiresAt = expiresAt;
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
