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
		int M = Integer.parseInt(st.nextToken()); //공 바꾸는 횟수
		
		//배열 만들기
		int[] array = new int[N];
		
		for (int s = 0; s < N; s++) {
			array[s] = s + 1; //바구니 안에 1부터 N까지 하나씩 넣기
		}
		
		for (int t = 0; t< M; t++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st2.nextToken());
			int j = Integer.parseInt(st2.nextToken());
			
			int temp = array[i-1];
			array[i-1] = array[j-1];
			array[j-1] = temp;	
		}
		
		for (int i = 0; i < N; i++) {
			bw.write(array[i] + " ");
		}
		
		bw.newLine();
		
		bw.flush();
		bw.close();
		br.close();
	}

}
