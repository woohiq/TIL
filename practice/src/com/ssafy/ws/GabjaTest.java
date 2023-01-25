package com.ssafy.ws;
import java.io.*;
public class GabjaTest {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 십간과 십이지
		String[] Sipgan = {"갑", "을", "병", "정", "무", "기", "경", "신", "임", "계"};
		String[] Sipiji = {"자", "축", "인", "묘", "진", "사", "오", "미", "신", "유", "술", "해"};
		
		while (true) {
			// 입력받은 60갑자 -> Gapja
			System.out.print("60갑자를 입력하세요: ");
			String Gapja = br.readLine();
			
			if (Gapja.equals("종료")) return; // 종료 입력 -> 종료
			
			int Gapjanyun = 1444; // 갑자년이 1444년
			int YearsFromGapjanyun = 0; // 갑자년으로부터의 연도
			
			// 십간과 십이지로 만드는 60갑자와 입력 비교
			for (int i = 0; i <= 60; i++) {
				String NewGapja = Sipgan[i%10]+Sipiji[i%12];
				if (Gapja.equals(NewGapja)) break; // 같으면 그 때의 연도 받아오기
				else YearsFromGapjanyun++;
			}
			
			if (YearsFromGapjanyun > 60) {System.out.println("잘못된 입력"); continue;}// 입력을 못만들면, 잘못된 입력
			
			int result = Gapjanyun + YearsFromGapjanyun; // 입력된 60갑자 연도 = 갑자년 + 갑자년으로부터의 연도
			
			for (int i = 0; i < 13; i++) {
				result += 60; // 같은 60갑자 년도는 60년마다 돌아옴
				// 1800년 이상 2100년 이하이면 출력
				if (1800<=result && result<=2100) System.out.printf("%d ",result);
			}
			System.out.println("");
		}
		
	}
}
