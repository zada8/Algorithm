
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //저장된 사이트 주소의 수
		int M = Integer.parseInt(st.nextToken()); //비밀번호를 찾으려는 사이트 주소의 수
		
		Map<String, String> pwList = new HashMap<>();
		for(int i = 0; i<N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			String site = st2.nextToken();
			String pw = st2.nextToken();
			pwList.put(site, pw);
		}
		//찾기
		for(int i = 0; i<M; i++) {
			String site = br.readLine();
			String ans = pwList.get(site);
			System.out.println(ans);
		}
	}

}
