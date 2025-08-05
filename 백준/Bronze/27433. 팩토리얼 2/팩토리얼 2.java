import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long fac = 1;
		
		for(int i = 1; i<= N; i++) {
			fac *= i;
		}
		System.out.println(fac);
	}

}
