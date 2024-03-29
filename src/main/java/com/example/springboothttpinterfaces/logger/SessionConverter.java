package com.example.springboothttpinterfaces.logger;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

public class SessionConverter extends ClassicConverter {
    @Override
    public String convert(ILoggingEvent event) {
        RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
        if (attributes != null) {
            return attributes.getSessionId();
        }
        return "-";
    }
}
