
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	private static ArrayList<Integer>[] graph;
	private static boolean[] v;
	private static int cnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //컴퓨터 수
		int M = Integer.parseInt(br.readLine()); //연결된 컴퓨터 쌍의 수
		graph = new ArrayList[N];
		v = new boolean[N];
		
		for(int i = 0; i<N; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		for(int i = 0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a-1].add(b-1);
			graph[b-1].add(a-1);
		}
		//그래프 완성
		
		v[0] = true;
		dfs(0);
		System.out.println(cnt);
		
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
