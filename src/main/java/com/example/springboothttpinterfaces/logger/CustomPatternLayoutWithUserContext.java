package com.example.springboothttpinterfaces.logger;

import ch.qos.logback.classic.PatternLayout;

public class CustomPatternLayoutWithUserContext extends PatternLayout {
    static {
        PatternLayout.DEFAULT_CONVERTER_MAP.put("user", UserConverter.class.getName());
        PatternLayout.DEFAULT_CONVERTER_MAP.put("session", SessionConverter.class.getName());
    }
}
