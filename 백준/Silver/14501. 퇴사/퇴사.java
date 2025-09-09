import java.io.*;
import java.util.*;
//은퇴
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arrT = new int[N];
		int[] arrP = new int[N];
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arrT[i] = Integer.parseInt(st.nextToken()); //기간
			arrP[i] = Integer.parseInt(st.nextToken()); //돈
		}
		
		int[] dp = new int[N+1];
		for(int i = 0; i<N; i++) {
			if(i+arrT[i]<=N) {
				dp[i+arrT[i]] = Math.max(dp[i+arrT[i]], dp[i]+arrP[i]);
			}
			
			dp[i+1] = Math.max(dp[i+1],  dp[i]);
			
		}
		System.out.println(dp[N]);
	}

}
