package com.sse;

import com.sse.service.LogParserService;

public class LogParserApplication {
    public static void main(String[] args) {

        LogParserService logParserService = new LogParserService();
//        logParserService.parseLogFile(args[0]);
        logParserService.parseLogFile("log.txt");
    }
}