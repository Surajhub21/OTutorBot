package com.developersuraj.OTutorBot.controller;

import com.developersuraj.OTutorBot.service.RunDailyAt12PM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class RunsDailyController {

    @Autowired
    public RunDailyAt12PM runDailyAt12PM;

    // This method will run daily at 12 PM
    @Scheduled(cron = "0 0 12 * * ?", zone = "Asia/Kolkata")
    public void runDailyTask() {
        runDailyAt12PM.runAt12PM();
    }
}
