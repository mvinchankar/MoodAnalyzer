package com.bridgelabz;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyzerReflector {

    private String message;

    public static Constructor<?> getConstructor(Class<?>... param) throws MoodAnalysisException {
        try {
            Class<?> moodAnalyzerClass = Class.forName("com.bridgelabz.RealMoodAnalyzer");
            return moodAnalyzerClass.getConstructor(param);
        } catch (ClassNotFoundException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS, "enter correct class");
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD, "enter correct class");
        }
    }
    public static Object createMoodAnalyzer(Constructor<?> constructor,Object ... message) throws MoodAnalysisException {
        try {
            return constructor.newInstance(message);
        } catch (IllegalAccessException | InstantiationException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_ACCESS, "Not Accessible!", e);
        } catch (InvocationTargetException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.METHOD_INVOCATION_ISSUE,
                    "May be Issue with Data Entered", e);
        }
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
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_ACCESS, "Not Accessible!", e);
        }
    }

    public static void setFieldValue(Object myObject, String fieldName, String fieldValue) throws MoodAnalysisException {
        try {
            Field field = myObject.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(myObject, fieldValue);
        } catch (NoSuchFieldException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_FIELD,
                    "Define Proper Field Name!......");
        } catch (IllegalAccessException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_ACCESS,
                    "May be Issue with Access", e);
        }

    }
}
