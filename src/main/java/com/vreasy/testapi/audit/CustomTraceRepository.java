package com.vreasy.testapi.audit;

import org.springframework.boot.actuate.trace.http.InMemoryHttpTraceRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CustomTraceRepository extends InMemoryHttpTraceRepository {
    
    public CustomTraceRepository() {
        super.setCapacity(200);
    }

}
