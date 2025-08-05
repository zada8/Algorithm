
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static int ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ans = 0;
		System.out.println(recursive(n));
	}

	public static int recursive(int idx) {
		if(idx <= 0) {
			return 0;
		}
		if(idx == 1) {
			return 1;
		}
		
		return recursive(idx-1) + recursive(idx-2);
	}
}
