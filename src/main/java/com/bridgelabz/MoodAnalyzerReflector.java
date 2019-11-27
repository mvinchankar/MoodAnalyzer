package com.bridgelabz;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyzerReflector {

    private String message;

    public static RealMoodAnalyzer createMoodAnalyzer() throws MoodAnalysisException {
        try {
            Class<?> moodAnalyzerClass = Class.forName("com.bridgelabz.RealMoodAnalyzer");
            Constructor<?> moodConstructor = moodAnalyzerClass.getConstructor();
            Object obj = moodConstructor.newInstance();
            return (RealMoodAnalyzer) obj;
        } catch (ClassNotFoundException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS, "enter correct class");
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD, "enter correct class");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static RealMoodAnalyzer createMoodAnalyzerWithParameters(String message) throws MoodAnalysisException {
        try {
            Class<?> moodAnalyzerClass = Class.forName("com.bridgelabz.RealMoodAnalyzer");
            Constructor<?> moodConstructor = moodAnalyzerClass.getConstructor(String.class);
            Object obj = moodConstructor.newInstance(message);
            return (RealMoodAnalyzer) obj;
        } catch (ClassNotFoundException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS, "enter correct class");
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD, "enter correct class");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object invokeMethod(Object moodAnalyzerObject, String methodName) throws MoodAnalysisException {
        try {
            return moodAnalyzerObject.getClass().getMethod(methodName).invoke(moodAnalyzerObject);
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD,
                    "Define proper method!......");
        } catch (InvocationTargetException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.METHOD_INVOCATION_ISSUE,
                    "May be Issue with Data Entered", e);
        } catch (IllegalAccessException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_ACCESS,"Not Accessible!",e);
        }
    }

    public static void setFieldValue(Object myObject, String fieldName, String fieldValue) throws MoodAnalysisException {
        try {
            Field field = myObject.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(myObject,fieldValue);
        } catch (NoSuchFieldException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD,
                    "Define Proper Field Name!......");
        } catch (IllegalAccessException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_ACCESS,
                    "May be Issue with Access", e);
        }

    }
}
