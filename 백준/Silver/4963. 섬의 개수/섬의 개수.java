
import java.io.*;
import java.util.*;
public class Main {

	private static int[][] map;
	private static int w;
	private static int h;
	private static boolean[][] chk;
	private static int[] dy= {-1,1,0,0,-1,-1,1,1};//팔방탐색
	private static int[] dx= {0,0,-1,1,-1,1,-1,1};
	private static int ans; //섬의 개수

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if(w==0&&h==0) break;
			
			map = new int[h][w];
			chk = new boolean[h][w];
			
			for(int i = 0; i<h; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				for(int j = 0; j<w; j++) {
					map[i][j] = Integer.parseInt(st2.nextToken());
				}
			}
			/////지도 완성
			
			ans = 0;
			for(int i = 0; i <h; i++) {
				for(int j = 0; j <w; j++) {
					if(map[i][j]==1 && chk[i][j]==false) {
						chk[i][j] = true;
						ans++;
						
						search(i,j);
					}
				}
			}
			System.out.println(ans);
		}
	}
	
	//재귀함수 -> 좌표값이 1이면 주변 탐색해서 좌표값 1인 땅 찾기 반복
	public static void search(int i, int j) {
		for(int m = 0; m < 8; m++) {
			if(i+dy[m]<h && i+dy[m] >= 0 && j+dx[m] >= 0 && j+dx[m] < w) {
				if(map[i+dy[m]][j+dx[m]]==1
						&&chk[i+dy[m]][j+dx[m]] == false) {
					
					chk[i+dy[m]][j+dx[m]] = true;
					search(i+dy[m],j+dx[m]);
					
				}
			}
		}
	}

}
