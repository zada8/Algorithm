import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		
		for (int i = 0; i < N; i++) {
			boolean isG = true;
			int x = 0;//인덱스 
			String voca = br.readLine();
			char[] a = new char[26]; //알파벳
			
			for (int j = 0; j < voca.length(); j++) {
				x = voca.charAt(j)-'a';
				if (a[x] == 0) {
					a[x] += 1;
				}
				else {
					for(int k = 1; k <= a[x]; k++) {
						if(voca.charAt(j-k)!=voca.charAt(j)) {
							isG = false;
							break;
						}
					}
				}
				
			}
			if(isG) {
				cnt++;
			}
			
					
		}
		System.out.println(cnt);
		
	}
}
