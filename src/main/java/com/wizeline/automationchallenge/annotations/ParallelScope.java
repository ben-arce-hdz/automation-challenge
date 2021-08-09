package com.wizeline.automationchallenge.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@Bean
@Scope("browserScope")
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ParallelScope {

}
