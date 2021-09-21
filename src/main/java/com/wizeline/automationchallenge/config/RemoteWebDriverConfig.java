package com.wizeline.automationchallenge.config;

import static com.wizeline.automationchallenge.constants.Constants.*;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Profile;
import com.wizeline.automationchallenge.annotations.LazyConfiguration;
import com.wizeline.automationchallenge.annotations.ParallelScope;

@LazyConfiguration
@Profile("remote")
public class RemoteWebDriverConfig {

	@Value("${browser.isheadless:false}")
	private boolean isHeadless;
	
	@Value("${selenium.grid.url}")
	private URL url;
	
	@ParallelScope
	@ConditionalOnProperty(name="browser", havingValue="firefox")
	public WebDriver remoteFirefoxDriver() {
		var firefoxOptions = new FirefoxOptions();
		if (isHeadless)
			firefoxOptions.addArguments(DISABLE_GPU, HEADLESS);
		return new RemoteWebDriver(this.url, firefoxOptions);
	}
	
	@ParallelScope
	@ConditionalOnProperty(name="browser", havingValue="edge")
	public WebDriver remoteEdgeDriver() {
		var edgeOptions = new EdgeOptions();
		if (isHeadless)
			edgeOptions.addArguments(DISABLE_GPU, HEADLESS);
		return new RemoteWebDriver(this.url,edgeOptions);
	}
	
	@ParallelScope
	@ConditionalOnMissingBean
	public WebDriver remoteChromeDriver() {	
		var chromeOptions = new ChromeOptions();
		if (isHeadless)
			chromeOptions.addArguments(DISABLE_GPU, HEADLESS, DISABLE_DEV_SHM, NO_SANDBOX);
		return new RemoteWebDriver(this.url,chromeOptions);
	}
}