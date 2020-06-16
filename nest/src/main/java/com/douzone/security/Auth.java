package com.douzone.security;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Auth {
	public enum Role {GUEST, USER, ADMIN}
	
	String value() default "GUEST";

	public Role role() default Role.GUEST;
	boolean test() default false;
}