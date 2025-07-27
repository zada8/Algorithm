import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] array = new int[9][9];
		int max = 0;
		int row = 0;
		int col = 0;
		for (int i = 0; i< 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j<9; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
				if(array[i][j] >= max) {
					max = array[i][j];
					row = i+1;
					col = j+1;
				}
			}
		}
		System.out.println(max);
		System.out.println(row +" "+col);

	}

}
