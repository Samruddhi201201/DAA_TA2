import java.util.*;
public class Main{
   static String itoa(int x,int base)
   {
       boolean negative = false;
       String s = "";
       if (x == 0)
           return "0";
       negative = (x < 0);
       if (negative)
           x = -1 * x;
       while (x != 0)
       {
           s = (x % base) + s;
            
           x = x / base;
       }
       if (negative)
           s = "-" + s;
       return s;
   }
   static void binaryGenerator(int n,int[][] mat,int m,int sum,int[] arr)
    {
        for (int i = 1; i <= n; i++)
        {
     
            
            String a = new String(itoa(i, 2));
            int b=Integer.parseInt(itoa(i, 2));
            // System.out.println(b+" ");
            int copy=b;
            int checksum=0;
            int k=1;
            while(copy!=0){
                int d=copy%10;
                checksum+=d*arr[m-k];
                k++;
                copy=copy/10;

            }
            if(checksum==sum){
                System.out.println(b);
            }
            
        }
    }
       public static void main(String[] args) {
               Scanner sc=new Scanner(System.in);
               System.out.println("Enter value of n: ");
               int n=sc.nextInt();
               int[] a=new int[n];
               System.out.println("enter n values: ");
               for(int i=0;i<n;i++)
                      a[i]=sc.nextInt();
               System.out.println("Enter value for m: ");
               int m=sc.nextInt();
               int rows=1;
               for(int i=0;i<n;i++){
                      rows*=2;
               }
               int mat[][] =new int[rows][n];
               System.out.println("Rows(in binary) that result in m are=");
              binaryGenerator(rows-1,mat,n,m,a);


      }
}