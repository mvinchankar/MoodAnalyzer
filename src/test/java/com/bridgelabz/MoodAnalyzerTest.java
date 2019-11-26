package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyzerTest {

    @Test
    public void givenMessage_WhenSad_Should_Return_Sad() {
        RealMoodAnalyzer moodAnalyzer = new RealMoodAnalyzer("This is SAD Message");
        Assert.assertEquals("SAD", moodAnalyzer.analyzeMood());
    }

    @Test
    public void givenMessage_WhenHappy_Should_Return_Happy() {
        RealMoodAnalyzer moodAnalyzer = new RealMoodAnalyzer("This is HAPPY Message");
        Assert.assertEquals("HAPPY", moodAnalyzer.analyzeMood());
    }
}