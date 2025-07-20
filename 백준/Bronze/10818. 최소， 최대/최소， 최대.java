import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] array = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
			}
		
		Arrays.sort(array);
		bw.write(array[0] +" "+array[N-1]);
		
		
		bw.flush();
		bw.close();
		br.close();
	}

}
