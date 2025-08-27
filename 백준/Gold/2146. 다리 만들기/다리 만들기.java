import java.io.*;
import java.util.*;

public class Main {
    static class Pos{
        int x, y, dist;
        Pos(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
        Pos(int x, int y){
            this.x = x;
            this.y = y;
            this.dist = 0;
        }
    }

    static int[][] map;
    static int idx;
    final static int[] dx = {-1,1,0,0};
    final static int[] dy = {0,0,-1,1};
    static int N;
    
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
        idx = 2;
        
        // 섬 나누기 - 각 섬을 고유 번호로 구분
        for(int i = 0; i<N; i++) {
            for(int j = 0; j<N; j++) {
                if(map[i][j] == 1) {
                    seperateIsland(i,j);
                    idx++;
                }
            }
        }
        
        // 최단 거리 찾기 - 각 섬에서 다른 섬까지 최단거리 계산
        int minDist = Integer.MAX_VALUE;
        
        // 각 섬별로 1번씩만 BFS 수행 (효율적)
        for(int island = 2; island < idx; island++) {
            int dist = findShortestDistance(island);
            if(dist != -1) {
                minDist = Math.min(minDist, dist);
            }
        }
        
        System.out.println(minDist);
    }
    
    /**
     * 특정 섬에서 다른 섬까지의 최단 거리를 BFS로 계산
     * 해당 섬의 모든 칸을 시작점으로 하여 한 번에 탐색
     */
    private static int findShortestDistance(int islandNumber) {
        boolean[][] visited = new boolean[N][N];
        Queue<Pos> q = new LinkedList<>();
        
        // 해당 섬의 모든 칸을 큐에 추가 (Multi-source BFS)
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == islandNumber) {
                    q.offer(new Pos(j, i, 0));  // 거리 0부터 시작
                    visited[i][j] = true;
                }
            }
        }
        
        while(!q.isEmpty()) {
            Pos now = q.poll();
            
            for(int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                
                if(nx>=0 && nx<N && ny>=0 && ny<N && !visited[ny][nx]) {
                    // 다른 섬에 도착했으면
                    if(map[ny][nx] != 0 && map[ny][nx] != islandNumber) {
                        return now.dist;
                    }
                    // 바다면 계속 진행
                    if(map[ny][nx] == 0) {
                        visited[ny][nx] = true;
                        q.offer(new Pos(nx, ny, now.dist + 1));
                    }
                }
            }
        }
        
        return -1; // 다른 섬에 도달할 수 없음
    }
    
    /**
     * 연결된 섬들을 같은 번호로 마킹하는 BFS
     */
    private static void seperateIsland(int y, int x) {
        map[y][x] = idx;
        Queue<Pos> q = new LinkedList<>();
        q.offer(new Pos(x, y));
        
        while(!q.isEmpty()) {
            Pos now = q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(nx>=0 && nx<N && ny>=0 && ny<N && map[ny][nx] == 1) {
                    map[ny][nx] = idx;
                    q.offer(new Pos(nx, ny));
                }
            }
        }
    }
}