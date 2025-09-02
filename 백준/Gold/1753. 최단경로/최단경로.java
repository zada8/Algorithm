
import java.io.*;
import java.util.*;

public class Main {

	static class Edge implements Comparable<Edge>{
		int edge, w;
		Edge(int edge, int w){
			this.edge = edge;
			this.w = w;
		}
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.w - o.w;
		}
		
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken()); //정점의 개수
		int E = Integer.parseInt(st.nextToken()); //간선의 개수
		
		int K = Integer.parseInt(br.readLine()); //시작정점의 번호
		
		List<Edge>[] graph = new ArrayList[V+1];
		for(int i = 1; i<V+1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i = 0; i<E; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st2.nextToken());
			int b = Integer.parseInt(st2.nextToken());
			int c = Integer.parseInt(st2.nextToken());
			
			graph[a].add(new Edge(b,c));
		}
		
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		//boolean[] v = new boolean[V+1];
		int[] dist = new int[V+1];
		for(int i = 0; i<V+1; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		pq.offer(new Edge(K,0));
		dist[K] = 0;
		
		while(!pq.isEmpty()) {
			Edge now = pq.poll();
			if(now.w>dist[now.edge]) continue;
			
			for(Edge newEdge:graph[now.edge]) {
				if(now.w+newEdge.w<dist[newEdge.edge]) {
					dist[newEdge.edge] = now.w+newEdge.w;
					pq.offer(new Edge(newEdge.edge, now.w+newEdge.w)); 
				
				}
			
			}
		}
		
		for(int i = 1; i<V+1; i++) {
			if(dist[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			}
			else {
				System.out.println(dist[i]);
			}
		}
	}

}
