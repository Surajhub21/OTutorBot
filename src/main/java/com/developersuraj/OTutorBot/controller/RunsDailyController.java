package com.developersuraj.OTutorBot.controller;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class RunsDailyController {
    // This method will run daily at 12 PM
    @Scheduled(cron = "0 0 12 * * ?")
    public void runDailyTask() {
        System.out.println("Running daily task at 12 PM");
        // Add your task logic here

    }
}
