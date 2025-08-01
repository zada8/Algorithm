
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken()); //낮 올라감
		int B = Integer.parseInt(st.nextToken()); //밤 떨어짐
		int V = Integer.parseInt(st.nextToken()); //높이 V
		
		int ans = (V-B)/(A-B);
		if((double) (V-B)/(A-B) > (double)ans) {
			ans++;
		}
		
		System.out.println(ans);
	}

}
