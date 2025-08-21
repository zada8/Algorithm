
import java.io.*;
import java.util.*;

public class Solution {

	static class Pos {
		int x, y;
		
		Pos(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int[][] map;
	static int ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t = 1; t<= 10; t++) {
			int T = Integer.parseInt(br.readLine());
			map = new int[100][100];
			for(int i = 0; i<100; i++) {
				String str = br.readLine();
				for(int j = 0; j<100; j++) {
					map[i][j] = str.charAt(j)-48;
				}
			}
			int startX = 0;
			int startY = 0;
			ans = 0;
			
			for(int i = 0; i<100; i++) {
				for(int j = 0; j<100; j++) {
					if(map[i][j] ==2) {
						startY = i;
						startX = j;
					}
				}
			}
			
			
			bfs(startX, startY);
			System.out.println("#"+t+" "+ans);
			
			
			
		}
	}
	static void bfs(int startX, int startY) {
		Queue<Pos> q = new LinkedList<>();
		boolean[][] v = new boolean[100][100];
		
		q.offer(new Pos(startX, startY));
		v[startY][startX] = true;
		
		while(!q.isEmpty()) {
			Pos now = q.poll();
			for(int i = 0; i<4; i++) {
				int nextX = now.x +dx[i];
				int nextY = now.y +dy[i];
				
				if(nextX>= 0 && nextX<100 && nextY>= 0 && nextY < 100 
						&&!v[nextY][nextX] && map[nextY][nextX] == 3) {
					ans = 1;
					return;
				}
				else if(nextX>= 0 && nextX<100 && nextY>= 0 && nextY < 100 
						&&!v[nextY][nextX] && map[nextY][nextX] == 0) {
					
					v[nextY][nextX] = true;
					q.offer(new Pos(nextX, nextY));
					
				}
			}
		}
		
	}

}
