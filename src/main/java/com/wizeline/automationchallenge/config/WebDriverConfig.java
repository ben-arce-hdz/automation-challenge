package com.wizeline.automationchallenge.config;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Profile;

import com.wizeline.automationchallenge.annotations.LazyConfiguration;
import com.wizeline.automationchallenge.annotations.ParallelScope;
import static com.wizeline.automationchallenge.constants.Constants.*;

@LazyConfiguration
@Profile("!remote")
public class WebDriverConfig {
		
	@Value("${browser.isheadless:false}")
	private boolean isHeadless;

	@ParallelScope
	@ConditionalOnProperty(name = "browser", havingValue = "firefox")
	public WebDriver firefoxDriver() {
		WebDriverManager.firefoxdriver().setup();
		var firefoxOptions = new FirefoxOptions();
		if (isHeadless)
			firefoxOptions.addArguments(DISABLE_GPU, HEADLESS);
		return new FirefoxDriver(firefoxOptions);
	}
	
	@ParallelScope
	@ConditionalOnProperty(name = "browser", havingValue = "edge")
	public WebDriver edgeDriver() {
		WebDriverManager.edgedriver().setup();
		var edgeOptions = new EdgeOptions();
		if (isHeadless)
			edgeOptions.addArguments(DISABLE_GPU, HEADLESS);
		edgeOptions.addArguments(START_MAXIMIZED);
		return new EdgeDriver(edgeOptions);
	}

	@ParallelScope
	@ConditionalOnMissingBean
	public WebDriver chromeDriver() {
		WebDriverManager.chromedriver().setup();
		var chromeOptions = new ChromeOptions();
		if (isHeadless)
			chromeOptions.addArguments(DISABLE_GPU, HEADLESS);
		chromeOptions.addArguments(START_MAXIMIZED);
		return new ChromeDriver(chromeOptions);
	}
}