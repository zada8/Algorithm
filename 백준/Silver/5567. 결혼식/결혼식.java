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
		
		for(int k = 1; k<n+1; k++) {
			if(arr[1][k]==1 && chk[k] == false) {
				chk[k] = true;
				ans++;
				for(int j = 1; j<n+1; j++) {
					if(arr[k][j]==1 && chk[j] == false && j != 1) {
						chk[j] = true;
						ans++;	
					}
				}
			}
			if(arr[1][k]==1 && chk[k] == true) {
				for(int j = 1; j<n+1; j++) {
					if(arr[k][j]==1 && chk[j] == false && j != 1) {
						chk[j] = true;
						ans++;	
					}
				}
			}
		}
		System.out.println(ans);
		
	}
	

}
