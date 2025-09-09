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
	static List<Point> vList = new ArrayList<>();
	private static int N,M;
	private static Point[] sel;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	private static int[][] map;
	static int ans = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		for(int i = 0; i<N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for(int j= 0; j<N; j++) {
				map[i][j] = Integer.parseInt(st2.nextToken());
				if(map[i][j] == 2) {
					vList.add(new Point(j,i,0));
				}
			}
		}
		
		sel = new Point[M];
		combination(0,0);
		if(ans == Integer.MAX_VALUE) {
			System.out.println(-1);
		}
		else {
			System.out.println(ans);
		}
		
	
	}
	
	static void combination(int idx, int start) {
		if(idx == M) {
			//bfs
			int time = virus(sel);
			ans = Math.min(ans, time);
			return;
		}
		for(int i = start; i<vList.size(); i++) {
			sel[idx] = vList.get(i);
			combination(idx+1, i+1);
		}
	}
	

	//바이러스 퍼트리기
	private static int virus(Point sel[]) {
		Queue<Point> q = new LinkedList<>();
		boolean[][] v = new boolean[N][N];
		for(int i = 0; i<sel.length; i++) {
			q.offer(sel[i]);
			v[sel[i].y][sel[i].x] = true;
		}
		int time = 0;
		while(!q.isEmpty()) {
			Point now = q.poll();
			time = Math.max(time, now.time);
			for(int i = 0; i<4; i++) {
				int nx = now.x +dx[i];
				int ny = now.y + dy[i];
				
				if(nx>=0 && nx<N && ny>= 0 && ny<N &&!v[ny][nx] &&(map[ny][nx] == 0||map[ny][nx] == 2)) {
					v[ny][nx] = true;
					q.offer(new Point(nx, ny, now.time +1));
				}
			}
		}
		for(int i = 0; i < N; i++) {
	        for(int j = 0; j < N; j++) {
	            if((map[i][j] == 0||map[i][j] == 2) && !v[i][j]) {
	            	return Integer.MAX_VALUE;//감염안된곳 있음
	            }
	        }
	    }
		
		
		return time;
	}

}
