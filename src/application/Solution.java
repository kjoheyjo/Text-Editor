package application;

/* package codechef; // don't place package name! */
import java.util.*;
import java.lang.*;
import java.math.BigInteger;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Solution
{	
	
	
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String a = "";
		int n = 0 ; 
		int k = 0;
		int p = 0;
		int t = 0; 
		String line = "";
		
		int temp = 0 ; 
		int tempSum = 0;
		
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		LinkedList<Integer> sumList = new LinkedList<Integer>();
		
		char c;
		
		String query = "";
	
		if((line = reader.readLine()) != null){
		   
			String[] arr = line.split(" ");
			
			n = Integer.parseInt(arr[0]);
			k = Integer.parseInt(arr[1]);
			p = Integer.parseInt(arr[2]);
			
		}
		
			
			line =  reader.readLine();
			
			String[] ar = line.split(" ");
			int[] sum = new int[ar.length];
			
 			tempSum = 0;
			String s = "";
			int maxCount = 0; 
			
			for(int i = 0 ; i < ar.length ; i++){
				
				s = ar[i];
				
				temp = Integer.parseInt(s) ;
				
				tempSum = tempSum + temp;
				sum[i] = tempSum;
				
				list.add(temp);
				
				if(i - k >= 0){
					temp = tempSum - sum[i - k] ;
				}else {
					temp = tempSum ;
				}
				
				if(temp > maxCount){
					maxCount = temp;
				}
				
				sumList.add(temp);
				
				
			}
		
			
		    query = reader.readLine();
			
			for(int i = 0 ; i < p ; i++){
				
				c = query.charAt(i);
				
				if(c == '!'){
					
					temp = list.removeLast();
					list.addFirst(temp);
					
					sumList.removeLast();
					
					if(temp == 0){
						
						sumList.addFirst(0);
						
					}else if(temp == 1){
						
						sumList.addFirst(1);
						
						for(int j = 1 ; j < k ; j++ ){
							
							temp = sumList.get(i)+1;
							
							if(temp > maxCount){
								maxCount = temp;
							}
							
							sumList.set(i,temp);
							
						}
						
					}
					
				}else if(c == '?'){
					
					System.out.println(maxCount);
					
					
				}
				
			}
		
	}

	private static void rotate(LinkedList<Integer> list, LinkedList<Integer> sumList) {
		
		
		
	}
	
	
	
	
	    
	  
}