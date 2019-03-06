package com.vreasy.testapi.audit;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.actuate.trace.http.HttpExchangeTracer;
import org.springframework.boot.actuate.trace.http.Include;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuditConfiguration {
    
    @Bean 
    public HttpExchangeTracer httpExchangeTracer() {
        
        final Set<Include> allIncludes = new HashSet<Include>(Arrays.asList(Include.values()));
        
        final HttpExchangeTracer httpExchangeTracer = new CustomHttpExchangeTracer(allIncludes);
        
        return httpExchangeTracer;
        
    } 
    
    
    private final class CustomHttpExchangeTracer extends HttpExchangeTracer {

        public CustomHttpExchangeTracer(Set<Include> includes) {
            super(includes);
        }
    }

}
