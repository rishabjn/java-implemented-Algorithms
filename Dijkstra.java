import java.util.*;
import java.lang.*;
import java.io.*;

class Dijkstra{
	public static void printDistance(int dis[],int src,int n)
	{
		for(int i=0;i<n;i++)
		{
			System.out.println("distance from"+" " +src+" to "+i+" is "+dis[i]);
		}
	}
  	public static void algorithm(int adg[][],int src,int n,int dist[],int par[],int vis[])
	{
		int u=-1,v,i,j,min;
		for(i=0;i<n;i++)
		{
			if(adg[src][i]!=999 && vis[i]==0)
			{
				dist[i]=adg[src][i];
				par[i]=src;
			}
		}
		for (i=1;i<n;i++)
		{
			min=999;
		 	for(j=0;j<n;j++)
			{
				if(dist[j]<min && vis[j]==0)
				{
					min=dist[j];
					u=j;
				}
			}
			vis[u]=1;
			for(v=0;v<n;v++)
			{
				if((dist[u]+adg[u][v]<dist[v])&&(vis[v]==0))
				{
					dist[v]=dist[u]+adg[u][v];
					par[v]=u;
				}
			}
		}//end of for loop
	}//end of algo

	public static void main(String []args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the no of vertices");
		int n=sc.nextInt();
		int adg[][]=new int [n][n];
		int vis[]=new int[n];
		int parent[]=new int[n];
		int dist[]=new int[n];
		System.out.println("enter the graph");
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				adg[i][j]=sc.nextInt();
			}
		}
		System.out.println("the graph");
		for (int i=0;i<n;i++)
		{
		 for (int j=0;j<n;j++)
		 {
			System.out.print(adg[i][j]+"\t");
			}
		 System.out.println();
		}
		System.out.println("enter the source");
		int src=sc.nextInt();
		int i;
		for(i=0;i<n;i++)
		{
			dist[i]=999;
			parent[i]=-1;
			vis[i]=0;
		}
		vis[src]=1;
		parent[src]=-1;
		dist[src]=0;
		algorithm(adg,src,n,dist,parent,vis);
		printDistance(dist,src,n);
		}
	}

