package com.whitemaks.github.web_driver.pages.google.elements;

import com.whitemaks.github.web_driver.BaseWebElement;
import com.whitemaks.github.web_driver.wrappers.WebDriver;
import com.whitemaks.github.web_driver.wrappers.WebElement;

public class SearchField extends BaseWebElement {

	public SearchField(WebDriver webDriver, WebElement webElement) {
		super(webDriver, webElement);
	}

	public boolean setValue(String value) {
		return webElement.sendKeys(value);
	}

	public String getValue() {
		return webElement.getValue();
	}

	public WebElement getWebElement() {
		return webElement;
	}
}
