import java.util.Scanner;

public class ShortestPath {

	Scanner sc = new Scanner(System.in);
	final int max = 10;
	final int INFINITY = 1000;
	int w[][];
	int n_size;
	int p[];
	void in_dat()
	{
	System.out.println("\n\t Multi-Stage Graph \n");
	System.out.println("\n Enter the number of nodes : ");
	n_size = sc.nextInt();
	int i;
	for(i=0;i<n_size;i++)
	{
	w[i][i] = 0;
	for(int j=i+1;j<n_size;j++)
	{
		System.out.println("Enter the weight of edge "+(65+i)+" to " +(65+j)+": ");
		w[i][j] = sc.nextInt();
		w[j][i] = 0;
	}
	}
	}
	
	void dis_dat()
	{
		System.out.println("\n The Path adjacent matrix \n");
		System.out.println("\n ");
	for(int i=0;i<n_size;i++)
	{
		System.out.println("\n");
	for(int j=0;j<n_size;j++)
		System.out.println("\t"+w[i][j]);
	}
	}
}
