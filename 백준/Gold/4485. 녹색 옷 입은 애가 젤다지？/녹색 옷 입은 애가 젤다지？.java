
import java.io.*;
import java.util.*;

public class Main {
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	static class Pos implements Comparable<Pos>{
		int x, y, cost;
		Pos(int x, int y, int cost){
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
		@Override
		public int compareTo(Pos o) {
			// TODO Auto-generated method stub
			return this.cost - o.cost;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = 1;
		
		while(true) {
			int N = Integer.parseInt(br.readLine());
			if(N == 0) break;
			
			int[][] cave = new int[N][N];
			for(int i = 0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j<N; j++) {
					cave[i][j] = Integer.parseInt(st.nextToken());
				}
			}//동굴완성
			
			PriorityQueue<Pos> pq = new PriorityQueue<>();
			boolean[][] v = new boolean[N][N];
			int[][] dist = new int[N][N];
			for(int i = 0; i<N; i++) {
				Arrays.fill(dist[i], Integer.MAX_VALUE);
			}
			pq.offer(new Pos(0,0,cave[0][0]));
			dist[0][0] = cave[0][0];
			
			while(!pq.isEmpty()) {
				Pos now = pq.poll();
				if(v[now.y][now.x]) continue;
				
				v[now.y][now.x]= true;
				
				if(now.x == N-1 && now.y == N-1) break;
				
				for(int i = 0; i<4; i++) {
					int nx = now.x+dx[i];
					int ny = now.y+dy[i];
					
					
					if(nx>=0 && nx<N && ny>=0 && ny<N ) {
						
						int cost = dist[now.y][now.x]+cave[ny][nx];
						if(cost<dist[ny][nx]) {
							dist[ny][nx] = cost;
							pq.offer(new Pos(nx,ny,cost));
							
						}
						
						
					
						}
					}
				}
			System.out.println("Problem "+cnt+": "+dist[N-1][N-1]);
			cnt++;
			}
		}
		
	}


