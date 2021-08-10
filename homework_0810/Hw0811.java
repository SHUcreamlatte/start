package com.koreait.crawling;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hw0811 {

	public static void main(String[] args) {
		String DRIVER_ID = "webdriver.chrome.driver";
		String DRIVER_PATH = "C:/SHUIT_2/JSP/chromedriver.exe";
		
		System.setProperty(DRIVER_ID, DRIVER_PATH);
		WebDriver driver = new ChromeDriver();
		
		String caffee_url = "https://www.banapresso.com/store";
		
		try {
			driver.get(caffee_url);
			Thread.sleep(1000);
			WebElement btn = driver.findElement(By.cssSelector("div.pagination>ul+span.btn_page"));
			while(true) {
				try {
					List<WebElement> num = driver.findElements(By.cssSelector("div.pagination>ul>li"));
					for(int j=0; j<num.size(); j++) {
						num.get(j).click();
						List<WebElement> store = driver.findElements(By.cssSelector("i"));
						List<WebElement> address = driver.findElements(By.cssSelector("span.store_name_map>span"));
						System.out.println("------" + num.get(j).getText() + "------");
						for(int i=0; i<store.size(); i++) {
							System.out.println(store.get(i).getText());
							System.out.println(address.get(i).getText());
							System.out.println(" ");
						}
						Thread.sleep(1000);
					}
					btn.click();
				}catch(Exception e) {
					System.out.println("프로그램 종료.");
					break;
				}
			}
	
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
