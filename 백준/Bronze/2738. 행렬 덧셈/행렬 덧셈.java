import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //행의 크기
		int M = Integer.parseInt(st.nextToken()); //열의 크기
		
		int[][] array = new int[N*2][M];
		int[][] ans = new int[N][M];
		
		for (int i = 0; i< N*2; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				array[i][j] = Integer.parseInt(st2.nextToken());
			}
		}

		for (int i = 0; i< N; i++) {
			for (int j = 0; j < M; j++) {
				ans[i][j] = array[i][j]+array[N+i][j];
				System.out.print(ans[i][j]+" ");
			}
			System.out.println();
		}
	
	}

}
