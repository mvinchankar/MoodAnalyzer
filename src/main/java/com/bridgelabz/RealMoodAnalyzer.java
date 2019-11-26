package com.bridgelabz;

public class RealMoodAnalyzer {

    private static String message;

    public RealMoodAnalyzer() {

    }

    public RealMoodAnalyzer(String message) {
        this.message = message;
    }

    public String analyzeMood() throws MoodAnalysisException {

        System.out.println("Ability to analyse and respond Happy or Sad Mood");
        try {
            if (message.contains("SAD")) {
                return "SAD";
            } else {
                return "HAPPY";
            }
        } catch (NullPointerException e) {
            return "Please Enter Valid Mood!!!!!!!!";
        }
    }
}
