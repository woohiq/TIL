package day0203;

import com.google.gson.Gson;

public class Test1 {
	// 외부 라이브러리를 인식시키는 방법
	// 1. jre system library에 끼워 넣기 (별로 좋지않음)
	// 2. 프로젝트 외부에 있는 jar파일 인식시키기 (이식성 별로)
	// 3. 프로젝트 내부에 포럳를 만들고 jar 파일을 복사 한 후 인식시키기
	// - 프로젝트 폴더 우클릭 -> build path -> cconfigure build path
	// - library 탭 -> add jars...
	// 4. maven project로 바꾸고 pom.xml 에 dependenct 추가
	public static void main(String[] args) {
		Person p1 = new Person("Lee", 30, false, null, new String[] {"youtube", "cook"});
		
		// 자바 객체 -> JSON 문자열
		// Gson.toJson()
		
		Gson gson = new Gson();
		String str = gson.toJson(p1);
		System.out.println(p1);
		System.out.println(str);
	}
}
