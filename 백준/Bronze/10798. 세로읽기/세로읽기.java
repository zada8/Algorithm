import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] array = new String[5];
		
		int maxLength = 0;
		for (int i = 0 ; i < 5; i++) {
			array[i] = br.readLine();
			maxLength = Math.max(maxLength, array[i].length());
		}
		
		for (int i = 0; i< maxLength; i++) {
			for (int j = 0; j < 5; j++) {
				if (array[j].length() > i) {
					System.out.print(array[j].charAt(i));
				}
			}
		}
		
	}

}
