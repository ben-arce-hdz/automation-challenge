package com.wizeline.automationchallenge.config;

import java.util.Objects;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.SimpleThreadScope;

/**
 * **DO NOT MODIFY THIS CLASS**
 * 
 * New scope was created in order to enable parallel testing, since, "thread"
 * scope did not satisfy the needs for "parallel" testing
 * 
 * @author barce
 */
@Configuration
public class BrowserScopeConfig {
	@Bean
	public static BeanFactoryPostProcessor beanFactoryPostProcessor() {
		return new BrowserScopePostProcessor();
	}
}

/**
 * This class is in charge to register the custom scope
 * 
 * @author barce
 */
class BrowserScopePostProcessor implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		beanFactory.registerScope("browserScope", new BrowserScope());
	}
}

/**
 * This class validates override the method "get" in order to add a condition if
 * a WebDriver sessionId is quit for some reason, it returns a new webdriver
 * sessionId.
 * 
 * @author barce
 */
class BrowserScope extends SimpleThreadScope {

	@Override
	public Object get(String name, ObjectFactory<?> objectFactory) {
		Object o = super.get(name, objectFactory);
		SessionId sessionId = ((RemoteWebDriver) o).getSessionId();
		if (Objects.isNull(sessionId)) {
			super.remove(name);
			o = super.get(name, objectFactory);
		}
		return o;
	}

	@Override
	public void registerDestructionCallback(String name, Runnable callback) {
		super.registerDestructionCallback(name, callback);
	}
}
