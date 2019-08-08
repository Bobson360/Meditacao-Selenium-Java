package pages;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.br.utils.Utils;

public class Meditacao extends Utils{
	
	static WebDriver driver;
	public static String file = "Meditação matinal";
	public String FileName;
	public static ArrayList<String> dias = new ArrayList<String>();
	public static int count = 0;
	static Date data =  new Date();

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
		System.out.print("_" + diaSemana.getText());
		System.out.print(", ");
		System.out.println(diaMes.getText() + "_");
		System.out.println();
		System.out.println();
		System.out.println("*" + Titulo.getText() + "*");
		System.out.println("");
		System.out.println("_" + versiculo.getText() + "_");
		System.out.println("");
		
		dias.add(diaMes.getText());
		
		
				file += "\n\n\n\n_";
				file += diaSemana.getText();
				file += ", ";
				file += diaMes.getText() + "_";
				file += "\n\n";
				file += "*" + Titulo.getText() + "*";
				file += "\n";
				file += "_" + versiculo.getText() + "_";
				file += "\n\n";
				
		Iterator<WebElement> IteratorConteudo = conteudo.iterator();
		while(IteratorConteudo.hasNext()) {
			String s = IteratorConteudo.next().getText();
			System.out.println();
			System.out.println(s);
			file += "\n\n";
			file += s;
		}
		
		WebElement nextLink	 = driver.findElement(By.xpath("//link[@rel='next']"));
		setURL(nextLink.getAttribute("href"));
		setFirstLink(true);
		setDays(27);
		count++;
		}
	
	public static void getFile() throws IOException {
		System.out.println(dias.get(0) +" à "+ dias.get(dias.size()-1));
		File dir = new File("C:\\Meditação").getCanonicalFile();
		
		try {
			if (dir.mkdir()) {
				System.out.println("Dir created: " + dir.getName());
				
			} else {
				System.out.println("Dir already exists.");
			}
			
			File myObj = new File("C:\\Meditação\\" + dias.get(0) +" à "+ dias.get(dias.size()-1)+".txt");
				if (myObj.createNewFile()) {
					FileWriter myWriter = new FileWriter("C:\\Meditação\\" + dias.get(0) +" à "+ dias.get(dias.size()-1)+".txt");
				      myWriter.write(file);
				      myWriter.close();
				      System.out.println("File created: " + myObj.getName());
				} else {
					System.out.println("filename.txt already exists.");
				}
			
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
	public static String getMonth() {
		Locale local = new Locale("pt","BR");
		DateFormat dateFormat = new SimpleDateFormat("MMMM",local); 
		System.out.println(dateFormat.format(data));
		return dateFormat.format(data);
	}
	}
		
		
		
		
		