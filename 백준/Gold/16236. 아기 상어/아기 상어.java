import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Pos{
		int x, y, dist;
		
		public Pos(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist; //아기상어로부터의 거리
		}
	}
	//큐에 넣을 Pos값
	  
	
	//이동시킬때
	private static int[] dr = {-1,0,1,0}; //상하좌우
	private static int[] dc = {0,-1,0,1};
	private static Queue<Pos> q;
	private static int N;
	private static int[][] sea;
	private static int size = 2; //아기상어 크기
	private static int time; //총 걸린 시간
	private static int cnt; //먹은 물고기 수
	private static int sharkX, sharkY; //현재 아기상어 위치  
	private static boolean[][] v; //방문배열
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		sea = new int[N][N];

		int canEat = 0; //먹을 수 있는 물고기 수
		
		
		//바다 정보 입력, 상어 위치 찾기
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++) {
				sea[i][j] = Integer.parseInt(st.nextToken());
				
				if(sea[i][j] == 9) { //좌표값이 9이면 좌표를 큐에 넣음(아기상어)
					sharkX = i;
					sharkY = j;
					sea[i][j] = 0;// 상어가 있던 곳을 빈공간으로
				}
			}
		}
		
		while(true) {
			Pos target = findNearestFish();
			if(target == null) break;
			
			//물고기 먹으러
			time += target.dist;
			//물고기 먹으면 상어 위치가 그 위치로 바뀜
			sharkX = target.x;
			sharkY = target.y;
			//먹으면 그 위치 0으로 
			sea[target.x][target.y] = 0;
			
			//v = new boolean[N][N]; //방문배열 초기화
			cnt++;
			if(cnt == size) {
				cnt = 0;
				size++;
			}
		}
		System.out.println(time);
	}
	

	//아기 상어보다 작은 물고기가 있을 때, 가장 가까운 물고기 찾기
	public static Pos findNearestFish() {
		q = new LinkedList<>(); //큐
		v = new boolean[N][N];
		Pos neareastFish = null;
		
		q.offer(new Pos(sharkX, sharkY, 0));
		v[sharkX][sharkY] = true;
		
		while(!q.isEmpty()) {
			Pos a = q.poll();
			
			for(int i = 0; i<4; i++) { //4방
				int nextR = a.x+dr[i];
				int nextC = a.y+dc[i];
				int nextDist = a.dist+1;
				
				if(nextR >= 0 && nextR < N && nextC >= 0 && nextC < N
						&& sea[nextR][nextC] <= size && !v[nextR][nextC]) {
					//이동 가능
					Pos n =  new Pos(nextR, nextC, nextDist);
					q.offer(n);//새로운 좌표를 큐에 넣기
					v[nextR][nextC] = true;
					
					//먹을 수 있는 물고기인 지 확인
					if(sea[nextR][nextC] < size && sea[nextR][nextC]!=0) {//먹을 수 있는 물고기
						//찾은 물고기가 첫 물고기면
						if (neareastFish == null) {
							neareastFish = n;
						}
						//지금 찾은 물고기 거리가 전에 찾은 물고기 거리보다 가까움
						else if (n.dist<neareastFish.dist) {
							neareastFish = n;
						}
						else if(n.dist == neareastFish.dist) {
							if(n.x<neareastFish.x || (n.x == neareastFish.x && n.y<neareastFish.y)) {
								neareastFish = n;
							}
						}
					
					}
					if(neareastFish != null && n.dist> neareastFish.dist) continue;
					
				}
			}
			
		}
		return neareastFish;
	}
	

}
