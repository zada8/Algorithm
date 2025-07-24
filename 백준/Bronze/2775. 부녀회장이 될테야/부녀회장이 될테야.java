import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        for(int tc=1;tc<=t;tc++){
            int a=Integer.parseInt(br.readLine());
            int b=Integer.parseInt(br.readLine());

            int apt[][] = new int[a+1][b];
            for(int i=0;i<b;i++){
                apt[0][i]=i+1;
            }
            for(int i=1;i<a+1;i++){
                for(int j=0;j<b;j++){
                    if(j==0)
                        apt[i][j]=apt[i-1][j];
                    else
                        apt[i][j]=apt[i-1][j]+apt[i][j-1];
                }
            }
            System.out.println(apt[a][b-1]);
        }
    }
}