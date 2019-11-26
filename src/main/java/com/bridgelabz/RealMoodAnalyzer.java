package com.bridgelabz;

public class RealMoodAnalyzer {

    public String analyzeMood(String message) {

        System.out.println("Ability to analyse and respond Happy or Sad Mood");
        if (message.contains("SAD")) {
            return "SAD";
        } else {
            return "HAPPY";
        }
    }
}
