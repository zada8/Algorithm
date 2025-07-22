/*
 * 1,3,5,7,9,7,5,3,1
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= N; i++) { //1행부터 N행까지
			
			for(int k = 1; k <= N-i; k++) { //공백 찍기
				System.out.print(" ");
			}
			for (int j = 1; j <= 2*i-1; j++) { //별 찍기
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = 1; i < N; i++) {  //N+1행부터 끝까지
			for (int k = 1; k<=i; k++) {
				System.out.print(" ");  //공백 찍기
			}
			for (int j = 0; j <2*(N-i)-1;j++) { //별 찍기
				System.out.print("*");
			}
			System.out.println();
		}
		
	}
}