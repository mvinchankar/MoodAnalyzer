package com.bridgelabz;

public class RealMoodAnalyzer {

    private static String message;

    public RealMoodAnalyzer() {

    }

    public RealMoodAnalyzer(String message) {
        this.message = message;
    }

    public String analyzeMood() {

        System.out.println("Ability to analyse and respond Happy or Sad Mood");
        if (message.contains("SAD")) {
            return "SAD";
        } else {
            return "HAPPY";
        }
    }
}
