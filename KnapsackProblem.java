import java.util.*;
import java.lang.*;
import java.io.*;

class KnapsackProblem{
	public static void main(String[] args)
	{
		Scanner input=new Scanner(System.in);
		System.out.println("\n Enter maximum capacity");
		int m=input.nextInt();
		System.out.println("\n enter the total no. of items");
		int n=input.nextInt();
		System.out.println("enter the weight of each element");
		int[]w=new int[n+1];
		w[0]=0;
		for(int i=1;i<n;i++)
		{
			System.out.println("weight of item"+i);
			w[i]=input.nextInt();
		}
	 	System.out.println("enter profit of each item");
		int []p=new int[n+1];
		p[0]=0;
		for (int i=1;i<=n;i++)
		{
			System.out.println("profit of item"+i);
			p[i]=input.nextInt();
		}
		System.out.println("Running Dynamic knapsack");
		DynamicKnapsack problemOne=new DynamicKnapsack();
		problemOne.runknapsack(m,n,w,p);
		System.out.println("running greedy knapscak");
		GreedyKnapsack problemTwo= new GreedyKnapsack();
		problemTwo.runknapsack(m,n,w,p);
	}


class DynamicKnapsack{
	  void runknapsack(int m,int n,int[]w,int[]p){
		int v[][]=new int[n+1][m+1];
		for (int i=0;i<=n;i++)
		{
			for (int j=0;j<=m;j++)
			{
				if(i==0||j==0)
				{
					v[i][j]=0;
				}
				else if(w[i]>j)
				{
					v[i][j]=v[i-1][j];
				}
				else
				{
				  if (v[i-1][j]>(p[i]+v[i-1][j-w[i]]))
					{
				        	v[i][j]=v[i-1][j];
					}
				  else
				        {
						v[i][j]=p[i]+v[i-1][j-w[i]];
					}
				}
			}
		}
		System.out.println("max profit is"+"  "+ v[n][m]);
      		int selected[]=new int[n+1];
		for (int i=0;i<n+1;i++)
		{
	         selected[i]=0;
 		}
                int i=n;
		int j=m;
		while(i>0&& j>0)
	        {
	 	 if (v[i][j]!=v[i-1][j])
		   {
	   		selected[i]=1;
     			j=j-w[i];
		    }
                i--;
	       }

	       System.out.println("items in knapsack");
	       for(int k=0;k<=n;k++)
	       {
		       if(selected[k]==1)
		       {
			       System.out.println("item"+k+"\t");
		       }
	       }
	       System.out.println("\n\n\n\n");
	}
}
  class GreedyKnapsack{
			  void runknapsack(int m,int n,int[]w,int[]p)
			{
				int maxIndex=-1;
			
				double remaining=(double)m;
				double x[]=new double[n+1];
				for(int i=0;i<=n;i++)
				{
					x[i]=0.0;
				}
				int i,k;
				for(i=1;i<=n;i++){
					double maxElement=0.0;
				for( k=1;k<=n;k++){
					if (maxElement<((double)p[k]/(double)w[k])&&x[k]==0.0)
					{
						maxElement=(double)p[k]/(double)w[k];
						maxIndex=k;
					}
				}
				if(w[maxIndex]>remaining)
				{	
				break;
				}
				remaining=remaining-w[maxIndex];
				x[maxIndex]=1;
				}

				if(i<=n)
				{
					x[maxIndex]=remaining/w[maxIndex];
				}
				double maxValue=0.0;
				System.out.println("items Included:");
				for(int j=1;j<=n;j++)
				{
				if (x[j]!=0)
				{
				System.out.println("item"+j+"("+x[j]+")"+"\t");
				maxValue=maxValue+(p[j]*x[j]);
				}
				}
				System.out.println("max profit:"+maxValue);
				System.out.println("x array");
				for(int l=0;l<=n;l++){
				System.out.println(x[l]);
			}
		    }
               }
}




