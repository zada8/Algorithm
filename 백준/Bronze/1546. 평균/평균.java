import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;



public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); //과목 개수
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		double[] array = new double[N];
		
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken()); //시험점수
		}
		
		Arrays.sort(array);
		double max_score = array[N-1];
		
		double sum = 0;
		
		for (int i = 0; i < N; i++) {
			array[i] = array[i]/max_score*100;
			sum += array[i];
		}
		
		System.out.println(sum/N);
		
	}

}
