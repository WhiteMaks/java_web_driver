package com.whitemaks.github.web_driver;

import com.whitemaks.github.web_driver.steps.GooglePageSteps;
import com.whitemaks.github.web_driver.wrappers.WebDriver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BaseWebPageTest {
	private static final WebDriver driver = WebDriverFactory.createChromeDriver();

	@Test
	@DisplayName("Взаимодействие с поисковой строкой")
	public void searchField() {
		var googlePageSteps = new GooglePageSteps(driver);
		googlePageSteps.setValueInSearchField("Поиск нужной информации");
	}

	@AfterAll
	public static void cleanup() {
		WebDriverFactory.eliminateWebDriver();
	}
}
