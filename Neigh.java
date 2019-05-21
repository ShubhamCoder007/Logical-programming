/* 
 * Enter your code here. Read input from STDIN. Print your output to STDOUT. 
 * Your class should be named CandidateCode.
*/

import java.io.*;
import java.util.*;
public class Neigh {

    public static int[] getPair(int[] a, int N){
        int[] cor = new int[2];
        int s = -9999;

        for(int i = 0; i < N; i++){
            for(int j = 1; j < N ; j++){
                if(i == j || i - j == 1 || j - i == 1)
                    continue;
                if(s == -9999 || s > (a[i] + a[j])){
                    s = a[i] + a[j];
                    cor[0] = a[i];
                    cor[1] = a[j];
                }
            }
        }

        for(int i : a){
            if(i > s){
                int r[] = {i};
                return a;
            }
        }

        return cor;
    }

    public static void main(String args[] ) throws Exception {

    	//Write code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while(T > 0)
        {
            int N = Integer.parseInt(br.readLine());
            String s = br.readLine();
            int[] a = new int[N];
            int k = 0, j = 0;
            for(int i = 0; i < s.length(); i++)
            {
                if(s.charAt(i) == ' '){
                    a[j] = Integer.parseInt(s.substring(k,i));
					System.out.println(" Num : "+a[j]);
					j++;
                    k = i + 1;
                }
				a[j + 1] = Integer.parseInt(s.substring(k + 1));
				System.out.println(" Num : "+a[j+1]);
            }

            int r[] = getPair(a, N);
            for(int i: r)
                System.out.print(i);

            T--;
        }

   }
}
