import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int total = Integer.parseInt(br.readLine());
		int num = Integer.parseInt(br.readLine());
		
		int sum = 0;
		
		for (int i = 0; i<num; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int price = Integer.parseInt(st.nextToken());
			int p_num = Integer.parseInt(st.nextToken());
			
			sum += price * p_num;
		}
		
		if (sum == total) {
			System.out.println("Yes");
		}
		
		else {
			System.out.println("No");
		}
	}
}
