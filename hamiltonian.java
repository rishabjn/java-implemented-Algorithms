import java.util.*;
import java.io.*;
import java.lang.*;

class hamiltonian{
   int adj[][],x[],n;
  public hamiltonian(){
    int i;
    Scanner sc = new Scanner(System.in);
    System.out.println("enter number of nodes\n");
    n=sc.nextInt();
    x=new int[n];
    x[0]=0;
    for( i=1;i<n;i++){
      x[i]=-1;

    }
    adj=new int[n][n];
    System.out.println("enter matrix");
    for( i=0;i<n;i++){
      for(int j=0;j<n;j++){
        adj[i][j]=sc.nextInt();

      }
    }
  }
public void nextval(int k){
  int i=0;
  while(true){
    x[k]=x[k]+1;
    if(x[k]==n){
      x[k]=-1;
      if(x[k]==-1)
      return;
	}
      if(adj[x[k-1]][x[k]]==1){
        for(i=0;i<k;i++){
          if(x[i]==x[k])
          break;
        }}
        if(i==k){
          if(k<n-1  || k==n-1 && adj[x[n-1]][0]==1){
          return;
        }}
      
    }
  }

  public void hamil(int k){
    while(true){
      nextval(k);
      if(x[k]==-1){
      return;}
      if(k==n-1){
        System.out.println("solution:");
        for(int i=0;i<n;i++){
          System.out.println((x[i]+1) +"\t");

        }
        System.out.println(1);
      }
      else
      hamil(k+1);

    }
  }}
class Hamil{
  public static void main(String[] args){
    hamiltonian obj = new hamiltonian();
    obj.hamil(1);

  }
}
  
