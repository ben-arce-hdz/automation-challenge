package com.wizeline.automationchallenge.config;

import static com.wizeline.automationchallenge.constants.Constants.*;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
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

	private final DesiredCapabilities dc = new DesiredCapabilities();
	
	@Value("${browser.isheadless:false}")
	private boolean isHeadless;
	
	@Value("${selenium.grid.url}")
	private URL url;
	
	@ParallelScope
	@ConditionalOnProperty(name="browser", havingValue="firefox")
	public WebDriver remoteFirefoxDriver() {
		FirefoxOptions fo = new FirefoxOptions();
		if (isHeadless)
			fo.addArguments(DISABLE_GPU, HEADLESS);
		dc.setCapability(FirefoxOptions.FIREFOX_OPTIONS, fo);
		return new RemoteWebDriver(this.url, dc);
	}
	
	@ParallelScope
	@ConditionalOnProperty(name="browser", havingValue="edge")
	public WebDriver remoteEdgeDriver() {
		EdgeOptions eo = new EdgeOptions();
		if (isHeadless)
			eo.addArguments(DISABLE_GPU, HEADLESS);
		dc.setCapability(EdgeOptions.CAPABILITY, eo);
		return new RemoteWebDriver(this.url,dc);
	}
	
	@ParallelScope
	@ConditionalOnMissingBean
	public WebDriver remoteChromeDriver() {	
		ChromeOptions co = new ChromeOptions();
		if (isHeadless)
			co.addArguments(DISABLE_GPU, HEADLESS, DISABLE_DEV_SHM, NO_SANDBOX);
        dc.setCapability(ChromeOptions.CAPABILITY, co);
		return new RemoteWebDriver(this.url,dc);
	}
}