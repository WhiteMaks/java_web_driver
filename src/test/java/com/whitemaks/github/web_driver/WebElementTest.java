package com.whitemaks.github.web_driver;

import com.whitemaks.github.web_driver.wrappers.WebDriver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WebElementTest {
	private static final WebDriver driver = WebDriverFactory.createChromeDriver();

	@BeforeAll
	public static void init() {
		driver.openUrl("https://www.google.com/");
	}

	@Test
	@DisplayName("Поиск не существующего елемента по class")
	public void searchNonExistentElementByClassName() {
		var nonExistElement = driver.getRootElement()
				.findElementByClassName("non_exist_class_name");

		Assertions.assertFalse(nonExistElement.isFound(), "Для не существующего элемента индикатор isFound должен быть false");
		Assertions.assertFalse(nonExistElement.isDisplayed(), "Для не существующего элемента индикатор isDisplayed должен быть false");
		Assertions.assertFalse(nonExistElement.isEnabled(), "Для не существующего элемента индикатор isEnabled должен быть false");
		Assertions.assertFalse(nonExistElement.isSelected(), "Для не существующего элемента индикатор isSelected должен быть false");
		Assertions.assertFalse(nonExistElement.click(), "Для не существующего элемента метод click должен возвращать false");
		Assertions.assertNull(nonExistElement.getValue(), "Для не существующего элемента метод getValue должен возвращать null");
		Assertions.assertNull(nonExistElement.getText(), "Для не существующего элемента метод getText должен возвращать null");
	}

	@AfterAll
	public static void cleanup() {
		WebDriverFactory.eliminateWebDriver();
	}
}
