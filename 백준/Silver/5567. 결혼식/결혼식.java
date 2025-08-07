
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int n;
	private static int[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine()); //동기 수
		int m = Integer.parseInt(br.readLine()); //리스트의 길이
		int ans = 0;
		boolean[] chk = new boolean[n+1];
		
		arr = new int[n+1][n+1];
		for (int j =0; j<m; j++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x][y] = 1;
			arr[y][x] = 1;
		}
		///친구 관계 배열 
		
		//1번의 친구 찾기
		for(int i = 1; i <= n; i++) {
			if(arr[1][i]==1 && chk[i] == false) {
				chk[i] = true;
				ans++;
				
	
			}

		}
		//1의 친구의 친구 찾기
		for (int i = 1; i <= n; i++) {
			if(arr[1][i] == 1) {
				for(int j = 1; j <= n; j++) {
					if(arr[i][j] == 1 && chk[j] == false && j != 1) {
						chk[j] = true;
						ans++;
					}
				}
			}
		}
		System.out.println(ans);
		
	}
	

}
