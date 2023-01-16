package com.ssafy.ws;
import java.io.*;
import java.util.StringTokenizer;
public class GetDate {
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        // 입력받기
        int month = Integer.parseInt(st.nextToken());
        int date = Integer.parseInt(st.nextToken());
        int total_date = 0;
        
        // month에 따라 날짜 추가
        switch(month){
            case 12: total_date += 30; // 12월 -> 1~11월 전부 지남
            case 11: total_date += 31;
            case 10: total_date += 30;
            case 9: total_date += 31;
            case 8: total_date += 31;
            case 7: total_date += 30;
            case 6: total_date += 31;
            case 5: total_date += 30;
            case 4: total_date += 31;
            case 3: total_date += 28; // 3월 -> 1,2월 전부 지남 -> +28+31
            case 2: total_date += 31; // 2월 -> 1월 전부 지남 -> +31
        }
        
        // date에 따른 날짜 추가 
        total_date += date;
        
        System.out.printf("%d월 %d일은 %d번째 날입니다.", month, date, total_date);
        
    }
}

