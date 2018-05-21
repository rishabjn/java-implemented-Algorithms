import java.util.Scanner;
import java.lang.*;

class PrimsAlgorithm{
	public static void main(String []args)
	{
		Scanner input=new Scanner(System.in);
		System.out.println("enter the no of vertices in graph");
		int n=input.nextInt();
		int g[][]=new int[n][n];

		System.out.println("enter the graph");
		for (int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			 {
				g[i][j]=input.nextInt();
			 }
		}
		System.out.println("the entered graph is ");
		for(int i=0;i<n;i++)
		{
			for (int j=0;j<n;j++)
			{
				System.out.print(g[i][j]+"\t");
			}
			System.out.println("");
		}
		System.out.println("\nrunning the prims algorithm:");
		PrimsAlgo g1 = new PrimsAlgo();
		g1.minimumCost(g,n);
	}
}

class PrimsAlgo
 {
	 Scanner input=new Scanner(System.in);
	 int minimumCost(int g[][],int n)
	 {
		 int vertex=0;
		 int min=999;
		 int cost=0;
		 int u=0;
		 int v=0;
	int visited []=new int[n];
	for (int i=0;i<n;i++)
	{
		visited[i]=0;
	}
	visited[0]=1;
	vertex=vertex+1;

	while(vertex<n)
	{
		min=999;
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
			 if(visited[i]==1 && visited[j]==0 && g[i][j]<min)
			 	{
					u=i;
				 	v=j;
				 	min=g[i][j];
			 	}
			}
		}
          if (visited[u]==1 && visited[v]==0)
	   { 
		visited[v]=1;
		cost=cost+min;
		vertex=vertex+1;
		g[u][v]=g[v][u]=999;
		System.out.println("edge "+ u +" ("+ min +" )"+v);
	   }
	}
	System.out.println("cost is "+cost);
	return cost;
	}
     }





