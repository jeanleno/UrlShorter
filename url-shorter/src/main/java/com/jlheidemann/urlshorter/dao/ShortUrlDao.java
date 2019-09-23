package com.jlheidemann.urlshorter.dao;

import com.jlheidemann.urlshorter.database.AppDatabase;
import com.jlheidemann.urlshorter.entity.ShortUrl;
import java.util.Optional;

/**
 *
 * @author jeanl
 */
public class ShortUrlDao {
    public void save(ShortUrl url) {
        AppDatabase db = AppDatabase.getInstance();
        
        Optional<ShortUrl> opt = db.getUrls().stream().filter(u -> u.getId() == url.getId()).findFirst();
        if (opt.isPresent()) {
            db.getUrls().remove(opt.get());
        }
        db.getUrls().add(url);
    }
    
    public ShortUrl findByShortUrl(String url) {
        AppDatabase db = AppDatabase.getInstance();
        Optional<ShortUrl> opt = db.getUrls().stream().filter(u -> u.getNewUrl().equals(url)).findFirst();
        
        if (opt.isPresent()) {
            return opt.get();
        }
        return null;
    }
    
    public void delete(ShortUrl shortUrl) {
        AppDatabase db = AppDatabase.getInstance();
        db.getUrls().remove(shortUrl);
    }
}
