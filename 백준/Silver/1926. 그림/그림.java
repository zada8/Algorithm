import java.io.*;
import java.util.*;

public class Main {

	static class Pos{
		int x, y;
		Pos(int x, int y){
			this.x = x;
			this.y = y;
			
		}
	}
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int n, m;
	static int[][] paper;
	static int max;
	static int size = 0;
	static boolean[][] check;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); //도화지의 세로 크기
		m = Integer.parseInt(st.nextToken()); //도화지의 가로 크기
		
		paper = new int[n][m];
		for(int i = 0; i<n; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for(int j = 0; j<m; j++) {
				paper[i][j] = Integer.parseInt(st2.nextToken());
			}
		}
		//도화지 상태 완성
		
		check = new boolean[n][m];
		int cnt = 0;
		
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				if(paper[i][j] == 1 && !check[i][j]) {
					check[i][j] = true;
					cnt++;
					max = Math.max(max,bfs(j,i));
				}
			}
		}
		System.out.println(cnt);
		System.out.println(max);
		
		
		
	}
	
	static int bfs(int x, int y) {
		Queue<Pos> q = new LinkedList<>();
		
		size = 1;
		
		q.offer(new Pos(x,y));
		
		
		while(!q.isEmpty()) {
			Pos current = q.poll();
			for(int i = 0; i<4; i++) {
				int cX = current.x+dx[i];
				int cY = current.y+dy[i];
				
				
				if(cX>=0 && cX<m && cY>= 0 && cY<n && paper[cY][cX] == 1 && !check[cY][cX]) {
					check[cY][cX] = true;
					q.offer(new Pos(cX, cY));
					size++;
				}
				
			}
		}
		return size;
	}

}
