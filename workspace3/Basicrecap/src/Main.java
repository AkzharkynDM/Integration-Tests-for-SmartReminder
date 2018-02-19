//https://github.com/DistributedSystems2018/BasicJavaRecap

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class Main {	
		
		public static void main (String[] args) {
		System.out.println("Hello, world");
		System.out.println("1. Working with command line arguments...");

		System.out.println("i. print how many of them there are"+args.length);
		System.out.println("ii. print them in order line by line");
	        for (String s: args) {		
			System.out.println(s); 
	        }
		System.out.println("iii. print them in order line by line, with sequence numbers");
		int counter=0;
		for (String s: args) {	
			counter++;      	
			System.out.println(counter+" "+s); 
	        }
		System.out.println("iv.print them in reverse order");
		for (int i=args.length-1; i==0; i--){
			System.out.println(args[i]); 
		}
		System.out.println("v.print their lengths");
		for (String s: args) {				
			System.out.println(s.length()); 
	        }
		System.out.println("vi.supposing that they are all numbers...");
		int sum=0;
		for (Object s: args) {	
			if (s.getClass().equals(Integer.class))
				sum+=(Integer) s;	
		}
		System.out.println("print their sum "+sum);
		System.out.println("print only the even numbers");
		for (Object s: args) {	
			if (s.getClass().equals(Integer.class)){
				int toInt=(Integer) s;
				if (toInt%2==0)
				System.out.println(toInt);	
				}
		}
		
		counter=0;
		for (Object s: args) {	
			if (s.getClass().equals(Integer.class)){
			counter++;
			}
		}
		if (counter==args.length){
		System.out.println("print them in numerical order");
		Arrays.sort(args);
		System.out.println(Arrays.toString(args));
		}
		
		counter=0;
		for (Object s: args) {	
			if (s.getClass().equals(String.class)){
			counter++;
			}
		}
		if (counter==args.length){
		System.out.println("vii.print them in alphabetical order");
		Arrays.sort(args);
		System.out.println(Arrays.toString(args));
		}
		System.out.println("3. After that...");
		counter=0;
		for (Object s: args) {	
			if (s.getClass().equals(Integer.class)){
			counter++;
			}
		}
		if (counter==args.length){
		System.out.println("i. Make a Fibonacci function, using the recursive definition.");
		System.out.println("Enter the number for fibonacci");
		Scanner sc = new Scanner(System.in);
	     	int n = sc.nextInt();
		System.out.println(fibonacci(n));
		sc.close();
		}
		counter=0;
		for (Object s: args) {	
			if (s.getClass().equals(Integer.class)){
			counter++;
			}
		}
		
		if (counter==args.length){
		System.out.println("ii. Make another version that uses iteration.");
		System.out.println("Enter the number for fibonacci");
		Scanner sc = new Scanner(System.in);
	     	int n = sc.nextInt();
		System.out.println(fibIteration(n));
		sc.close();
		}
		counter=0;
		for (Object s: args) {	
			if (s.getClass().equals(Integer.class)){
			counter++;
			}
		}
		if (counter==args.length){
		System.out.println("iii. Make another version that returns all the numbers up to the given value in an array.");
		System.out.println("Enter the number for fibonacci");
		Scanner sc = new Scanner(System.in);
	     	int n = sc.nextInt();
		fibIterationPrint(n);
		sc.close();
		}
		
		System.out.println("4. Print all divisors of the number given in the first command line argument.");
		try{
		int s= Integer.parseInt(args[0]);		
		for (int i = 2; i < s; i++) {
	    	if (s % i == 0)
	        System.out.print(i + " , ");
			}
		} catch (Exception e) {
		System.out.println("It is not an integer");
		}
				
		System.out.println("5.a. Find the function that takes the square root of numbers.");
		try{
		int s= Integer.parseInt(args[0]);		
		System.out.println(squareRootFunction(s));		
		} catch (Exception e) {
		System.out.println("It is not an integer");
		}		

		System.out.println("6. The command line arguments contains an expression in reverse Polish notation, which consists of the four basic operations and integers. Calculate the value of the expression.");
		List<Integer> integersPart=new ArrayList<Integer>();
		List<Character> operationsPart=new ArrayList<Character>();
		int allInts = (int) Math.ceil(args.length/2);
		try{
		for (int i=0;i<allInts;i++){
			integersPart.add(Integer.parseInt(args[i]));		
		}	
		for (int i=allInts;i<args.length;i++){
			operationsPart.add(args[i].charAt(0));		
		}
		int result=0;
		for (int i=0;i<operationsPart.size();i++){
			for (int k=integersPart.size()-1;k==0;k--){
				if (operationsPart.get(i)=='*')
				result*=integersPart.get(k);
				if (operationsPart.get(i)=='+')
				result+=integersPart.get(k);
				if (operationsPart.get(i)=='-')
				result-=integersPart.get(k);			
			}
		}
		System.out.println(result);
		} catch (Exception e) {
			System.out.println("It is not an integer");
			}
	    }
		
		//end of main 
		public static int fibonacci(int n)  {
	    		if(n == 0)
	        		return 0;
	    		else if(n == 1)
	     	 		return 1;
	   		else
	      			return fibonacci(n - 1) + fibonacci(n - 2);
		}

		public static int fibIteration(int n) {
	        int i=0,result=1,prevresult=1;
			while(i<n-1){
				int temp=result;
				result=result+prevresult;
				prevresult=temp;
				i++;
			}
			
			return result;
	    	}
		public static void fibIterationPrint(int n) {
	        int i=0,result=1,prevresult=1;
			while(i<n-1){
				int temp=result;
				result=result+prevresult;
				prevresult=temp;
				i++;
				System.out.println(result);
			}		
	    	}
		public static double squareRootFunction(int n){
			return Math.sqrt(n);
		}
		
	

}
