package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Metodo {

	WebDriver driver;

	public void abrirNavegador(String url, String navegador) throws IOException {

		if (navegador == "Chrome" || navegador == "Edge" || navegador == "Firefox") {
			if (navegador == "Chrome") {
				System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\Chrome\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.get(url);
				driver.manage().window().maximize();
			} else if (navegador == "Edge") {
				System.setProperty("webdriver.edge.driver", ".\\src\\Drivers\\msedgedriver.exe");
				driver = new EdgeDriver();
				driver.get(url);
				driver.manage().window().maximize();
			} else if (navegador == "Firefox") {
				System.setProperty("webdriver.gecko.driver", ".\\src\\Drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
				driver.get(url);
				driver.manage().window().maximize();
			}

		} else {
			System.out.println("Op��o inv�lida, escolha Chrome, Edge ou Firefox");
		}

	}

}
