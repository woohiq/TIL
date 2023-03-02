package com.ssafy.ws;
import java.io.*;
import java.util.Arrays;
public class ProductValue {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 상품의 개수 입력받기
		int number_of_product = Integer.parseInt(br.readLine());
		
		// 상품의 가격을 저장하기 위한 배열 만들기
		int[] productValues = new int[number_of_product];
		
		// 상품의 가격 입력받기
		for (int i = 0; i<number_of_product; i++) {
			productValues[i] = Integer.parseInt(br.readLine());
		}
		
		// 배열 복사 ( 나중에 순위 비교를 위해 )
		int[] productValuesOriginal = Arrays.copyOf(productValues,number_of_product);
		
		// 배열 오름 차순 정렬
		Arrays.sort(productValues);
		// 내림 차순으로 정렬 해 주기 위해 배열 뒤집기
		int[] reversedProductValues = new int[number_of_product];
		for (int i = 0; i<number_of_product; i++) reversedProductValues[i] = productValues[number_of_product-1-i];
		
		// 내림 차순 정렬된 배열과 기존 배열을 비교하여 상품의 가치 순위 판단
		for (int i = 0; i<number_of_product; i++) {
			for (int j = 0; j<number_of_product; j++) {
				if (productValuesOriginal[i] == reversedProductValues[j]) {
					// 나보다 좋은 상품 0개 -> 1위
					// 나보다 좋은 상품 1개 -> 2위
					// 나보다 좋은 상품 n개 -> (n+1)위 이므로 j가 아닌 j+1을 출력
					System.out.printf("%d ",j+1); 
					break;
				}
			}
		}
	}
}
