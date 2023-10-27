package com.whitemaks.github.web_driver;

import com.whitemaks.github.web_driver.wrappers.WebElement;

public abstract class BaseWebElement {
	protected final WebElement webElement;

	protected BaseWebElement(WebElement webElement) {
		this.webElement = webElement;
	}

	public boolean isFound() {
		return webElement.isFound();
	}

	protected WebElement findButtonByClassName(String className) {
		var tagButton = findButtonByClassName(
				"button",
				className
		);

		if (tagButton.isFound()) {
			return tagButton;
		}

		var tagInput = findButtonByClassName(
				"input",
				className
		);

		if (tagInput.isFound()) {
			return tagInput;
		}

		return findButtonByClassName(
				"a",
				className
		);
	}

	private WebElement findButtonByClassName(String tagName, String className) {
		return webElement.findElementByXpath(".//" + tagName + "[contains(@class, '" + className + "')]");
	}

	protected WebElement findButtonByName(String name) {
		var tagButton = findButtonByName(
				"button",
				name
		);

		if (tagButton.isFound()) {
			return tagButton;
		}

		var tagInput = findButtonByName(
				"input",
				name
		);

		if (tagInput.isFound()) {
			return tagInput;
		}

		return findButtonByName(
				"a",
				name
		);
	}

	private WebElement findButtonByName(String tagName, String name) {
		var buttonElement = webElement.findElementByXpath(".//" + tagName + "[contains(text(), '" + name + "')]");

		if (buttonElement.isFound()) {
			return buttonElement;
		}

		buttonElement = webElement.findElementByXpath(".//" + tagName + "[contains(., '" + name + "')]");

		if (buttonElement.isFound()) {
			return buttonElement;
		}

		return webElement.findElementByXpath(".//" + tagName + "[contains(@value, '" + name + "')]");
	}
}
