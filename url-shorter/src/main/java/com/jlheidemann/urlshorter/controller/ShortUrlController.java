package com.jlheidemann.urlshorter.controller;

import com.jlheidemann.urlshorter.business.UrlShorter;
import com.jlheidemann.urlshorter.business.exception.UrlExpiredException;
import com.jlheidemann.urlshorter.business.exception.UrlNotFoundException;
import com.jlheidemann.urlshorter.dto.ShortUrlDto;
import com.jlheidemann.urlshorter.util.Constants;
import java.io.IOException;
import java.net.URISyntaxException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author jeanl
 */
@RestController
public class ShortUrlController {
    @PostMapping("/short")
    public ShortUrlDto shortenUrl(@RequestBody String url) {
        UrlShorter shorter = new UrlShorter();
        return shorter.shortenUrl(url);
    }
    
    @GetMapping("/{url}")
    public RedirectView  redirect(HttpServletResponse httpServletResponse, @PathVariable("url") String url) throws URISyntaxException, IOException, UrlNotFoundException, UrlExpiredException {
        UrlShorter shorter = new UrlShorter();
        String redirectUrl;
        RedirectView redirectView = new RedirectView();
        redirectUrl = shorter.findRedirectUrl(Constants.DOMAIN + url);

        if (redirectUrl != null && !"".equals(redirectUrl)) {
            redirectView.setUrl(redirectUrl);
            return redirectView;
        } else {
            throw new UrlNotFoundException();
        }
        
    }
}
