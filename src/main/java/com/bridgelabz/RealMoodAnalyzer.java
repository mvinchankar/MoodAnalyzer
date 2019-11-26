package com.bridgelabz;

public class RealMoodAnalyzer {

    private String message;

    public RealMoodAnalyzer() {

    }

    public RealMoodAnalyzer(String message) {
        this.message = message;
    }

    public String analyzeMood() throws MoodAnalysisException {

        System.out.println("Ability to analyse and respond Happy or Sad Mood");
        try {
            if (message.length()==0)
                throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.ENTERED_EMPTY,"Please enter proper mood");
            if (message.contains("SAD")) {
                return "SAD";
            } else {
                return "HAPPY";
            }
        } catch (NullPointerException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.ENTERED_NULL, "Please enter proper mood");
        }
    }
    public boolean equals(Object another) {
        if (this.message.equals(((RealMoodAnalyzer) another).message))
            return true;
        return false;
    }
}
