
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 int N = Integer.parseInt(br.readLine());
		 
		 int sum = 0;
		 for(int i = 0; i< N; i++) {
			 String s = Integer.toString(i);
			 sum = i;
			 
			 for(int j = 0; j <s.length(); j++) {
				 sum += s.charAt(j)-'0';
			 }
			 if (sum == N) {
				 System.out.println(i);
				 break;
			 }
		 
		}
		 if(sum != N) {
			 System.out.println("0");
		 }
		 
	}

}
