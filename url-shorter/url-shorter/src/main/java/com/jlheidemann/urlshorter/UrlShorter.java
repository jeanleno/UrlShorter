package com.jlheidemann.urlshorter;

/**
 *
 * @author jean.heidemann
 */
public class UrlShorter {
    public String shortenUrl(String url) {
        if (url == null || "".equals(url)) {
            throw new IllegalArgumentException("url");
        }
        
        //TODO: Encurtar a URL
        return "http://localhost:8080/abc123def";
    }
}
