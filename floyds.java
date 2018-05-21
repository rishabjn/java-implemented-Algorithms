import java.util.Scanner;
import java.util.*;
import java.io.*;
class floyds
{
	public static int minimum(int a,int b)
	{
		return(a<b?a:b);
	}
	public static void algorithm(int dist[][],int n)
	{
		for(int k=0;k<n;k++)
		{
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					dist[i][j]=minimum(dist[i][j],dist[i][k]+dist[k][j]);
				}
			}
		}
	}
	public static void main(String[] args)
	{
		int [][]dist=new int[50][50];
		int n;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the no of vertices");
		n=sc.nextInt();
		System.out.println("enter the adjacency matrix");
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
				dist[i][j]=sc.nextInt();
		}
		algorithm(dist,n);
		System.out.println("the final matrix");
		for(int i=0;i<n;i++)
		{
			System.out.println();
			for(int j=0;j<n;j++)
				System.out.print(dist[i][j]+"\t");
		}
	}
}					

