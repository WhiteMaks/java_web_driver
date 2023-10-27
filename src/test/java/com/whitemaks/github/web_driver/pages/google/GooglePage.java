package com.whitemaks.github.web_driver.pages.google;

import com.whitemaks.github.web_driver.BaseWebPage;
import com.whitemaks.github.web_driver.pages.google.elements.CookieBanner;
import com.whitemaks.github.web_driver.pages.google.elements.SearchField;
import com.whitemaks.github.web_driver.wrappers.WebDriver;

public class GooglePage extends BaseWebPage {

	public GooglePage(WebDriver webDriver) {
		super(webDriver);

		webDriver.openUrl("https://www.google.com/");
	}

	public CookieBanner getCookieBanner() {
		return new CookieBanner(getRootElement().findElementByClassName("dbsFrd"));
	}

	public SearchField getSearchField() {
		return new SearchField(getRootElement().findElementByTagName("textarea"));
	}
}
