package com.ssafy.ws;
import java.io.*;
public class Season1{
	public static void main(String[] args)throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (;;) {
			System.out.print("월 입력>>");
			int N = Integer.parseInt(br.readLine());
			if (3<=N && N<=5) System.out.printf("%d월은 봄입니다.\n",N);
			else if (6<=N && N<=8) System.out.printf("%d월은 여름입니다.\n",N);
			else if (9<=N && N<=11) System.out.printf("%d월은 가을입니다.\n",N);
			else if (N==12||N<=2) System.out.printf("%d월은 겨울입니다.\n",N);
			else break;
		}
	}

	
}
