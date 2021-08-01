package com.wizeline.automationchallenge.base;

import javax.annotation.PostConstruct;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class BasePage extends BaseWebElement{

	@Value("${app.url}")
	private String appUrl;
	
	@Autowired
	private WebDriver driver;
	
	@PostConstruct
	private void init() {
		PageFactory.initElements(this.driver, this);
	}
	
	public void openLoginPage() {
		log.info("Navigating to {}", appUrl);
		this.driver.get(appUrl);
	}
	
	public void close() {
		log.info("Closing webdriver...");
		this.driver.quit();
	}
}
