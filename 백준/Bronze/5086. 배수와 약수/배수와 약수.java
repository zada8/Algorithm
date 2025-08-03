
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			if(A == B && A == 0) {
				break;
			}
			if(B % A == 0 && A!= 0) { //A가 B의 약수
				System.out.println("factor");
			}
			else if(A % B == 0 && B != 0) { //A가 B의 배수
				System.out.println("multiple");
			}
			else {
				System.out.println("neither");
			}
			
		}
	}

}
