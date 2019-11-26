package com.bridgelabz;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyzerFactory {

    private String message;

    public static RealMoodAnalyzer createMoodAnalyzer(String message) {
        try {
            Class<?> moodAnalyzerClass = Class.forName("com.bridgelabz.RealMoodAnalyzer");
            Constructor<?> moodConstructor = moodAnalyzerClass.getConstructor(String.class);
            try {
                Object obj = moodConstructor.newInstance(message);
                return (RealMoodAnalyzer) obj;
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }
}
