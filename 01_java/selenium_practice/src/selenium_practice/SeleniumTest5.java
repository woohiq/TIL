package selenium_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumTest5 {
	public static void main(String[] args) {
		
		// 변수에 넣기
		WebDriver driver = new ChromeDriver();
					
		// 내가 원하는 사이트 열어달라고 요청
		//driver.get("https://etk.srail.kr/main.do/");
		driver.get("https://etk.srail.kr/main.do");
		
		// 출발역지정
		Select departure = new Select(driver.findElement(By.name("dptRsStnCd")));
		departure.selectByVisibleText("수서");
		
		// 출발역지정
		Select arrival = new Select(driver.findElement(By.name("arvRsStnCd")));
		arrival.selectByValue("0020");
		
		// 버튼 클릭
		driver.findElement(By.cssSelector("#search-form > fieldset > a")).click();
		driver.findElement(By.className("mgt5")).click();
		
		
		
		
	}
}
