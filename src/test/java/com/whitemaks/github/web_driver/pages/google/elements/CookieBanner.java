package com.whitemaks.github.web_driver.pages.google.elements;

import com.whitemaks.github.web_driver.BaseWebElement;
import com.whitemaks.github.web_driver.wrappers.WebElement;

public class CookieBanner extends BaseWebElement {

	public CookieBanner(WebElement webElement) {
		super(webElement);
	}

	public WebElement getButtonAccept() {
		return webElement.findElementById("W0wltc");
	}
}
