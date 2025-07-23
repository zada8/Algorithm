import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String voca = br.readLine(); //일단 String으로 입력 받기
		char[] v_char = voca.toCharArray();  //String을 char배열로 바꾸기
		int[] alphabet = new int[26];
		
		for(int i = 0; i < v_char.length; i++) { //대문자로 다 바꾸기
			if (v_char[i] >= 'a'){
				//A = 65, a = 97
				v_char[i] -=('a'-'A');
			}
		}
		
		for(int j = 0; j < v_char.length; j++) {
			int a = v_char[j] - 65;
			alphabet[a] += 1;  
		}
		
		int max = 0;
		for(int k = 0; k < alphabet.length; k++) {
			max = Math.max(max, alphabet[k]);
		}
		int max_cnt = 0;
		int max_index = 0;
		for(int q = 0; q < alphabet.length; q++) {
			if (alphabet[q] == max) {
				max_index =q;
				max_cnt++;
			}
		}
		if(max_cnt >1) {
			System.out.println("?");
		}
		else {
			System.out.println((char)(max_index+'A'));
		}
		
		}

}
