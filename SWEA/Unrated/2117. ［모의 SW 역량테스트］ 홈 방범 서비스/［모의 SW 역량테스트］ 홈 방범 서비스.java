import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	private static int N, M;
	private static int[][] town;
	static class Point{
		int x, y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); //도시의 크기
			M = Integer.parseInt(st.nextToken()); //하나의 집이 지불할 수 있는 비용
			town = new int[N][N];
			for(int i = 0; i<N; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				for(int j = 0; j<N; j++) {
					town[i][j] = Integer.parseInt(st2.nextToken());
				}
			}
			//서비스영역 1~N까지 모든 위치에서 (거리 0부터 n-1까지) 
			int ans = 0;//홈방범서비스를 제공받는 집의 수
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N; j++) {
					ans = Math.max(ans, cntHome(j,i));
				}
			}
			
			System.out.println("#"+t+" "+ans);
			
		}
	}
	static int cntHome(int x, int y) {
		int maxHome = 0;
		for(int K = 1; K<N+N-1; K++) {
			int homeCnt = 0;
			
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N; j++) {
					int dist = Math.abs(i-y) + Math.abs(j-x);
					if(dist< K && town[i][j] ==1) {
						homeCnt++;
					}
				}
			}
			int cost = K * K + (K-1)*(K-1);
			if(cost<= homeCnt *M) {
				maxHome = homeCnt;
			}
		}
		return maxHome;
	}
}
