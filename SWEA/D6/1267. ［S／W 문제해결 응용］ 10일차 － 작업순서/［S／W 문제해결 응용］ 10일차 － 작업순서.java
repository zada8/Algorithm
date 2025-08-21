
import java.io.*;
import java.util.*;

public class Solution {

	static int V;
	static ArrayList<Integer>[] graph;
	static ArrayList<Integer>[] reverseGraph;
	static int cnt = 0;
	static int[] v;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t = 1; t<= 10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken()); //정점의 개수
			int E = Integer.parseInt(st.nextToken()); //간선의 개수
			
			graph = new ArrayList[V];
			reverseGraph = new ArrayList[V];
			
			for(int i = 0; i<V; i++) {
				graph[i] = new ArrayList<Integer>();
				reverseGraph[i] = new ArrayList<Integer>();
				
			}
			
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for(int i = 0; i<E; i++) {
				int a = Integer.parseInt(st2.nextToken());
				int b = Integer.parseInt(st2.nextToken());
				graph[a-1].add(b-1);
				reverseGraph[b-1].add(a-1);
			}
			/*
			for(int i = 0; i<V; i++) {
				System.out.println(graph[i].toString());
			}
			*/
			bfs();
			System.out.print("#"+t+" ");
			for(int i = 0; i<V; i++) {
				for(int j = 0; j<V; j++) {
					if(v[j] == i) {
						System.out.print(j+1+" ");
					}
				}
			}
			System.out.println();	
		}
	}
	
	static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		v = new int[V]; 
		cnt = 0;
		for(int i = 0; i<V; i++) {
			if(reverseGraph[i].size() == 0 && v[i] == 0) { //선행 작업이 아무것도 없음
				q.offer(i);
				v[i] = cnt++;
				
				while(!q.isEmpty()) {
					int cur = q.poll();
					for(int j:graph[cur]) {
						reverseGraph[j].remove(0);
						if(reverseGraph[j].size() == 0 &&v[j] == 0) {
							q.offer(j);
							v[j] = cnt++;
							
						}
					}
				}
				
			}
		}
		
	}

}
