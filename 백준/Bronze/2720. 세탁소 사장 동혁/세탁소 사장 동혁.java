import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] arr = {25, 10, 5, 1};
		
		for (int i = 0; i < T; i++) {
			
			int C = Integer.parseInt(br.readLine());
			for(int j = 0; j< arr.length; j++) {
				int p = (int)(C/arr[j]);
				
				System.out.print(p+" ");
				C = C%arr[j];
				
			}
			
			
			
		}
	}

}
