package test;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.br.utils.Utils;

import pages.Meditacao;

public class MeditacaoTest extends Utils {

	static WebDriver driver;
	static Meditacao meditacao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		// chamar os exe
		System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
		// System.setProperty("webdriver.gecko.driver", "C:/geckodriver.exe");

		driver = new ChromeDriver();
		// driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		meditacao = new Meditacao(driver);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
//		driver.close();
	}

	@Test
	public void test() {
		if (!getFirstLink()) {
			driver.get(getURL());
			driver.findElement(By.xpath("//span[@class='mdl-button__ripple-container']")).click();
			Meditacao.mapElements();
		}
		for (int i = 0; i < getDays(); i++) {
			driver.get(getURL());
			Meditacao.mapElements();
		}
	}

	

}
