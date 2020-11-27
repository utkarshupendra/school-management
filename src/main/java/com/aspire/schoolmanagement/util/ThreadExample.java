package com.aspire.schoolmanagement.util;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadExample extends Thread {
    @Override
    public void run() {
        log.info("Thread Example");
    }
}
