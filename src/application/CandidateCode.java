package application;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class CandidateCode {
    
	
	public static int SolveMagicSquare(int[][] square)
    {
	    int n = square[0].length; 
	    
	    if(square[0][0] != 1 && square[0][0] != 0){
	        return 0;
	    }else if(square[0][0] == 0){
	        square[0][0] = 1;
	    }
	    
	    // fill obvious choices, like only 1 left in row col or subsquare
	    
	    
	    if(checkValidity(square)){
	        
	        if(checkSolvability(square)){
				
	        	return 1;
	        	
			}else{
				return 0;
			}
	        
	    }else{
	        return 0;
	    }
          
    }
    
    public static boolean checkValidity(int[][] s){
        if(s.length != s[0].length){
            return false;
        }
        int n = s.length;
        int index = 0 ;
        int rootN = (int) Math.sqrt(n);
        //boolean r[n][n],c[n][n],sub[rootN][rootN][n];
		
		boolean[][] r = new boolean[n][n];
		boolean[][] c = new boolean[n][n];
		boolean[][][] sub = new boolean[rootN][rootN][n];
		
        for(int i = 0 ; i <  n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(s[i][j] != 0 ){
                    index = s[i][j] - 1;
                    
                    if(r[i][index]){
                        return false;
                    }else{
                        r[i][index] = true;
                    }
                    if(c[i][index]){
                        return false;
                    }else{
                        c[i][index] = true;
                    }
                    if(sub[i/rootN][j/rootN][index]){
                        return false;
                    }else{
                        sub[i/rootN][j/rootN][index] = true;
                    }
                }
            }
        }
        
        return true;
    }
    
    public static boolean checkSolvability(int[][] s){
        int n = s.length;
        int index = 0 ;
        int rootN = (int) Math.sqrt(n);
        //boolean r[n][n],col[n][n],sub[rootN][rootN][n];
		
		boolean[][] r = new boolean[n][n];
		boolean[][] c = new boolean[n][n];
		boolean[][][] sub = new boolean[rootN][rootN][n];
		
		int[][][] fill = new int[n][n][n];
		
		for(int i = 0 ; i <  n ; i++){
            for(int j = 0 ; j < n ; j++){
                
              if( s[i][j] != 0){
				index = s[i][j] - 1;
				
				r[i][index] = true;
                    
                c[i][index] = true;
                    
                sub[i/rootN][j/rootN][index] = true;        
              }      
                    
				}
                
            }
        
		
		// code to fill all possible values where cells are blank.
		int findex = 0;
		for(int i = 0 ; i < n ; i++){
			for(int j = 0 ; j < n ; j++){
				
				findex = 0;
				
				if( s[i][j] == 0 ){
				
				for(int ind = 0 ; ind < n ; ind++){
					
					if(!r[i][ind] && !c[j][ind] && !sub[i / rootN][j / rootN][ind]) {
						
						fill[i][j][findex++] = ind;
						
						
					}
							
				}
				
				if(findex == 0){
					return false;
				}
				
				}
	
			}
		}
		
		
		checkAndSolve(s,fill);
		
		
			return true;
		
		
		}
		
	
	private static void checkAndSolve(int[][] s, int[][][] fill) {
		// TODO Auto-generated method stub
		int n = s.length;
		int ind = 0;
		
		for(int i = 0 ; i < n ; i++){
			for(int j = 0 ; j  < n ; j++){
				
				ind =  0;
				
				if(s[i][j] != 0){
					
					s[i][j] = fill[i][j][ind++];
					
					if(checkValidity(s)){
						
						checkAndSolve(s,fill);
						
					}else{
						
						
						
					}
					
				}
				
			}
		}
		
	}

	public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        int output = 0;
        int ip1_rows = 0;
        int ip1_cols = 0;
        ip1_rows = Integer.parseInt(in.nextLine().trim());
        ip1_cols = Integer.parseInt(in.nextLine().trim());
        
        int[][] ip1 = new int[ip1_rows][ip1_cols];
        for(int ip1_i=0; ip1_i<ip1_rows; ip1_i++) {
            for(int ip1_j=0; ip1_j<ip1_cols; ip1_j++) {
                ip1[ip1_i][ip1_j] = in.nextInt();
                
            }
        }
        output = SolveMagicSquare(ip1);
        System.out.println(String.valueOf(output));
    }
}

