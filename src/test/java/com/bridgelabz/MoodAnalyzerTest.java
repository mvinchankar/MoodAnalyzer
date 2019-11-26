package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyzerTest {

    @Test
    public void givenMessage_WhenSad_Should_Return_Sad() {
        RealMoodAnalyzer moodAnalyzer = new RealMoodAnalyzer();
        Assert.assertEquals("SAD", moodAnalyzer.analyzeMood("This is sad message"));
    }

    @Test
    public void givenMessage_WhenHappy_Should_Return_Happy() {
        RealMoodAnalyzer moodAnalyzer = new RealMoodAnalyzer();
        Assert.assertEquals("HAPPY", moodAnalyzer.analyzeMood("THIS IS HAPPY MESSAGE"));
    }
}