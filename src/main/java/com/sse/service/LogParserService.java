package com.sse.service;

import com.sse.helper.FileReadingHelper;
import com.sse.model.APMLog;
import com.sse.model.MetricLog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.sse.constants.LogParsingConstants.*;
import static com.sse.constants.RegexPatternConstants.KEY_VALUE_DETECTION_REGEX;

public class LogParserService {


    public void parseLogFile(String filePath)
    {
        FileReadingHelper fileReadingHelper = new FileReadingHelper();

        String textContent = fileReadingHelper.extractFileContent(filePath);

        String[] logParts = textContent.split(TIMESTAMP);

        HashMap<String,Integer> applicationLogs = new HashMap<>();

        List<APMLog>apmLogs = new ArrayList<>();
        List<MetricLog>requestMethodLogs = new ArrayList<>();

        for(String log : logParts)
        {
            if(log.contains(METRIC))
            {
                processAPMLog(log,apmLogs);
            }
            else if (log.contains(LEVEL))
            {
                processApplicationLog(log,applicationLogs);
            }
            else if (log.contains(REQUEST_METHOD))
            {
                processRequestMethodLog(log,requestMethodLogs);
            }
        }

        System.out.println(applicationLogs);


    }

    private void processApplicationLog(String log, HashMap<String,Integer> applicationLogs) {

        Pattern pattern = Pattern.compile(KEY_VALUE_DETECTION_REGEX);
        Matcher matcher = pattern.matcher(log);

        HashMap<String,String>keyValuePairs = new HashMap<>();

        while (matcher.find())
        {
            keyValuePairs.put(matcher.group(1),matcher.group(2));
        }

        if (keyValuePairs.containsKey(LEVEL))
        {
            Integer currentValueOfLogLevel = applicationLogs.getOrDefault(keyValuePairs.get(LEVEL),0);
            applicationLogs.put(keyValuePairs.get(LEVEL), currentValueOfLogLevel+1);
        }

    }

    private void processAPMLog(String log, List<APMLog> apmLogs) {

    }

    private void processRequestMethodLog(String log, List<MetricLog> requestMethodLogs) {

    }

}
