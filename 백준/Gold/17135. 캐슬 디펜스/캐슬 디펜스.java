import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M, D;
	static int[][] originalMap; //맵
	static int maxKill = 0; //죽일 수 있는 최대 수
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //행의 수
		M = Integer.parseInt(st.nextToken()); //열의 수
		D = Integer.parseInt(st.nextToken()); //궁수의 공격 거리 제한
		
		//격자판 완성
		originalMap = new int[N][M];
		for (int i = 0; i < N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				originalMap[i][j] = Integer.parseInt(st2.nextToken());
			}
		}
		///////////
		
		//int[] archerPositions = new int[M]; //궁수 배치할 배열
		
	
		List<Integer> archerPositions = new ArrayList<>(); //궁수 배치할 리스트
		selectArchers(0 ,0,archerPositions); //궁수 배치하고 시뮬레이션하는 함수
		
		//정답 출력
		System.out.println(maxKill);
		
	}
	
	//궁수 배치 (M칸 중에 3칸 고르기) + 각각 시뮬레이션해서 최대 킬 수 찾기
	private static void selectArchers(int i, int cnt, List<Integer> archerPositions) { //i는 인덱스 cnt는 선택하면 ++ 
		if(cnt == 3) { 
			//3명의 궁수 선택됨
			//예시 -> 지금 archerPositions = [1,1,1,0,0] 이런 상태
			
			//시뮬레이션 시작
			int kill = simulateGame(archerPositions);
			
			//각 시뮬레이션에서 가장 큰 kill값이 maxKill이 됨.
			maxKill = Math.max(maxKill, kill);
			return;
		}
		if(i == M) { //배열 끝남(더 이상 선택할 위치가 없음)
			return;
		}
		
		//현재 위치에 궁수 배치하는 경우
		archerPositions.add(i);
		selectArchers(i+1, cnt+1, archerPositions);
		archerPositions.remove(archerPositions.size() -1); //백트래킹

		//현재 위치에 궁수 배치하지 않는 경우
		selectArchers(i+1, cnt, archerPositions);
	}
	
	//게임 시뮬레이션
	private static int simulateGame(List<Integer> archerPositions) {
		//원본 맵 복사
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = originalMap[i][j];
			}
		}
		
		int totalKill = 0;
		
		//적들이 모두 성을 지나갈 때까지 반복
		for( int turn = 0; turn < N; turn++) {
			List<int[]> targets = new ArrayList<>();
			
			//각 궁수가 공격할 적 찾기
			for (int archer : archerPositions) {
				int[] target = findTarget(map, N, archer);
				if (target != null) {
					targets.add(target);
				}
			}
			// 타겟된 적들 제거 (중복 제거)
			for(int[] target : targets) {
				if (map[target[0]][target[1]] == 1) {
					map[target[0]][target[1]] = 0;
					totalKill++;
				}
			}
			
			//적들 한 칸 씩 아래로 이동 (성쪽으로)
			moveEnemies(map);
		}
		return totalKill;
	}
	//궁수가 공격할 적 찾는 메소드(가장 가까운 적, 거리 같으면 가장 왼쪽)
	private static int[] findTarget(int[][] map, int archerRow, int archerCol) {
		int minDist = Integer.MAX_VALUE;
		int [] target = null;
		
		for (int i = archerRow -1; i>= 0; i--) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					int dist = Math.abs(archerRow - i) + Math.abs(archerCol -j);
					if (dist <= D) {
						if (dist < minDist || (dist == minDist && (target == null || j <target[1]))) {
							minDist = dist;
							target = new int[] {i,j};
						}
					}
				}
			}
		}
		return target;
	}
	
	//적들을 한 칸 씩 아래로 이동시키는 메소드
	private static void moveEnemies(int[][] map) {
		for (int i = N - 1; i >= 1; i--) {
			for (int j = 0; j <M; j++) {
				map[i][j] = map[i-1][j];
			}
		}
		
		//첫 번째 행은 0으로 초기화
		for (int j = 0; j < M; j++) {
			map[0][j] = 0;
		}
	}
}
