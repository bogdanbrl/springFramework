package com.criptex;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloMaven {

    public final static Logger log = LoggerFactory.getLogger(HelloMaven.class);

    public static void main(String[] args) {
        log.info("Hello Info");
        log.debug("Hello Debug");
    }
}