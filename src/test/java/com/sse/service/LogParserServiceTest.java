package com.sse.service;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.sse.constants.RegexPatternConstants.KEY_VALUE_DETECTION_REGEX;

class LogParserServiceTest {

    @Test
    void testRegex()
    {
        String log = "timestamp=2024-02-24T16:22:20Z level=INFO message=\"Scheduled maintenance starting\" host=webserver1";
        Pattern pattern = Pattern.compile(KEY_VALUE_DETECTION_REGEX);
        Matcher matcher = pattern.matcher(log);

        while (matcher.find())
        {
            String key = matcher.group(1);
            String value = matcher.group(2);//.replaceAll("\"", "");;

            System.out.println("Key : "+key+" Value : "+value);
        }

    }
}