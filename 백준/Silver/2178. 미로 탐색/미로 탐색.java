//백준 2178 미로탐색
import java.io.*;
import java.util.*;

public class Main {
	static boolean[][] v;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static int N, M;
	static int[][] map;
	static int min = Integer.MAX_VALUE;
	
	static class Pos{
		int x, y, cnt;
		Pos(int x, int y, int cnt){
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		v = new boolean[N][M];
		
		for(int i = 0; i<N; i++) {
			String str = br.readLine();
			for(int j = 0; j<M; j++) {
				map[i][j] = str.charAt(j)-48;
			}
		}
		bfs();
		System.out.println(min);
		/*
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		*/
		
	}
	
	static void bfs() {
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(0,0,1));
		v[0][0] = true;
		
		while(!q.isEmpty()) {
			Pos current = q.poll();
			
			for(int i = 0; i<4; i++) {
				int newX = current.x+dx[i];
				int newY = current.y+dy[i];
				int newCnt = current.cnt+1;
				if(newX>= 0 && newX<M && newY>=0 && newY<N && !v[newY][newX] && map[newY][newX] == 1) {
					v[newY][newX] = true;
					q.offer(new Pos(newX, newY, newCnt));
				}
				if(newX == M-1 && newY == N-1) {
					min = Math.min(newCnt, min);
				}
			}
		}
		
	}

}
