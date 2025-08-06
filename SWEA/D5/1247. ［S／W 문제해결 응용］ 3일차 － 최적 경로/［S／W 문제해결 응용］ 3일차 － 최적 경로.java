
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static class location{
		int x, y;
		public location() {}
		public location(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	static location[] l; 
	static location[] nL; //새로 만들 위치 배열
	static boolean[] v;
	static int N;
	
	static int min;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 1; i<= T; i++) {//테스트케이스 반복
			N = Integer.parseInt(br.readLine()); //고객의 수
			l = new location[N]; //위치값들 넣을 배열
			nL = new location[N+2];
			v = new boolean[N];
			min=Integer.MAX_VALUE;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			nL[0] = new location();
            nL[N + 1] = new location();
            
			nL[0].x = Integer.parseInt(st.nextToken());
			nL[0].y = Integer.parseInt(st.nextToken());
			nL[N+1].x = Integer.parseInt(st.nextToken());
			nL[N+1].y = Integer.parseInt(st.nextToken());
			
			for(int j = 0; j < N; j++) {
				l[j] = new location();
				l[j].x = Integer.parseInt(st.nextToken());
				l[j].y = Integer.parseInt(st.nextToken());
			}
			////////////////위치 배열 완성(집 회사 없음)
			recursive(1);
			System.out.println("#"+i+" "+min);
			
			
		}
		
	}
	
	public static void recursive(int idx) {
		if(idx == N+1) {
			//새로운 위치 배열 완성
			int distance= 0;
			for(int i = 0; i<N+1; i++) {
				distance += Math.abs(nL[i].x-nL[i+1].x) + Math.abs(nL[i].y-nL[i+1].y);
			}
			min = Math.min(distance, min);
			return;
		}
		for(int i = 0; i< N; i++) {
			if(v[i] == false){
				v[i] = true;
				nL[idx] = l[i];
				recursive(idx+1);
				v[i] = false;
			}
			
		}

		
	}

}
