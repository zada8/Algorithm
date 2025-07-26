import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		String[] gArr = {"A+","A0","B+","B0","C+","C0","D+","D0","F"};
		double[] sArr = {4.5, 4.0, 3.5, 3.0 , 2.5, 2.0, 1.5, 1.0, 0.0};
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Double sum = 0.0; //점수 총합 계산
		
		double sSum = 0; //들은 학점 총합
		for (int i = 0; i < 20; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			st.nextToken(); //과목명
			double score = Double.parseDouble(st.nextToken()); //학점 
			String grade = st.nextToken(); //등급
			
			for (int j = 0; j <gArr.length; j++) {
				if(gArr[j].equals(grade)) {
					sum += (Double)(sArr[j])*score;
					sSum += score;
					
				}
			}
			
		}
		System.out.println(sum/sSum);
		
	}

}
