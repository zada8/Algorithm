import java.io.*;
import java.util.*;

public class Solution {

	static int s;
	static int cnt;
	static ArrayList<Integer>[] graph;
	static int max;
	static int[] v;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t = 1; t<=10; t++) {
			v = new int[101];
			cnt = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); //입력받는 데이터의 길이
			s = Integer.parseInt(st.nextToken()); //시작점
			
			graph = new ArrayList[101];
			for(int i = 0; i<=100; i++) {
				graph[i] = new ArrayList<Integer>();
			}
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for(int i = 0; i<n/2; i++) {
				int a = Integer.parseInt(st2.nextToken());
				int b = Integer.parseInt(st2.nextToken());
				graph[a].add(b);
			}
			
			for(int i = 0; i<101; i++) {
				if(graph[i].size()!=0) {
					Collections.sort(graph[i]);
				}
			}
			/*
			for(int i = 0; i<=100; i++) {
				System.out.println(graph[i]);
			}
			*/
			
			
			System.out.println("#"+t+" "+bfs(s));
			
			
		}
	}
	
	static int bfs(int idx) {
		Queue<Integer> q = new LinkedList<>();
	 
		q.offer(idx);
		v[idx] = cnt++;
		max = 1;
		while(!q.isEmpty()) {
			int a = q.poll();
			
			for(int i: graph[a]) {
				if(v[i] == 0) {
					v[i] = v[a]+1;
					max = Math.max(max, v[i]);
					q.offer(i);
					
					//max = Math.max(max, cnt);
				}
			}
		}
		int ans = 0;
		for(int i = 0; i<101; i++) {
			if(v[i]==max) {
				ans = Math.max(ans, i);
			}
		}
		
		return ans;
	}

}
