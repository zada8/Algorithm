
import java.io.*;
import java.util.*;


public class Solution {
	static class Point implements Comparable<Point>{
		int x, y, w;
		Point(int x, int y, int w){
			this.x = x;
			this.y = y;
			this.w = w;
		}
		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return this.w - o.w;
		}
	}
	
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			for(int i = 0; i<N; i++) {
				String str = br.readLine();
				for(int j = 0; j<N; j++) {
					map[i][j] = str.charAt(j)-'0';
				}
			}
			
			int[][] dist = new int[N][N];
			for(int i = 0; i<N; i++) {
				Arrays.fill(dist[i], Integer.MAX_VALUE);
			}
			PriorityQueue<Point> pq = new PriorityQueue<>();
			boolean[][] v = new boolean[N][N];
			
			pq.offer(new Point(0,0,0));
			//v[0][0] = true;
			dist[0][0] = 0;
			
			while(!pq.isEmpty()) {
				Point now = pq.poll();
				
				if(v[now.y][now.x]) continue;
				v[now.y][now.x] = true;
				
				for(int i = 0; i<4; i++) {
					int nx = now.x + dx[i];
					int ny = now.y + dy[i];
					
					if(nx>=0 && nx<N && ny>=0 && ny<N && !v[ny][nx]) {
						int newW = dist[now.y][now.x] + map[ny][nx];
						if(newW<dist[ny][nx]) {
							dist[ny][nx] = newW;
							pq.offer(new Point(nx, ny, newW));
						}
					}
					
				}
			}
			
			System.out.println("#"+t+" "+dist[N-1][N-1]);
			
			
		}
	}

}
