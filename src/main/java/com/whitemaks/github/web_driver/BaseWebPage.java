package com.whitemaks.github.web_driver;

import com.whitemaks.github.web_driver.wrappers.WebDriver;
import com.whitemaks.github.web_driver.wrappers.WebElement;

public abstract class BaseWebPage extends BaseWebElement {

	protected BaseWebPage(WebDriver webDriver) {
		super(webDriver, webDriver.getRootElement());
	}

	protected WebElement getRootElement() {
		return webDriver.getRootElement();
	}

	public void refreshPage() {
		webDriver.refresh();
	}

	public boolean contextMenuOnWebElement(WebElement webElement) {
		return webDriver.contextMenu(webElement);
	}
}
