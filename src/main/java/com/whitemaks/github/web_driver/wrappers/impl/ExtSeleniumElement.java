package com.whitemaks.github.web_driver.wrappers.impl;

import com.whitemaks.github.web_driver.wrappers.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;

import java.util.List;
import java.util.stream.Collectors;

public class ExtSeleniumElement implements WebElement {
	private final org.openqa.selenium.WebElement element;

	ExtSeleniumElement(org.openqa.selenium.WebElement element) {
		this.element = element;
	}

	@Override
	public boolean click() {
		if (!isFound()) {
			return false;
		}

		element.click();
		return true;
	}

	@Override
	public boolean clear() {
		element.clear();
		return true;
	}

	@Override
	public boolean isEnabled() {
		if (element == null) {
			return false;
		}

		return element.isEnabled();
	}

	@Override
	public boolean isSelected() {
		if (!isFound()) {
			return false;
		}

		return element.isSelected();
	}

	@Override
	public boolean isFound() {
		return element != null;
	}

	@Override
	public boolean isDisplayed() {
		if (!isFound()) {
			return false;
		}

		try {
			return element.isDisplayed();
		} catch (StaleElementReferenceException ex) {
			return false;
		}
	}

	@Override
	public boolean sendKeys(CharSequence... var1) {
		element.sendKeys(var1);
		return true;
	}

	@Override
	public String getText() {
		if (!isFound()) {
			return null;
		}

		return element.getText();
	}

	@Override
	public String getValue() {
		return getAttribute("value");
	}

	@Override
	public String visualHTMLElement() {
		return getAttribute("outerHTML");
	}

	@Override
	public String getAttribute(String attribute) {
		if (!isFound()) {
			return null;
		}

		return element.getAttribute(attribute);
	}

	@Override
	public WebElement findParentElement() {
		return findElementByXpath("./..");
	}

	@Override
	public WebElement findElementById(String id) {
		org.openqa.selenium.WebElement webElement = null;
		try {
			webElement = element.findElement(
					By.id(id)
			);
		} catch (NoSuchElementException ignored) {
		}
		return new ExtSeleniumElement(webElement);
	}

	@Override
	public WebElement findElementByType(String type) {
		return findElementByXpath(".//*[@type='" + type + "']");
	}

	@Override
	public WebElement findElementByXpath(String xpath) {
		org.openqa.selenium.WebElement webElement = null;
		try {
			webElement = element.findElement(
					By.xpath(xpath)
			);
		} catch (NoSuchElementException ignored) {
		}
		return new ExtSeleniumElement(webElement);
	}

	@Override
	public WebElement findElementByTagName(String tagName) {
		org.openqa.selenium.WebElement webElement = null;
		try {
			webElement = element.findElement(
					By.tagName(tagName)
			);
		} catch (NoSuchElementException ignored) {
		}
		return new ExtSeleniumElement(webElement);
	}

	@Override
	public WebElement findElementByClassName(String className) {
		return findElementByXpath(".//*[contains(@class,'" + className + "')]");
	}

	@Override
	public WebElement findElementByCssSelector(String cssSelector) {
		org.openqa.selenium.WebElement webElement = null;
		try {
			webElement = element.findElement(
					By.cssSelector(cssSelector)
			);
		} catch (NoSuchElementException ignored) {
		}
		return new ExtSeleniumElement(webElement);
	}

	@Override
	public WebElement findElementByText(String text) {
		return findElementByXpath(".//*[contains(text(),'" + text + "')]");
	}

	@Override
	public List<WebElement> getAllChildElements() {
		return findElementsByXpath("./*");
	}

	@Override
	public List<WebElement> findElementsByXpath(String xpath) {
		return convert(
				element.findElements(
						By.xpath(xpath)
				)
		);
	}

	@Override
	public List<WebElement> findElementsByTagName(String tagName) {
		return convert(
				element.findElements(
						By.tagName(tagName)
				)
		);
	}

	@Override
	public List<WebElement> findElementsByClassName(String className) {
		return findElementsByXpath(".//*[contains(@class,'" + className + "')]");
	}

	@Override
	public List<WebElement> findElementsByText(String text) {
		return findElementsByXpath(".//*[contains(text(),'" + text + "')]");
	}

	private List<WebElement> convert(List<org.openqa.selenium.WebElement> elements) {
		return elements.stream()
				.map(ExtSeleniumElement::new)
				.collect(Collectors.toList());
	}

	protected org.openqa.selenium.WebElement getBaseWebElement() {
		return element;
	}
}
