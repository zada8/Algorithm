import java.io.*;
import java.util.*;


public class Main {
	static class Point{
		int x, y, time;
		Point(int x, int y, int time){
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}
	static int N,M;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	private static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //세로 크기
		M = Integer.parseInt(st.nextToken()); //가로 크기
		
		map = new int[N][M];
		for(int i = 0; i<N; i++) {
			String str = br.readLine();
			for(int j = 0; j<M; j++) {
				int a = str.charAt(j);
				if(a == 'W') {
					map[i][j] = 0; //바다
				}
				else {
					map[i][j] = 1; //육지
				}
			}
		}
		
		int ans = 0;
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if(map[i][j] == 1) {
					int time = bfs(j, i);
					ans = Math.max(ans, time);
				}
			}
		}
		System.out.println(ans);
		
		
	}
	
	static int bfs(int x, int y) {
		boolean[][] v = new boolean[N][M];
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(x, y, 0));
		v[y][x] = true;
		int maxTime = 0;
		while(!q.isEmpty()) {
			Point now = q.poll();
			maxTime = Math.max(maxTime, now.time);
			for(int i = 0; i<4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				
				if(nx>= 0 && nx<M && ny>= 0 && ny<N &&!v[ny][nx] && map[ny][nx] == 1) {
					v[ny][nx] = true;
					q.offer(new Point(nx, ny, now.time+1));
				}
			}
		}
		return maxTime;
	}

}
