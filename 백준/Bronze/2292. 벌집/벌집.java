
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = 1; 
		int range = 2;
		//N이 range미만이면 답은 cnt 
		
		if(N==1) {
			System.out.println(1);
		}
		
		else {
			while(range <= N) {
				range = range + (6* cnt);
				cnt++;
			}
			System.out.println(cnt);
		}
	}

}
