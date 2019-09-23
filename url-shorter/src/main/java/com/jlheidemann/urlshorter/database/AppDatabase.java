package com.jlheidemann.urlshorter.database;

import com.jlheidemann.urlshorter.entity.ShortUrl;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jeanl
 */
public class AppDatabase {
    private static AppDatabase instance;
    
    private List<ShortUrl> urls;
    
    private AppDatabase() {
        
    }
    
    public static AppDatabase getInstance() {
        if (instance == null) {
            instance = new AppDatabase();
        }
        
        if (instance.getUrls() == null) {
            instance.setUrls(new ArrayList());
        }
        return instance;
    }

    public List<ShortUrl> getUrls() {
        return urls;
    }

    public void setUrls(List<ShortUrl> urls) {
        this.urls = urls;
    }
}
