package com.jlheidemann.urlshorter.business;

import com.jlheidemann.urlshorter.business.exception.UrlExpiredException;
import com.jlheidemann.urlshorter.business.exception.UrlNotFoundException;
import com.jlheidemann.urlshorter.dao.ShortUrlDao;
import com.jlheidemann.urlshorter.dto.ShortUrlDto;
import com.jlheidemann.urlshorter.entity.ShortUrl;
import com.jlheidemann.urlshorter.util.Constants;
import com.jlheidemann.urlshorter.util.UrlShortener;
import java.util.Calendar;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author jeanl
 */
public class UrlShorter {
    public ShortUrlDto shortenUrl(String url) {
        UrlShortener shortener = new UrlShortener();
        String newUrl = shortener.shortenURL(url);
        
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, Constants.EXPIRATION_DAYS);
        
        //TODO: encurtar URL
        ShortUrl shortUrl = new ShortUrl();
        shortUrl.setId(1);
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
            if (shortUrl.getExpiresAt().compareTo(Calendar.getInstance().getTime()) < 0) {
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
}
