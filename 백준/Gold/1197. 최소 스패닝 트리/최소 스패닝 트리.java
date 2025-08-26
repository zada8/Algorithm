
import java.io.*;
import java.util.*;

public class Main {

	static class Edge implements Comparable<Edge>{
		int s,e,w;
		
		Edge(int s, int e, int w){
			this.s = s;
			this.e = e;
			this.w = w;
		}
		
		@Override
		public int compareTo(Edge o){
			return (this.w - o.w); 
		}
	}

	private static int[] parents;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V =Integer.parseInt(st.nextToken()); //정점의 개수
		int E =Integer.parseInt(st.nextToken()); //간선의 개수
		
		Edge[] edges = new Edge[E];
		
		for(int i = 0; i<E; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st2.nextToken());
			int e = Integer.parseInt(st2.nextToken());
			int w = Integer.parseInt(st2.nextToken());
			edges[i] = new Edge(s,e,w);
		}
		
		Arrays.sort(edges);
		
		parents = new int[V+1];
		for(int i = 1; i<=V; i++) {
			parents[i] = i;
		}
		
		int cnt = 0;
		long sum = 0;
		
		for(int i = 0; i<E; i++) {
			Edge edge = edges[i];
			//대표값이 다르면
			if(find(edge.e) != find(edge.s)) {
				union(edge.e, edge.s);
				sum += edge.w;
				cnt++;
				if(cnt == V-1) break;
			}
		}
		System.out.println(sum);
		
	}

	private static void union(int e, int s) {
		// TODO Auto-generated method stub
		int a = find(e);
		int b = find(s);
		if(a != b) {
			parents[a] = b;
		}
	}

	private static int find(int e) {
		if(e == parents[e]) return e;
		return parents[e] = find(parents[e]);
	}

}
