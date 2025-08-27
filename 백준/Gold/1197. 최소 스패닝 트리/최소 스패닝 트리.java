
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static class Vertex implements Comparable<Vertex>{
		int e, w; //e:정점번호 w:가중치
		Vertex(int e, int w){
			this.e=e;
			this.w=w;
		}
		@Override
		public int compareTo(Vertex o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.w, o.w);
		}
	}
	
	static class Edge{
		int to, cost;
		Edge(int to, int cost){
			this.to = to;
			this.cost = cost;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		//int[][] adj = new int[V+1][V+1];
		List<List<Edge>> adj = new ArrayList<>();
		for(int i = 0; i<=V; i++) {
			adj.add(new ArrayList<>());
		}
		
		
		for(int i = 0; i<E; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st2.nextToken());
			int b = Integer.parseInt(st2.nextToken());
			int c = Integer.parseInt(st2.nextToken());
			
			adj.get(a).add(new Edge(b,c));
			adj.get(b).add(new Edge(a,c));
			
		}
		// prim
		// 거리배열
		int[] dist = new int[V+1];
		// 거리배열을 무한대로 초기화
		Arrays.fill(dist, Integer.MAX_VALUE);
		// 방문배열
		boolean[] v = new boolean[V+1];

		// 임의의 정점
		dist[1] = 0;
		// 향상된 프림
		// 최소거리정점을 구하기 위한 priorityQueue 를 생성합니다
		PriorityQueue<Vertex> PQ = new PriorityQueue<>();
		// 1번 정점을 PQ 에 넣는다
		// 이때 PQ에 들어가 있는 정점들은 가중치의 오름차순으로 정렬(힙정렬)된다
		PQ.offer(new Vertex(1, 0));
		
		int sum = 0;
		
		while(!PQ.isEmpty()) {
			// p 는 가중치가 가장작은 정점으로 기준정점 역활을 하게된다
			Vertex p = PQ.poll();
			// 방문여부확인
			// 방문했다면 pass.....
			if(v[p.e]) continue;
			// 방문안했다면
			// 방문체크를 한다
			v[p.e] = true;
			sum += p.w;
			
			// 기준정점 p.e 에서 연결되어진 타켓정점을 찾아서 pq에 넣어준다
			// 이때 i 는 기준정점에서 가려고 하는 타켓정점이 된다
			/*
			for (int i = 1; i <= V; i++) {
				if(!v[i]&&adj[p.e][i]!=0&&adj[p.e][i]<dist[i]) {
					dist[i]=adj[p.e][i];
					PQ.add(new Vertex(i, adj[p.e][i]));
				}
			}
			*/
			for(Edge edge: adj.get(p.e)) {
				int i = edge.to;
				int cost = edge.cost;
				if(!v[i] && cost<dist[i]) {
					dist[i] = cost;
					PQ.add(new Vertex(i,cost));
				}
			}
			
			
		}
		System.out.println(sum);
		

	}

}
