/* package codechef; // don't place package name! */
package application;
import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Solution
{	
	static List<Integer> primes = new ArrayList<Integer>();
	
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int a = 0,b=0 ;
		String nos = "";
		int t = 0; 
		String line = "";
		if((line = reader.readLine()) != null){
		    t = Integer.parseInt(line); 
		}
		
	    String[] arr = new String[2];
	    for(int i = 0 ; i < t ; i++){
	        
	    	nos = reader.readLine();
	    	
	    	arr = nos.split(" ");
	    	
	        a = Integer.parseInt(arr[0]);
	        b = Integer.parseInt(arr[1]);
	        
	        int p = 0;
	        int pIndex = 0;
	        
	        for(int k = 2 ; k  < Math.sqrt(1000000000) ; k++){
	        	primes.add(k);
	        }
	        
	        Iterator<Integer> it ;
	        int temp = 0;
	        
	        while(pIndex < primes.size()){
	        	
	        	it = primes.iterator();
	        	
	        	 p = primes.get(pIndex++);
	        	
	        	 while(it.hasNext()){
	        		 
	        		 temp = it.next(); 
	        		 
	 	        	if( temp % p == 0 && temp != p){
	 	        		
	 	        		it.remove();
	 	        		
	 	        	}
	 	        	
	 	        }
	        	 
	        	
	        }
	       
	        
	        printPrimes(a,b);
	        System.out.println();
	        
	        
	    }
		
		
	}
	
	public static void printPrimes(int a, int b){
	    
		boolean flag = false;
		
		for(int i = a ; i <= b ; i++){
			
			if(isPrime(i)){
				System.out.println(i);
			}
			
		}
		
	    
	}

	private static boolean isPrime(int i) {
		
		for(int j : primes){
			if(i % j == 0){
				return false;
			}
		}
		
		return true;
	}
	    
	  
}
