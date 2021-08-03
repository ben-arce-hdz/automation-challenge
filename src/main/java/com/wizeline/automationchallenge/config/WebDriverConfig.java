package com.wizeline.automationchallenge.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import com.wizeline.automationchallenge.annotations.LazyConfiguration;

@LazyConfiguration
public class WebDriverConfig {

	@Bean
	@ConditionalOnProperty(name="browser", havingValue="firefox")
	@Scope("browserScope")
	public WebDriver firefoxDriver() {
		WebDriverManager.firefoxdriver().setup();
		return new FirefoxDriver();
	}
	
	@Bean
	@ConditionalOnMissingBean
	@Scope("browserScope")
	public WebDriver chromeDriver() {
		WebDriverManager.chromedriver().setup();
		return new ChromeDriver(new ChromeOptions().addArguments("start-maximized"));
	}
}