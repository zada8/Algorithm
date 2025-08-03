
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			if(n == -1) break;
			int sum = 0;
			int sum2 = 0;
			for(int i = 1; i < n; i++) {
				if(n % i == 0) {
					sum += i;
				}
			}
			if(sum == n) {
				System.out.print(n +" = ");
				for(int i = 1; i< n ; i++) {
					if(n % i == 0) {
						System.out.print(i);
						sum2 += i;
						if(sum2 != n) {
							System.out.print(" + ");
						}
					}
					
				}
				System.out.println();
			}
			else {
				System.out.println(n+ " is NOT perfect.");
			}
		}
	}

}
