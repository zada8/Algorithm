
import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); //물건의 개수
			int K = Integer.parseInt(st.nextToken()); //가방의 부피
			
			int[] arrV = new int[N]; //물건의 부피
			int[] arrC = new int[N]; //물건의 가치
			for(int i = 0; i<N; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				
				arrV[i] = Integer.parseInt(st2.nextToken());; //부피 리스트
				arrC[i] = Integer.parseInt(st2.nextToken());; //가치 리스트
			}
			int[][] dp = new int[N+1][K+1];
			
			for(int i = 0; i<N+1; i++) {
				for(int j = 0; j<K+1; j++) {
					if(i == 0 || j == 0) {
						dp[i][j] = 0;
					}
					else if(arrV[i-1]<=j) {
						dp[i][j] = Math.max(arrC[i-1] + dp[i-1][j-arrV[i-1]], dp[i-1][j]);
					}
					else {
						dp[i][j] = dp[i-1][j];
					}
					
				}
			}
			System.out.println("#"+t+" "+dp[N][K]);
			
		}
	}

}
