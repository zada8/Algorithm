import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		         //맨위//그다음위//맨아래//옆  
		long ans = 1+ (n-1) + n + (n*2); 
		System.out.println(ans);
	}

}
