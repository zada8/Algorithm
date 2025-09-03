import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[N+1]; //메모이제이션 //몇 번 연산하는지
 		dp[1] = 0;
		for(int i = 2; i<N+1; i++) {
			dp[i] = dp[i-1]+1; //1을 뺀 값
			
			if(i%3 == 0) {
				dp[i] = Math.min(dp[i], dp[i/3]+1);
			}
			if(i%2 == 0) {
				dp[i] = Math.min(dp[i], dp[i/2]+1);
			}
		}
		System.out.println(dp[N]);
	}

}
