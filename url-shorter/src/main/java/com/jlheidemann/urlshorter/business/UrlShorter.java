package com.jlheidemann.urlshorter.business;

import com.jlheidemann.urlshorter.business.exception.UrlExpiredException;
import com.jlheidemann.urlshorter.business.exception.UrlNotFoundException;
import com.jlheidemann.urlshorter.dao.ShortUrlDao;
import com.jlheidemann.urlshorter.dto.ShortUrlDto;
import com.jlheidemann.urlshorter.entity.ShortUrl;
import com.jlheidemann.urlshorter.util.Constants;
import com.jlheidemann.urlshorter.util.UrlKeyGenerator;
import java.util.Calendar;
import java.util.concurrent.atomic.AtomicLong;

/**
 *
 * @author jeanl
 */
public class UrlShorter {
    private static final AtomicLong atomicLong = new AtomicLong();
    
    public ShortUrlDto shortenUrl(String url) {
        long id = atomicLong.incrementAndGet();
        
        UrlKeyGenerator keyGenerator = new UrlKeyGenerator();
        String newUrl = Constants.DOMAIN + keyGenerator.generateKey();
        
        while (shortUrlAlreadyExists(newUrl)) {
            newUrl = Constants.DOMAIN + keyGenerator.generateKey();
        }
        
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, Constants.EXPIRATION_DAYS);
        
        ShortUrl shortUrl = new ShortUrl();
        shortUrl.setId(id);
        shortUrl.setUrl(url);
        shortUrl.setExpiresAt(cal.getTime());
        shortUrl.setNewUrl(newUrl);
        
        ShortUrlDao dao = new ShortUrlDao();
        dao.save(shortUrl);
        
        return new ShortUrlDto(shortUrl.getNewUrl(), shortUrl.getExpiresAt());
    }
    
    public String findRedirectUrl(String url) throws UrlNotFoundException, UrlExpiredException {
        ShortUrlDao dao = new ShortUrlDao();
        ShortUrl shortUrl = dao.findByShortUrl(url);
        
        if (shortUrl != null) {
            if (shortUrlIsExpired(shortUrl)) {
                throw new UrlExpiredException();
            }
            
            String redirectUrl = shortUrl.getUrl();

            if (!redirectUrl.toLowerCase().startsWith("http://") && !redirectUrl.toLowerCase().startsWith("https://")) {
                redirectUrl = "http://"+redirectUrl;
            }
            return redirectUrl;
        } else {
            throw new UrlNotFoundException();
        }
    }
    
    private boolean shortUrlAlreadyExists(String url) {
        ShortUrlDao dao = new ShortUrlDao();
        ShortUrl shortUrl = dao.findByShortUrl(url);
        
        if (shortUrl != null) {
            return true;
        }
        return false;
    }
    
    private boolean shortUrlIsExpired(ShortUrl shortUrl) {
        if (shortUrl.getExpiresAt().compareTo(Calendar.getInstance().getTime()) < 0) {
            return true;
        }
        return false;
    }
}
