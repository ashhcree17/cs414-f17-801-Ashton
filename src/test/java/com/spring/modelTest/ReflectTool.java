package com.spring.modelTest;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/**
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
public class ReflectTool {
	public static <T extends Annotation> T getMethodAnnotation(Class<?> cl, 
		  String methodName, Class<T> annotation) {
		try {
			Method method = cl.getDeclaredMethod(methodName);
			return (T)method.getAnnotation(annotation);
		} catch (NoSuchMethodException nsme) {
			throw new RuntimeException(nsme);
		}
	}
	
	public static <T extends Annotation> T getFieldAnnotation(Class<?> cl, 
		String fieldName, Class<T> annotation) {
		try {
			Field field = cl.getDeclaredField(fieldName);
			return (T)field.getAnnotation(annotation);
		} catch (NoSuchFieldException nsfe) {
			throw new RuntimeException(nsfe);
		}
	}
	
	public static <T extends Annotation> T getClassAnnotation(Class<?> cl, 
		Class<T> annotation) {
		return (T) cl.getAnnotation(annotation);
	}
}