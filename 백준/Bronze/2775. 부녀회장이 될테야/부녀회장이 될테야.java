import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i< T; i++) { //테스트케이스
			int k = Integer.parseInt(br.readLine()); //k층,
			int n = Integer.parseInt(br.readLine());  //n호에 사는 사람 수
			
			int[][] apt = new int[k+1][n];
			for (int j = 0; j < k+1; j++) {
				for (int l = 0; l <n; l++) {
					if (j == 0) { //0층
						apt[j][l] = l + 1;
					}
					else if (l == 0) {
						apt[j][l] = 1;
					}
					else {
						for(int m = 0; m <= l; m++) {
							apt[j][l] += apt[j-1][m];
						}
					}
					
				}
			}
			System.out.println(apt[k][n-1]);
		}
	}

}
