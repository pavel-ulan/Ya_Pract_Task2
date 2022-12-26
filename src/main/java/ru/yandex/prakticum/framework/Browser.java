package ru.yandex.prakticum.framework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Browser {
    private static final String PROPERTY = "WebDriver";

    private static WebDriver INSTANCE = null;

    static {
        Properties properties = new Properties();
        try (FileReader f = new FileReader("src/test/resources/browser.properties")) {
            properties.load(f);
            System.setProperty(PROPERTY, properties.getProperty(PROPERTY));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Browser() {
    }

    public static WebDriver getInstance() {
        if (INSTANCE == null) {
            if ("firefox".equals(System.getProperty(PROPERTY))) {
                WebDriverManager.firefoxdriver().setup();
                INSTANCE = new FirefoxDriver();
            } else {
                WebDriverManager.chromedriver().setup();
                INSTANCE = new ChromeDriver();
            }
        }
        return INSTANCE;
    }

    public static void closeInstance() {
        INSTANCE.quit();
        INSTANCE = null;
    }
}
