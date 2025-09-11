import java.io.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());//계단의 수
		int[] stairs = new int[N];
		for(int i = 0; i<N; i++) {
			stairs[i] = Integer.parseInt(br.readLine());
		}
		int[] dp = new int[N];
		
		dp[0] = stairs[0];
		if(N>=2) {
			dp[1] = stairs[0]+stairs[1];
		}
		if(N>=3) {
			dp[2] = Math.max(stairs[0]+stairs[2], stairs[1] + stairs[2]);
		}
		
		for(int i = 3; i<N; i++) {
			dp[i] = Math.max(stairs[i-1]+dp[i-3], dp[i-2])+stairs[i];
		}
		System.out.println(dp[N-1]);
		
		
	}

}
