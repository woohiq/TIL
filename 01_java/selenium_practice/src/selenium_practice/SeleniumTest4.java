package selenium_practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest4 {
	public static void main(String[] args) {
		
		// 변수에 넣기
		WebDriver driver = new ChromeDriver();
					
		// 내가 원하는 사이트 열어달라고 요청
		//driver.get("https://etk.srail.kr/main.do/");
		driver.get("https://www.letskorail.com/");
		
		System.out.println(driver.getWindowHandles());
		
		// 팝업창 중 main 창
		String mainPage = driver.getWindowHandle();
		
		// 팝업창 중 main이 아닌 창 닫기
		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(mainPage)) /* check if same or not */{
				driver.switchTo().window(handle).close();
			}
		}
		
		driver.switchTo().window(mainPage);
		
	}
}

