import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;



public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //바구니 개수
		int M = Integer.parseInt(st.nextToken()); //공 넣는 횟수
		
		//배열 만들기
		int[] array = new int[N];
		
		for (int s = 0; s < M; s++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st2.nextToken());
			int j = Integer.parseInt(st2.nextToken());
			int k = Integer.parseInt(st2.nextToken());
			
			for (int a = i; a <= j; a++) {
				array[a-1] = k;
			}
		}
		
		for (int i = 0; i < N; i++) {
			bw.write(array[i]+" ");
		}
		bw.newLine();
		
		bw.flush();
		bw.close();
		br.close();
	}

}
