
public class StringSearchingRabinKarp {

	 
	    static void search(String pat, String txt, int q)
	    {
	        int M = pat.length();
	        int N = txt.length();
	        int i, j;
	        int p = 0; // hash value for pattern
	        int t = 0; // hash value for txt
	        
	        for (i = 0; i < M; i++)
	        {
	          
	            p = (int)Math.pow(q, i)*pat.charAt(i) + p;
	            t = (int)Math.pow(q, i)*txt.charAt(i) + t;
	        }
	        
	        System.out.println("Pattern hash: "+p);
	        System.out.println("Text hash: "+t);
	     
	        // Slide the pattern over text one by one
	        for (i = 0; i <= N - M; i++)
	        {
	     
	            
	            if ( p == t )
	            {
	                for (j = 0; j < M; j++)
	                {
	                    if (txt.charAt(i+j) != pat.charAt(j))
	                        break;
	                }
	     
	                if (j == M)
	                    System.out.println("Pattern found at index: " + i);
	            }
	     
	            if ( i < N-M )
	            {
	            	t = (int) ((t - txt.charAt(i))/q + txt.charAt(i+M)*Math.pow(q,(M-1)));
	                
	                if (t < 0)
	                t = (t + q);
	            }
	        }
	    }
	     
	
	    public static void main(String[] args)
	    {
	        String txt = "absfedsdfabc";
	        String pat = "sdfa";
	        int q = 3;
	        search(pat, txt, q);
	    }

}
