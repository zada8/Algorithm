
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int[] angle = new int[3];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum = 0;
		for(int i = 0; i<3; i++) {
			angle[i] = Integer.parseInt(br.readLine());
			sum += angle[i];
		}
		int cnt = 0;
		
		for(int i = 0; i<2; i++) {
			for(int j = i+1; j<3; j++) {
				if(angle[i] == angle[j]) {
					cnt++;
				}	
			}
		}
		if(sum!=180) {
			System.out.println("Error");
		}
		else if(cnt == 3) {
			System.out.println("Equilateral");
		}
		else if(cnt == 1) {
			System.out.println("Isosceles");
		}
		else {
			System.out.println("Scalene");
		}
		
		
	}

}
