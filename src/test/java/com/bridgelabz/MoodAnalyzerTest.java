package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyzerTest {

    @Test
    public void givenMessage_WhenSad_Should_Return_Sad() {
        RealMoodAnalyzer moodAnalyzer = new RealMoodAnalyzer("This is SAD Message");
        try {
            Assert.assertEquals("SAD", moodAnalyzer.analyzeMood());
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMessage_WhenHappy_Should_Return_Happy() {
        RealMoodAnalyzer moodAnalyzer = new RealMoodAnalyzer("This is HAPPY Message");
        try {
            Assert.assertEquals(moodAnalyzer.analyzeMood(), "HAPPY");
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMessage_WhenNull_Should_Return_Happy() {
        RealMoodAnalyzer moodAnalyzer = new RealMoodAnalyzer(null);
        try {
            Assert.assertEquals("HAPPY", moodAnalyzer.analyzeMood());
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void given_Null_Mood_Should_Throw_Exception() {
        RealMoodAnalyzer moodAnalyzer = new RealMoodAnalyzer(null);
        try {
            moodAnalyzer.analyzeMood();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.ENTERED_NULL, e.type);
        }
    }

    @Test
    public void given_Empty_Mood_Should_Throw_Exception() {
        RealMoodAnalyzer moodAnalyzer = new RealMoodAnalyzer();
        try {
            moodAnalyzer.analyzeMood();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.ENTERED_EMPTY, e.type);
        }
    }
    @Test
    public void givenMessage_WhenProper_Should_Return_Object() {
        RealMoodAnalyzer moodAnalyzer = MoodAnalyzerFactory.createMoodAnalyzer("I am in happy mood");
        Assert.assertEquals(new RealMoodAnalyzer("I am in happy mood"),moodAnalyzer);
    }


}