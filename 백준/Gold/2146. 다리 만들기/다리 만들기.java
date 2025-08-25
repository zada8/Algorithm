import java.io.*;
import java.util.*;

public class Main {
    static class Pos{
        int x;
        int y;
        int idx;
        int dist; // 거리 추가
        
        Pos(int x, int y, int idx){
            this.x = x;
            this.y = y;
            this.idx = idx;
            this.dist = 0;
        }
        
        Pos(int x, int y, int idx, int dist){
            this.x = x;
            this.y = y;
            this.idx = idx;
            this.dist = dist;
        }
    }

    static boolean[][] v;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int N;
    static int[][] map;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int i = 0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //지도 완성
        
        // 섬 나누기
        v = new boolean[N][N];
        int idx = 2; // 섬의 인덱스(1은 이미 있으니까 2부터)
        for(int i = 0; i<N; i++) {
            for(int j = 0; j<N; j++) {
                if(map[i][j] == 1 && !v[i][j]) {
                    makeIslandIndex(j,i,idx++);
                }
            }
        }
        
        /* 섬 잘 나눴는지 출력해봄
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		*/
        

        // 섬과 섬 사이의 최단거리 찾기
        int minDistance = Integer.MAX_VALUE;
        
        // 각 섬에서 시작해서 다른 섬까지의 최단거리 구하기
        for(int i = 0; i<N; i++) {
            for(int j = 0; j<N; j++) {
                if(map[i][j] >= 2) { // 섬인 경우
                    int distance = findShortestBridge(j, i, map[i][j]);
                    if(distance != -1) {
                        minDistance = Math.min(minDistance, distance);
                    }
                }
            }
        }
        
        System.out.println(minDistance);
    }
    //main끝
    
    // 섬 나누기
    static void makeIslandIndex(int x, int y, int idx) {
        Pos a = new Pos(x,y,idx);
        Queue<Pos> q = new LinkedList<>();
        q.offer(a);
        v[y][x] = true;
        map[y][x] = idx;

        while(!q.isEmpty()) {
            Pos now = q.poll();
            for(int i = 0; i<4; i++) {
                int nextX = now.x+dx[i];
                int nextY = now.y+dy[i];
                if(nextX >= 0 && nextX <N && nextY>= 0 && nextY<N
                    && map[nextY][nextX] == 1 && !v[nextY][nextX]) {
                    map[nextY][nextX] = idx;
                    v[nextY][nextX] = true;
                    q.offer(new Pos(nextX, nextY,idx));
                }
            }
        }
    }

    // 섬과 섬 사이의 최단거리 찾기
    static int findShortestBridge(int startX, int startY, int startIdx) {
        boolean[][] visited = new boolean[N][N];
        Queue<Pos> q = new LinkedList<>();
        
        // 현재 섬의 모든 가장자리를 큐에 추가
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == startIdx) {
                    // 가장자리인지 확인 (주변에 바다가 있는지)
                    for(int dir = 0; dir < 4; dir++) {
                        int nx = j + dx[dir];
                        int ny = i + dy[dir];
                        if(nx >= 0 && nx < N && ny >= 0 && ny < N && map[ny][nx] == 0) {
                            if(!visited[i][j]) {
                                visited[i][j] = true;
                                q.offer(new Pos(j, i, startIdx, 0));
                            }
                            break;
                        }
                    }
                }
            }
        }
        
        // BFS로 최단거리 찾기
        while(!q.isEmpty()) {
            Pos now = q.poll();
            
            for(int i = 0; i < 4; i++) {
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];
                
                if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < N && !visited[nextY][nextX]) {
                    // 바다인 경우 - 계속 진행
                    if(map[nextY][nextX] == 0) {
                        visited[nextY][nextX] = true;
                        q.offer(new Pos(nextX, nextY, startIdx, now.dist + 1));
                    }
                    // 다른 섬에 도착한 경우
                    else if(map[nextY][nextX] != startIdx && map[nextY][nextX] >= 2) {
                        return now.dist; // 바다만 지나온 거리 반환
                    }
                }
            }
        }
        
        return -1; // 연결할 수 없는 경우
    }
}