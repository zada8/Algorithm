
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	public static ArrayList<Integer>[] graph;
	private static boolean[] v;
	private static int cnt;
	private static int N;
	private static int M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N];
		
		
		for(int i = 0; i<N; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i<M; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st2.nextToken());
			int b = Integer.parseInt(st2.nextToken());
			graph[b-1].add(a-1);
		}
		for(int i = 0; i<N; i++) {
			if(graph[i].size()!=0) {
				Collections.sort(graph[i]);
			}
		}
		int max = 0;
		int[] num = new int[N];
		
		for(int i = 0; i<N; i++) {
			v = new boolean[N];
			v[i] = true;
			cnt = 0;
			dfs(i);
			num[i] = cnt;
			max = Math.max(max, cnt);
		}
		for(int i = 0; i<N; i++) {
			if(num[i] == max) {
				System.out.print((i+1)+" ");
			}
		}
		System.out.println();
		
		
	}
	
	public static void dfs(int idx) {
		
		for(int i:graph[idx]) {
			if(!v[i]) {
				v[i] = true;
				cnt++;
				dfs(i);
			}
		}
	}

}
