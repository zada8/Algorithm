import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int H = Integer.parseInt(st.nextToken());
		
		int M = Integer.parseInt(st.nextToken());
		
		int time = Integer.parseInt(br.readLine());
		
		M = M + time;
		
		int plus = M/60;
		if (M>59) {
			
			M = M % 60;
			H = H + plus;
		}
		if (H>23) {
			H = H -24;
		}
		
		System.out.println(H + " "+M);
		
	}
}
