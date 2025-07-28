import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String N = st.nextToken(); //숫자
		int B = Integer.parseInt(st.nextToken()); //몇진수인지
		
		int ans = 0; //10진법 정답
		int n = 0;
		for(int i = N.length()-1; i >= 0; i--) {
			char c = N.charAt(i);
			
			if ('A' <= c && c <= 'Z') {
				ans += (c - 'A' + 10 )* Math.pow(B, n);
			}
			else {
				ans += (c -'0')* Math.pow(B, n);
			}
			n++;
		}
		System.out.println(ans);
	}

}
