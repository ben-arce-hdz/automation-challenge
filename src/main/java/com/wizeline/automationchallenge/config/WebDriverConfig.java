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
import com.wizeline.automationchallenge.annotations.LazyConfiguration;
import com.wizeline.automationchallenge.annotations.ParallelScope;
import static com.wizeline.automationchallenge.constants.Constants.*;

@LazyConfiguration
public class WebDriverConfig {
		
	@Value("${browser.isheadless:false}")
	private boolean isHeadless;

	@ParallelScope
	@ConditionalOnProperty(name = "browser", havingValue = "firefox")
	public WebDriver firefoxDriver() {
		WebDriverManager.firefoxdriver().setup();
		FirefoxOptions fo = new FirefoxOptions();
		if (isHeadless)
			fo.addArguments(DISABLE_GPU, HEADLESS);
		return new FirefoxDriver(fo);
	}
	
	@ParallelScope
	@ConditionalOnProperty(name = "browser", havingValue = "edge")
	public WebDriver edgeDriver() {
		WebDriverManager.edgedriver().setup();
		EdgeOptions eo = new EdgeOptions();
		if (isHeadless)
			eo.addArguments(DISABLE_GPU, HEADLESS);
		eo.addArguments(START_MAXIMIZED);
		return new EdgeDriver(eo);
	}

	@ParallelScope
	@ConditionalOnMissingBean
	public WebDriver chromeDriver() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions co = new ChromeOptions();
		if (isHeadless)
			co.addArguments(DISABLE_GPU, HEADLESS);
		co.addArguments(START_MAXIMIZED);
		return new ChromeDriver(co);
	}
}