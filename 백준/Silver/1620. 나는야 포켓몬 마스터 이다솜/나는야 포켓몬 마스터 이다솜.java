import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //포켓몬의 개수
		int M = Integer.parseInt(st.nextToken()); //문제의 개수
		Map<String, String> numToPoke = new HashMap<>();
		Map<String, String> pokeToNum = new HashMap<>();
		
		for(int i = 1; i<=N; i++) {
			String name = br.readLine();
			numToPoke.put(i+"", name);
			pokeToNum.put(name, i+"");
		}
		
		for(int i = 0; i<M; i++) {
			String q = br.readLine();
			if(numToPoke.containsKey(q)) {
				System.out.println(numToPoke.get(q)); 
			}
			else {
				System.out.println(pokeToNum.get(q));
			}
		}
	}

}
