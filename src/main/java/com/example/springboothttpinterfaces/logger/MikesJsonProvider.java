package com.example.springboothttpinterfaces.logger;

import ch.qos.logback.classic.spi.ILoggingEvent;
import com.fasterxml.jackson.core.JsonGenerator;
import net.logstash.logback.composite.AbstractJsonProvider;
import net.logstash.logback.composite.JsonWritingUtils;

import java.io.IOException;

public class MikesJsonProvider extends AbstractJsonProvider<ILoggingEvent> {

    @Override
    public void writeTo(JsonGenerator generator, ILoggingEvent iLoggingEvent) throws IOException {
        JsonWritingUtils.writeStringField(generator, "user", new UserConverter().convert(null));
        JsonWritingUtils.writeStringField(generator, "session", new SessionConverter().convert(null));
    }
}
