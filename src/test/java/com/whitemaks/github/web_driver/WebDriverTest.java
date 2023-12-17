package com.whitemaks.github.web_driver;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.NoSuchSessionException;

public class WebDriverTest {

	@AfterAll
	public static void cleanup() {
		WebDriverFactory.eliminateWebDriver();
	}

	@Test
	@DisplayName("Открытие браузера и проверка url")
	public void openBrowser() {
		var driver = WebDriverFactory.createChromeDriver();

		var expectedUrl = "https://www.google.com/";

		driver.openUrl(expectedUrl);

		var actualUrl = driver.getCurrentUrl();

		Assertions.assertEquals(expectedUrl, actualUrl, "Не совпадают url");

		WebDriverFactory.eliminateWebDriver();
	}

	@Test
	@DisplayName("Только один web driver на поток")
	public void onlyOneWebDriverInThread() {
		WebDriverFactory.createChromeDriver();
		Assertions.assertEquals(1, WebDriverFactory.getStorage().size(), "После создания web driver в текущем потоке должна быть одна запись");

		WebDriverFactory.createChromeDriver();
		Assertions.assertEquals(1, WebDriverFactory.getStorage().size(), "После повторного создания web driver в текущем потоке должна быть одна запись");

		WebDriverFactory.eliminateWebDriver();
	}

	@Test
	@DisplayName("Ликвидация браузера в текущем потоке")
	public void eliminateWebDriver() {
		var driver = WebDriverFactory.createChromeDriver();
		Assertions.assertEquals(1, WebDriverFactory.getStorage().size(), "После создания web driver в текущем потоке должна быть одна запись");

		WebDriverFactory.eliminateWebDriver();
		Assertions.assertEquals(0, WebDriverFactory.getStorage().size(), "После ликвидации web driver в текущем потоке не должно быть записей");

		Assertions.assertThrows(NoSuchSessionException.class, () -> driver.openUrl("https://www.google.com/"), "После ликвидации браузера не должно быть возможным использовать созданный web driver");
	}
}
