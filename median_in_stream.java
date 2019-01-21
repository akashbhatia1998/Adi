import java.lang.*;
import java.io.*;

class GFG {
    static void addNumber(int n , PriorityQueue<Integer> lower , PriorityQueue<Integer> higher)
    {
        if(lower.size() == 0 || lower.peek() > n)
        {
            lower.add(n);
        }
        else
            higher.add(n);
    }
    static void balance( PriorityQueue <Integer> lower , PriorityQueue <Integer> higher)
    {
        PriorityQueue <Integer> bigger = ((lower.size() > higher.size()) ? lower : higher);
        PriorityQueue <Integer> small = ((lower.size() > higher.size())?higher : lower);
        if(bigger.size() - small.size() >= 2)
             small.add(bigger.poll());
    }
    static int answer(PriorityQueue <Integer> lower , PriorityQueue <Integer> higher)
    {
        PriorityQueue <Integer> bigger = ((lower.size() > higher.size()) ? lower : higher);
        PriorityQueue <Integer> small = ((lower.size() > higher.size())?higher : lower);
        if(bigger.size() == small.size()) return ((small.peek() + bigger.peek())/2);
        else
           return (bigger.peek());
        
    }
	public static void main (String[] args) {
	    int t ;
	    Scanner sc = new Scanner(System.in);
	    t = sc.nextInt();
	    PriorityQueue <Integer> lower = new PriorityQueue <Integer>
	    (
	        new Comparator<Integer>() {
	            public int compare(Integer a , Integer b){
	                return -1*a.compareTo(b);
	            }
	            
	            });
	   PriorityQueue<Integer> higher = new PriorityQueue<Integer>();
	   int arr[] = new int[t];
	    for(int i = 0 ; i < t; i++)
	    {
	        int n = sc.nextInt();
	        arr[i] = n;
	        addNumber(arr[i] , lower , higher);
	        balance(lower , higher);
	        int ans = answer(lower , higher);
	        System.out.println(ans);
	    }
	}
}

