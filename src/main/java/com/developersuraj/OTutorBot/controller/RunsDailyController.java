package com.developersuraj.OTutorBot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class RunsDailyController {

    @Autowired
    public com.developersuraj.OTutorBot.service.runDailyAt12AM runDailyAt12AM;

    // This method will run daily at 12 PM
    @Scheduled(cron = "0 0 0 * * ?", zone = "Asia/Kolkata")
    public void runDailyTask() {
        runDailyAt12AM.runAt12AM();
    }
}
