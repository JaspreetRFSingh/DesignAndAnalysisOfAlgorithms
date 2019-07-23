import java.util.Scanner;

public class Dijkstra
{
    static Scanner scan; // scan is a Scanner Object
 
    public static void main(String[] args)
    {
    	int nodes;
    	scan = new Scanner(System.in);
    	System.out.print("Enter number of nodes: ");
    	nodes = scan.nextInt();
        int[] preD = new int[nodes];
        int min = 999, nextNode = 0; // min holds the minimum value, nextNode holds the value for the next node.
        int[] distance = new int[nodes]; // the distance matrix
        int[][] matrix = new int[nodes][nodes]; // the actual matrix
        int[] visited = new int[nodes]; // the visited array
 
        System.out.println("Enter the cost matrix");
 
        for (int i = 0; i < distance.length; i++)
        {
            visited[i] = 0; //initialize visited array to zeros
            preD[i] = 0;
 
            System.out.println("Enter row "+(i+1)+": ");
            for (int j = 0; j < distance.length; j++)
            {
                matrix[i][j] = scan.nextInt(); //fill the matrix
                if (matrix[i][j]==0)
                    matrix[i][j] = 999; // make the zeros as 999
            }
        }
 
        
        System.out.println("Matrix:- ");
        for(int i =0; i<nodes; i++)
        {
        	for(int j = 0; j<nodes; j++)
        	{
        		System.out.print(matrix[i][j]+" ");
        	}
        	System.out.println();
        }
        
        distance = matrix[0]; //initialize the distance array
        visited[0] = 1; //set the source node as visited
        distance[0] = 0; //set the distance from source to source to zero which is the starting point
 
        for (int counter = 0; counter < nodes; counter++)
        {
            min = 999;
            for (int i = 0; i < nodes; i++)
            {
                if (min > distance[i] && visited[i]!=1)
                {
                    min = distance[i];
                    nextNode = i;
                }
            }
 
            visited[nextNode] = 1;
            for (int i = 0; i < nodes; i++)
            {
                if (visited[i]!=1)
                {
                    if (min+matrix[nextNode][i] < distance[i])
                    {
                        distance[i] = min+matrix[nextNode][i];
                        preD[i] = nextNode;
                    }
 
                }
 
            }
 
        }
 
        for(int i = 0; i < nodes; i++)
            System.out.print("|" + distance[i]);
 
        System.out.println("|");
 
        int j;
        for (int i = 0; i < nodes; i++)
        {
            if (i!=0)
            {
 
                System.out.print("Path = " + (i+1));
                j = i;
                do
                {
                    j = preD[j];
                    System.out.print(" <- " + (j+1));
                }
                while(j != 0);
            }
            System.out.println();
        }
    }
}
