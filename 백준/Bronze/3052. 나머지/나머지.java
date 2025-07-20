import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;



public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean[] array = new boolean[42];
		
		for (int i = 0; i < 10; i++) {
			array[Integer.parseInt(br.readLine())%42] = true;
		}
		
		int cnt = 0;
		for (boolean value : array) {
			if(value) {
				cnt++;
			}
		}
		System.out.println(cnt);
		
	}

}
