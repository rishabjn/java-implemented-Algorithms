import java.util.*;
import java.io.*;

class tsp
{
	static int MAX=100;
	public static int tspDp(int c[][],int tour[],int start,int n)
	{
		int i,j,k,minCost,cost;
		int[] temp=new int[MAX];
		int[] minTour=new int[MAX];
		if(start==(n-2))
		{
			return(c[tour[n-2]][tour[n-1]]+c[tour[n-1]][0]);
		}
		minCost=999;
		for(i=start+1;i<n;i++)
		{
			for(j=0;j<n;j++)
				temp[j]=tour[j];
			temp[start+1]=tour[i];
			temp[i]=tour[start+1];
			if(c[tour[start]][tour[i]]+(cost=tspDp(c,temp,start+1,n))<minCost)
			{
				minCost=c[tour[start]][tour[i]]+cost;
				for(k=0;k<n;k++)
					minTour[k]=temp[k];
			}
		}
		for(i=0;i<n;i++)
			tour[i]=minTour[i];
		return minCost;
	}
	public static void main(String[] args)
		{
			Scanner sc=new Scanner(System.in);
			int n,i,j,minCost;
			int[][]c=new int[MAX][MAX];
			int[]tour=new int[MAX];
			System.out.println("enter the no of cities");
			n=sc.nextInt();
			System.out.println("enter the matrix");
			for(i=0;i<n;i++)
			{
				for(j=0;j<n;j++)
					c[i][j]=sc.nextInt();
			}
			for(i=0;i<n;i++)
				tour[i]=i;
				minCost=tspDp(c,tour,0,n);
				System.out.println("min cost:"+minCost);
				System.out.println("path\n");
				for(i=0;i<n;i++)
					System.out.print((tour[i])+"\t");
					System.out.print("0");
				System.out.println();
			
		}
}	
 
