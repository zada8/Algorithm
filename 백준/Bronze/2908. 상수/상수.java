import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		 String numbers = br.readLine();
		 
		 StringBuffer sb = new StringBuffer(numbers); //StringBuffer의 reverse 메소드 사용
		 String reverse = sb.reverse().toString();
		 
		 StringTokenizer st = new StringTokenizer(reverse);
		 String reverseA = st.nextToken();
		 String reverseB = st.nextToken();
		 
		 if(Integer.parseInt(reverseA) > Integer.parseInt(reverseB)) {
			 System.out.println(reverseA);
		 }
		 else {
			 System.out.println(reverseB);
		 }
	}

}
