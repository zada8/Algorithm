
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
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); //도시의 개수
		int m = Integer.parseInt(br.readLine()); //버스의 개수
		List<Edge>[] graph = new ArrayList[n+1];
		for(int i = 0; i<n+1; i++) {
			graph[i] = new ArrayList<>();
		}
		for(int i = 0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph[s].add(new Edge(e, w));
		}
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st2.nextToken());
		int dest = Integer.parseInt(st2.nextToken());
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		int[] dist = new int[n+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		boolean[] v = new boolean[n+1];
		
		pq.offer(new Edge(start,0));
		dist[start] = 0;
		int[] parent = new int[n+1]; //경로 추척을 위한 배열
		
		while(!pq.isEmpty()) {
			Edge now = pq.poll();
			if(v[now.edge]) continue;
			v[now.edge]= true;
			
			if(now.edge == dest) break;
			
			for(Edge edge : graph[now.edge]) {
				int newCost = dist[now.edge]+edge.w;
				if(newCost<dist[edge.edge]) {
					dist[edge.edge] = newCost;
					parent[edge.edge] = now.edge; //부모 정점 기록
					pq.offer(new Edge(edge.edge, dist[edge.edge]));
				}
			}
		}
		
		//최소 경로 배열
		List<Integer> route = new ArrayList<>();
		int current = dest; //마지막 정점 번호
		while(true) {
			route.add(current);
			if(current == start) break;
			current = parent[current]; //부모 정점
			
		}
		Collections.reverse(route);
		
		//최소비용 출력
		System.out.println(dist[dest]);
		//경로에 포함된 도시 개수
		System.out.println(route.size());
		//도시 출력
		for(int i = 0; i<route.size(); i++) {
			System.out.print(route.get(i)+" ");
		}
		
	}

}
