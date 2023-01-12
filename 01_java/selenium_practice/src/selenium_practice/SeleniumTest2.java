package selenium_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

public class SeleniumTest2 {
	public static void main(String[] args) {
		// 변수에 넣기
		WebDriver driver = new ChromeDriver();
				
		// 내가 원하는 사이트 열어달라고 요청
		driver.get("https://www.naver.com/");

		// 증권 버튼 선택자를 가져오기
		WebElement financeBtn = driver.findElement(By.cssSelector("#NM_FAVORITE > div.group_nav > ul.list_nav.NM_FAVORITE_LIST > li:nth-child(3) > a"));
		
		// 버튼 클릭
		financeBtn.click();
		
		// 삼성전자 검색
		// 1. 검색창 선택
		// 검색창 선택자 가져오기
		WebElement searchInput = driver.findElement(By.cssSelector("#stock_items"));
		
		// 2. 삼성 전자 키워드 입력
		searchInput.sendKeys("삼성전자");
		
		// 3. 검색창 엔터 누르기
		searchInput.sendKeys(Keys.ENTER);
		
		/**********************************************
		 * 만약 자동완성이안되면 ctrl shift o 누르면 됨               *
		 **********************************************/
		
		
	}
}

