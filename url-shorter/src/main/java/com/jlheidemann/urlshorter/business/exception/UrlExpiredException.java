package com.jlheidemann.urlshorter.business.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author jeanl
 */
@ResponseStatus(value = HttpStatus.GONE)
public class UrlExpiredException extends Exception {
    
}
