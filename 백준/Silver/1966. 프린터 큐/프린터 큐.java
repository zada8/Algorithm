
import java.io.*;
import java.util.*;


public class Main {
	static class Pos {
		int s, w;
		Pos(int s, int w){
			this.s = s; //처음 위치
			this.w = w; //중요도
		}
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); //문서의 개수
			int M = Integer.parseInt(st.nextToken()); //몇번째인지 궁금한 문서
			
			Queue<Pos> q = new LinkedList<>();
			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
			
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for(int i = 0; i<N; i++) {
				int priority = Integer.parseInt(st2.nextToken());
				q.offer(new Pos(i, priority));
				pq.offer(priority);
			}
			int cnt = 0; //몇번째로 출력됐는지
			
			while(!q.isEmpty()) {
				Pos now = q.poll();
				
				if(now.w ==pq.peek()) {
					cnt++;
					pq.poll();
					
					if(now.s == M) {
						System.out.println(cnt);
						break;
					}
				}
				else {
					q.offer(now);
				}
				
			}
			
			
			
			
		}
	}

}
