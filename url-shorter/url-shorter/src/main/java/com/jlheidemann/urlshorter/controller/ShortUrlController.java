package com.jlheidemann.urlshorter.controller;

import com.jlheidemann.urlshorter.UrlShorter;
import com.jlheidemann.urlshorter.dto.ShortUrlDto;
import com.jlheidemann.urlshorter.entity.ShortUrl;
import java.util.Calendar;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jean.heidemann
 */
@RestController
public class ShortUrlController {
    private final AtomicLong counter = new AtomicLong();


    @PostMapping("/short")
    public ShortUrlDto shortenUrl(@RequestBody String url) {
        UrlShorter urlShorter = new UrlShorter();
        urlShorter.shortenUrl(url);
        
        return new ShortUrlDto("newUrl aqui", Calendar.getInstance().getTime());
    }
}
