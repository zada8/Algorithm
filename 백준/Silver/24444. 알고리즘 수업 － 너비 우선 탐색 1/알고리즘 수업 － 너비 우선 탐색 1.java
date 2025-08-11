
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private static ArrayList<Integer>[] graph;
	private static int[] visited;
	private static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //정점의 수 
		int M = Integer.parseInt(st.nextToken()); //간선의 수
		int R = Integer.parseInt(st.nextToken()); //시작 정점
		
		graph = new ArrayList[N];
		visited = new int[N];
		cnt = 1;
		
		for(int i = 0; i<N; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		for(int i =0; i<M; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st2.nextToken());
			int b = Integer.parseInt(st2.nextToken());
			graph[a-1].add(b-1);
			graph[b-1].add(a-1);
		}
		for(int i = 0; i<N; i++) {
			if(graph[i].size()!=0) {
				Collections.sort(graph[i]);
			}
		}
		//오름차순 정렬
		
		bfs(R-1);
		
		for(int i = 0; i<N; i++) {
			System.out.println(visited[i]);
		}
		
	}
	
	public static void bfs(int idx) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(idx);
		visited[idx] = cnt++;
		
		while(!q.isEmpty()) {
			int a = q.poll();
			
			for(int i:graph[a]) {
				if(visited[i] != 0) {
					continue;
				}
				q.offer(i);
				visited[i] = cnt++;
			}
		}

	}

}
