# DAA_TA2
Task-

Step 1: Create an array of size : x

Step 2: Input an integer: m

Step 3: Sort the array

Part1-Write a program to create a nxn array of “0” and “1”, such that, when summation of {n[i]*x[i]} is equal to integer “m”.

Print the rows of nxn array resulting in “m”

Part2-Write a program to create “z” rows out of “n” rows of “nxn” array and predict the row such that {n[i]*x[i]} resulting in “m”. 

# Approach Used-

In this program we first take an array of size n and a  desired sum value(m) from user.
The task is to find all such rows of 0 and 1 such that selected elements give a sum of m.
Here, 
      1 depicts selection of the value and 0 depicts rejection of the value.
In the first part of the solution we find all the rows that result exactly in m.
In the second part of the solution we find all the rows that may result in m. Here threshold value is taken as 10.So if sum lies in the range [m-10,m+10] then that row is also printed.

# Code

Part1-

```
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
               System.out.println("Rows(in binary) that may result in m are=");
              binaryGenerator(rows-1,mat,n,m,a);


      }
}
```
### Test cases-

Test case 1- 

<img width="329" alt="image" src="https://user-images.githubusercontent.com/115890753/203993166-b94cf7b1-804f-4e75-8b2c-9a50ff54bbb6.png">

11 represents 0011 as total length is 4.
So, 11 x 0 + 13 x 0 + 24 x 1 + 7 x 1 =31

1101
So, (1 x 11) + (1 x 13) + (0 x 24) + (1 x 7) =31


Test case 2-

<img width="307" alt="image" src="https://user-images.githubusercontent.com/115890753/203993659-598ddba5-96d3-4784-a406-b0879ad8af64.png">

110 represents 000110 as total length is 6.
So, (0 x 12) + (0 x 6) + (0 x 1) + (1 x 13) + (1 x 10) + (5 x 0) = 23

101010
So, (1 x 12) +(0 x 6) +(1 x 1) +(0 x 13) +(1 x 10) +(0 x 5) = 23


Test case 3- when sum of any elements of array is not equal to desired sum then program returns no output

<img width="335" alt="image" src="https://user-images.githubusercontent.com/115890753/203993930-c3242a22-a204-463c-bc52-960a1bb1a516.png">

Test case4- when desired sum is smaller than any all elements of the array then program returns no output

<img width="317" alt="image" src="https://user-images.githubusercontent.com/115890753/203994201-899f4014-00a3-4392-a454-307ae76ae180.png">

Test case 5- When sum of all elements is less than the desired sum then program returns no output

<img width="288" alt="image" src="https://user-images.githubusercontent.com/115890753/203994448-6feb10be-08b0-4282-953e-475e21bdb3b2.png">

Part2-

```
import java.util.*;
public class Main2{
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
            if(Math.abs(checksum-sum)<=10){
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
               System.out.println("Rows(in binary) that may result in m are=");
              binaryGenerator(rows-1,mat,n,m,a);


      }
}
```
Test case 1-

<img width="249" alt="image" src="https://user-images.githubusercontent.com/115890753/203997018-ad1f239c-86b7-42ea-a471-dc4b783404f9.png">

Test case 2-

<img width="281" alt="image" src="https://user-images.githubusercontent.com/115890753/203997177-4904434e-110f-40fe-a8a3-569cc00181d4.png">

Test case 3-

<img width="281" alt="image" src="https://user-images.githubusercontent.com/115890753/203997292-2050a44b-ebc3-48fb-81f0-fbbdcb8f1886.png">

Test case 4-

<img width="244" alt="image" src="https://user-images.githubusercontent.com/115890753/203997414-7f63e984-9cd3-4793-9c6f-8ba53c2fdb3b.png">

Test case 5-

<img width="240" alt="image" src="https://user-images.githubusercontent.com/115890753/203997526-e6d855fb-4d17-4d7d-8ef0-abe751dc738c.png">
