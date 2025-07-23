/*
 * [0] [1] 읽고 아니면 [1][2] 읽고 아니면 [2][3]읽고... ([i][i+1]이 dz면 하나 더 읽어보기)
 *  [0][1] 읽고 맞으면 [2][3]읽고...
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String cro = br.readLine();
		int cnt = 0;
		int len = cro.length();
		
		for (int i = 0; i < len; i++) {
			char c = cro.charAt(i);
			if (c =='c' && i < len -1) {
				if(cro.charAt(i+1)=='='|| cro.charAt(i+1) == '-') {
					i++; //i+1까지가 하나의 문자이므로 다음 문자를 건너 뛰기 위해 1증가
				}
			}
				
			else if(c == 'd' && i < len-1) {
				if (cro.charAt(i+1) =='-') {
					i++;
					}
			
				else if(i <len -2&&cro.charAt(i+1)=='z' && cro.charAt(i+2) =='=') {
					i += 2;
				}
			}
			else if((c == 'l' || c =='n' )&& i < len -1) {
				if (cro.charAt(i+1)== 'j') {
					i++;
				}
			}
			else if ((c == 's' || c == 'z') && i < len - 1) {
		        if (cro.charAt(i + 1) == '=')
		          i++;
		    }
				
			cnt++;
		}
		System.out.println(cnt);
		
	}

}
