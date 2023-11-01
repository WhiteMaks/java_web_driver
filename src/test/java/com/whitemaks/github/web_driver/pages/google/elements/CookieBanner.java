package com.whitemaks.github.web_driver.pages.google.elements;

import com.whitemaks.github.web_driver.BaseWebElement;
import com.whitemaks.github.web_driver.wrappers.WebDriver;
import com.whitemaks.github.web_driver.wrappers.WebElement;

public class CookieBanner extends BaseWebElement {

	public CookieBanner(WebDriver webDriver, WebElement webElement) {
		super(webDriver, webElement);
	}

	public WebElement getButtonAccept() {
		return webElement.findElementById("W0wltc");
	}
}
