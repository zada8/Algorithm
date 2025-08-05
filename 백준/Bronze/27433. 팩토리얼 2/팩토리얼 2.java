import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	
	private static int fac;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		System.out.println(facto(N));
		
	}

	public static long facto(int i) {
		if(i==0) {
			return 1;
		}
		
		return  facto(i-1)*i;
	}

}
