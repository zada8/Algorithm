
import java.io.*;
import java.util.*;


public class Main {

	static int N;
	static int v1;
	static int v2;
	static final int INF = 200000000;
	
	private static List<Node>[] graph;
	static class Node implements Comparable<Node>{
		int node, w;
		Node(int node, int w){
			this.node = node;
			this.w = w;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.w - o.w;
		}
	}
	//1번 정점에서 마지막 정점까지 최단 경로 구하는데 v1,v2를 무조건 지나야됨
	//1번 정점에서 v1까지의 최단 경로 , 1번 정점에서 v2까지의 최단경로 
	//v1에서 v2까지의 최단 경로
	//v1에서 마지막 정점까지의 최단경로, v2에서 마지막 정점까지의 최단경로
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); //정점개수
		int E = Integer.parseInt(st.nextToken()); //간선개수
		
		graph = new ArrayList[N+1];
		for(int i = 0; i<N+1; i++) {
			graph[i] = new ArrayList<>();
		}
		for(int i = 0; i<E; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st2.nextToken());
			int b = Integer.parseInt(st2.nextToken());
			int c = Integer.parseInt(st2.nextToken());
			graph[a].add(new Node(b,c));
			graph[b].add(new Node(a,c));
		}
		
		
		StringTokenizer st3 = new StringTokenizer(br.readLine());
		v1 = Integer.parseInt(st3.nextToken());
		v2 = Integer.parseInt(st3.nextToken());
			
		
		int[] startNodeDist = new int[N+1];
		int[] v1Dist = new int[N+1];
		int[] v2Dist = new int[N+1];
		
		
		Arrays.fill(startNodeDist, INF);
		Arrays.fill(v1Dist, INF);
		Arrays.fill(v2Dist, INF);
		
		Dijkstra(startNodeDist, 1);
		Dijkstra(v1Dist, v1);
		Dijkstra(v2Dist, v2);
		
		int route1 = startNodeDist[v1]+v1Dist[v2]+v2Dist[N];
		int route2 = startNodeDist[v2]+v1Dist[N]+v2Dist[v1];
		
		int min = Math.min(route1, route2);
		
		if(min>= INF) {
			System.out.println(-1);
		}
		else System.out.println(min);
		
		
	}
	
	static void Dijkstra(int[] dist, int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] v = new boolean[N+1];
		pq.offer(new Node(start, 0));
		dist[start] = 0;
		
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			if(v[now.node]) continue;
			v[now.node] = true; 
			for(Node newNode:graph[now.node]) {
				
				int newDist = dist[now.node]+newNode.w;
				if(newDist<dist[newNode.node]) {
					dist[newNode.node] = newDist;
					pq.add(new Node(newNode.node, newDist));
				}
			}
		}
	}

}
