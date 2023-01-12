package selenium_practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
	public static void main(String[] args) {
		// 크롬 드라이버 이미 가져왔다
		
		// 변수에 넣기
		WebDriver driver = new ChromeDriver();
		
		// 내가 원하는 사이트 열어달라고 요청
		driver.get("https://www.naver.com/");
		
	}
}

