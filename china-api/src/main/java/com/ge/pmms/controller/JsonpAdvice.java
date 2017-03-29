package com.ge.pmms.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

/**
 * Controller Advice to wrap JSON Responses in JSONP wrapper callbacks.
 * 
 * 
 *
 */
@ControllerAdvice
public class JsonpAdvice extends AbstractJsonpResponseBodyAdvice {
	
    public JsonpAdvice() {
        super("callback");
    }
    
} 
