import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;



public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] array = new int[30];
		
		for (int i = 0; i < 28; i++) {
			array[Integer.parseInt(br.readLine())-1] = 1;
		}
		
		for (int i =0; i< 30; i++) {
			if(array[i] == 0) {
				System.out.println(i+1);
			}
		}
	}

}
