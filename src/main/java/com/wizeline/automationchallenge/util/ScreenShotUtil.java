package com.wizeline.automationchallenge.util;

import java.io.IOException;
import java.nio.file.Path;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

@Lazy
@Service
public class ScreenShotUtil {

	private static final String PNG= ".png";
	private static final String IMAGE= "image_";
	private final SimpleDateFormat sdf = new SimpleDateFormat("yy.MM.dd.HH.mm.ss");

	@Value("${screenshot.path}")
	private Path path;
	
	@Autowired
	private ApplicationContext ctx;
	
	public byte[] takeScreenShot() throws IOException {
		var sourceFile = this.ctx.getBean(TakesScreenshot.class).getScreenshotAs(OutputType.FILE);
		var timestamp = new Timestamp(System.currentTimeMillis());
		FileCopyUtils.copy(sourceFile, path.resolve(IMAGE + sdf.format(timestamp) + PNG).toFile());
		return FileUtils.readFileToByteArray(sourceFile);
	}
}