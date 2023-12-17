package com.whitemaks.github.web_driver.steps;

import com.whitemaks.github.web_driver.pages.google.GooglePage;
import com.whitemaks.github.web_driver.wrappers.WebDriver;
import org.junit.jupiter.api.Assertions;

public class GooglePageSteps {
	private final GooglePage googlePage;

	public GooglePageSteps(WebDriver webDriver) {
		this.googlePage = new GooglePage(webDriver);

		acceptCookiesIfNeed();
	}

	public void setValueInSearchField(String value) {
		var searchFieldElement = googlePage.getSearchField()
				.getWebElement();

		Assertions.assertTrue(searchFieldElement.isFound(), "Поле для ввода поискового запроса должно быть найдено");
		Assertions.assertTrue(searchFieldElement.isDisplayed(), "Поле для ввода поискового запроса должно быть видно");
		Assertions.assertTrue(searchFieldElement.isEnabled(), "Поле для ввода поискового запроса должно быть активно");
		Assertions.assertTrue(searchFieldElement.sendKeys(value), "Ввод данных в поле для ввода поискового запроса должно быть успешно");
		Assertions.assertEquals(value, searchFieldElement.getValue(), "Значение в поле для ввода поискового запроса должно совпадать с введенным");
	}

	private void acceptCookiesIfNeed() {
		var cookieBanner = googlePage.getCookieBanner();
		if (cookieBanner.isFound()) {
			var acceptButton = cookieBanner.getButtonAccept();

			Assertions.assertTrue(acceptButton.isFound(), "Кнопка принития cookies должна быть найдена");
			Assertions.assertTrue(acceptButton.isDisplayed(), "Кнопка принития cookies должна быть видна");
			Assertions.assertTrue(acceptButton.isEnabled(), "Кнопка принития cookies должна быть активна");
			Assertions.assertTrue(acceptButton.click(), "Нажатие по кнопке принития cookies должно быть успешно");
		}
	}
}
