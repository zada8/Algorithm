
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	private static String num;
	private static int cng;
	private static char[] nArr;
	private static int max;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i = 1; i<=T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			num = st.nextToken(); //숫자카드
			cng = Integer.parseInt(st.nextToken()); //교환 횟수
			
			nArr = num.toCharArray(); //숫자카드를 문자 배열로
			max = 0;
			back(0, 0);
			System.out.println("#"+i+" "+max);
		}
	}
	
	public static void back(int idx, int cnt) {
		if(cnt == cng) {
			String current = new String(nArr); //nArr배열을 String으로
			int currentValue = Integer.parseInt(current);
			if(currentValue>max) {
				max = currentValue;
			}
			return;
		}
		for(int i = idx; i <nArr.length-1; i++) {
			for(int j = i+1; j<nArr.length; j++ ) {
				change(i,j);
				 
				back(i, cnt+1);
				
				change(i,j);
			}
		}
	}
	
	private static void change(int i, int j) {
		char temp = nArr[i];
		nArr[i] = nArr[j];
		nArr[j] = temp;
	}

}
