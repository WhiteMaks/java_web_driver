package com.whitemaks.github.web_driver;

import com.whitemaks.github.web_driver.wrappers.WebDriver;
import com.whitemaks.github.web_driver.wrappers.impl.ExtSeleniumDriver;

import java.util.HashMap;
import java.util.Map;

public class WebDriverFactory {
	private static final Map<String, WebDriver> storage = new HashMap<>();

	public static WebDriver createChromeDriver() {
		var threadName = Thread.currentThread()
				.getName();

		var webDriver = storage.get(threadName);
		if (webDriver != null) {
			return webDriver;
		}

		webDriver = new ExtSeleniumDriver();
		storage.put(threadName, webDriver);

		return webDriver;
	}

	public static void eliminateWebDriver() {
		var threadName = Thread.currentThread()
				.getName();

		var webDriver = storage.get(threadName);
		if (webDriver != null) {
			webDriver.quit();
			storage.remove(threadName);
		}
	}

	public static Map<String, WebDriver> getStorage() {
		return storage;
	}
}
