package com.wizeline.automationchallenge.config;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import java.time.Duration;

@Lazy
@Configuration
public class FluentWaitConfig {

  @Value("${webdriver.wait.timeout:30}")
  private int timeOut;
  
  private static final int POLLING = 5;

  @Bean
  public FluentWait<WebDriver> wait(WebDriver driver){
	return new FluentWait<WebDriver>(driver)
			    .withTimeout(Duration.ofSeconds(timeOut))
			    .pollingEvery(Duration.ofSeconds(POLLING))
			    .ignoring(NoSuchElementException.class);  
  }
}