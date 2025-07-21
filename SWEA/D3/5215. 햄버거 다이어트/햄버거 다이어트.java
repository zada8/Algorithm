import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); //테스트케이스 갯수
		
		for (int i = 1; i <= T; i ++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());   //재료의 수 N
			int L = Integer.parseInt(st.nextToken());   //제한 칼로리 L
			
			int[] score_list = new int[N]; //맛 점수 리스트
			int[] cal_list = new int[N];//칼로리 리스트
			
			for (int n = 0; n < N; n++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				score_list[n] = Integer.parseInt(st2.nextToken());
				cal_list[n] = Integer.parseInt(st2.nextToken());
			}
			
			//2차원 배열 만들기
			int[][] dp_list = new int[N+1][L+1];
			
			for (int k =0; k<= N; k++) {
				for (int j = 0; j <= L; j++) {
					
					if (k == 0 || j ==0) {
						dp_list[k][j] = 0;
					} 
					else if(cal_list[k-1] <= j) {
						dp_list[k][j] = Math.max(score_list[k-1] + dp_list[k-1][j - cal_list[k-1]], dp_list[k-1][j]);
					}
					else {
						dp_list[k][j] = dp_list[k-1][j];
					}
				}
			}
			
			System.out.println("#"+i+" "+dp_list[N][L]);
			
			
		}
	}

}
