
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i = 1; i<= T; i++) {
			long N = Long.parseLong(br.readLine()); //정수N
			//N을 2로 만드는 최소 횟수 구하기
			//Math.sqrt() ->루트
			long cnt = 0; 
			long nextN = 0;
			
			while(N > 2) {
				if(isAvailable(N)) {
					N = (long) Math.sqrt(N);
					cnt++;
				}
				else {//N이 제곱근 나올 수 있을 때 까지 1더하기
					//N += 1;
					//cnt++;
					nextN = (long)Math.pow((long)Math.sqrt(N)+1, 2);
					cnt += nextN-N;
					N = nextN;
					
				}
				
			}
			System.out.println("#"+i+" "+cnt);
			
		}
	}
	
	public static boolean isAvailable(long N) {
		if(Math.sqrt(N)%1 == 0.0) {
			return true;
		}
		return false;
	} 

}
