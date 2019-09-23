package com.jlheidemann.urlshorter.database;

import com.jlheidemann.urlshorter.entity.ShortUrl;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jean.heidemann
 */
public class ApplicationDatabase {
    private static ApplicationDatabase instance;
    
    private List<ShortUrl> shortedUrls;
    
    private ApplicationDatabase() {
        shortedUrls = new ArrayList<>();
    }
    
    public static synchronized ApplicationDatabase getInstance() {
        if (instance == null) {
            instance = new ApplicationDatabase();
        }
        
        return instance;
    }

    public List<ShortUrl> getShortedUrls() {
        return shortedUrls;
    }

    public void setShortedUrls(List<ShortUrl> shortedUrls) {
        this.shortedUrls = shortedUrls;
    }
    
    
}
