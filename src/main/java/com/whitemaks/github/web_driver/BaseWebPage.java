package com.whitemaks.github.web_driver;

import com.whitemaks.github.web_driver.wrappers.WebDriver;
import com.whitemaks.github.web_driver.wrappers.WebElement;

public abstract class BaseWebPage {
	private final WebDriver webDriver;

	protected BaseWebPage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	protected WebElement getRootElement() {
		return webDriver.getRootElement();
	}

	protected void refreshPage() {
		webDriver.refresh();
	}
}
