import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String voca = br.readLine();
		int isPalindrome = 1;
		for(int i = 0; i <= voca.length()/2; i++) {
			if(voca.charAt(i)!=voca.charAt(voca.length()-1-i)) {
				isPalindrome = 0;
				break;
			}
		}
		System.out.println(isPalindrome);
	}

}
