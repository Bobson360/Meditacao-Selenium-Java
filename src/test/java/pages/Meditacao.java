package pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.br.utils.Utils;

public class Meditacao extends Utils{
	
	static WebDriver driver;

	public Meditacao(WebDriver driver) {
		
		this.driver = driver;
	}
	
	@SuppressWarnings("unused")
	public static void mapElements() {
		WebElement diaSemana = driver.findElement(By.xpath("//div[@class='descriptionText diaSemanaMeditacao']"));
		WebElement diaMes	 = driver.findElement(By.xpath("//div[@class='descriptionText diaMesMeditacao']"));
		WebElement Titulo	 = driver.findElement(By.xpath("//div[@class='mdl-typography--headline']"));
		WebElement versiculo = driver.findElement(By.xpath("//div[@class='descriptionText versoBiblico']"));
		List<WebElement> conteudo  = driver.findElements(By.xpath("//div[@class='conteudoMeditacao']//p"));
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.print(/*"_" +*/ diaSemana.getText());
		System.out.print(", ");
		System.out.println(diaMes.getText() /*+ "_"*/);
		System.out.println();
		System.out.println();
		System.out.println(/*"*" + */Titulo.getText()/* + "*"*/);
		System.out.println("");
		System.out.println(/*"_" + */versiculo.getText()/* + "_"*/);
		System.out.println("");
		
		Iterator<WebElement> IteratorConteudo = conteudo.iterator();
		while(IteratorConteudo.hasNext()) {
			System.out.println(IteratorConteudo.next().getText());
			System.out.println("");
		}
		
		WebElement nextLink	 = driver.findElement(By.xpath("//link[@rel='next']"));
		setURL(nextLink.getAttribute("href"));
		setFirstLink(true);
		setDays(16);
		}
	}
		
		
		
		
		