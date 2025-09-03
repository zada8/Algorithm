
import java.io.*;
import java.util.*;

public class Main {

	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	static class Pos implements Comparable<Pos>{
		int x, y, state;
		Pos(int x, int y, int state){
			this.x = x;
			this.y = y;
			this.state = state;
		}
		@Override
		public int compareTo(Pos o) {
			// TODO Auto-generated method stub
			return this.state - o.state;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken()); //가로크기
		int N = Integer.parseInt(st.nextToken()); //세로 크기
		int[][] maze = new int[N+1][M+1];
		for(int i = 1; i<N+1; i++) {
			String str = br.readLine();
			for(int j = 1; j<M+1; j++) {
				maze[i][j] = str.charAt(j-1)-'0';
			}
		}
		
		boolean[][] v = new boolean[N+1][M+1];
		int[][] dist = new int[N+1][M+1];
		for(int i = 0; i<N+1; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}
		
		PriorityQueue<Pos> pq = new PriorityQueue<>();
		pq.offer(new Pos(1,1,0));
		dist[1][1] = 0;
		
		while(!pq.isEmpty()) {
			Pos now = pq.poll();
			if(v[now.y][now.x]) continue;
			v[now.y][now.x] = true;
			
			if(now.x == M && now.y == N) break;
			
			for(int i = 0; i<4; i++) {
				int nx = now.x +dx[i];
				int ny = now.y +dy[i];
				
				if(nx>0 && nx<=M && ny>0 && ny<=N) {
					int ncost = dist[now.y][now.x]+maze[ny][nx];
					if(ncost<dist[ny][nx]) {
						dist[ny][nx] = ncost;
						pq.offer(new Pos(nx, ny, dist[ny][nx]));
					}
				}
			}
		}
		System.out.println(dist[N][M]);
		
		
	}

}
