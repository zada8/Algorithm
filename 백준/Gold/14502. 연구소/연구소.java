import java.io.*;
import java.util.*;


public class Main {

	static class Point{
		int x, y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
			
		}
	}
	static List<Point> wList = new ArrayList<>();

	
	private static int N,M;
	private static Point[] sel;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	private static int[][] map;
	static int ans = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		sel = new Point[3];
		
		for(int i = 0; i<N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for(int j= 0; j<M; j++) {
				map[i][j] = Integer.parseInt(st2.nextToken());
				if(map[i][j] == 0) { //벽 세울 수 있음
					wList.add(new Point(j,i));
				}
			}
		}
		
		
		combination(0,0);
		System.out.println(ans);
		
		
	}
	//벽 세울 위치
	static void combination(int idx, int start) {
		if(idx == 3) {//벽 세 개 세우고 바이러스 퍼트리기
			//bfs
			int safeSize = virus(sel);
			ans = Math.max(ans, safeSize);
			return;
		}
		for(int i = start; i<wList.size(); i++) {
			sel[idx] = wList.get(i);
			combination(idx+1, i+1);
		}
	}
	
	private static int virus(Point[] sel) {
		
		
		Queue<Point> q = new LinkedList<>();
		boolean[][] v = new boolean[N][M];
		
		//벽 방문배열 
	    for(int i = 0; i < 3; i++) {
	        v[sel[i].y][sel[i].x] = true;
	    }
		
		
		 // 바이러스 큐에 추가
	    for(int i = 0; i < N; i++) {
	        for(int j = 0; j < M; j++) {
	            if(map[i][j] == 2) {
	                q.offer(new Point(j, i));
	                v[i][j] = true;
	            }
	        }
	    }
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			for(int i = 0; i<4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if(nx>=0 && nx<M && ny>=0 && ny<N && !v[ny][nx] 
						&&map[ny][nx] == 0) {
					v[ny][nx] = true;
					q.offer(new Point(nx,ny));
				} 
			}
		}
		
		//안전영역 크기 구하기
		int safeSum = 0;
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if(map[i][j] == 0 && !v[i][j]) {
					safeSum++;
				}
			}
		}
	
		return safeSum;
	}
	



}
