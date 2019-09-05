package com.company;
        import java.util.ArrayList;
        import java.util.List;
        import java.util.Scanner;



class Printclass1 extends Thread
{

    public int n,i;
    public   int[] arr = new int[100];

    public Printclass1(int arr[], int n, int i) //Calling Constructor because we need to pass values
    {
        this.arr = arr;
        this.n=n;
        this.i=i;
    }


    @Override
    public void run()
    {
        Combination(arr,n,i);     //Passing value to method
    }

    static void Combination(int arr[], int n, int i)
    {

        List<Integer> coins = new ArrayList<Integer>();
        coins.add(1);
        coins.add(2);
        coins.add(5);

        if (n == 0)                                        //Exit condition from from Recursive loop
        {    Printingfunction(arr, i);    }

        else if(n > 0)
        {
            for (int k = 1; k <= arr.length; k++)
            {
                if(coins.contains(k))
                {
                    arr[i] = k;
                    Combination(arr, n - k, i + 1);    //Recursion
                }

            }
        }
    }


    public static void Printingfunction(int arr[], int m)           //function to print combinations
    {int i;
        for (i = 0; i < m; i++)

            System.out.print(+ arr[i] + "   ");
        System.out.println("{Thread 1}");

        try {
            Thread.sleep(500);
        } catch (Exception e) { }

    }

}

class Printclass2 extends Thread {

    public int[] array = new int[100];
    public  int d,i;

    public Printclass2(int arr[],int d,int i)
    {
        this.array=arr;
        this.d=d;
        this.i=i;
    }
    @Override
    public void run( )
    {
        SecondCombination(array, d, 0);
    }

    static void SecondCombination( int arr[], int n, int i)
    {
        List<Integer> coins = new ArrayList<Integer>();
        coins.add(1);
        coins.add(2);
        coins.add(5);

        if (n == 0)       //Exit condition from from Recursive loop
        {
            Printingfunction(arr, i);
        } else if (n > 0) {
            for (int k = 1; k <= arr.length; k++) {
                if (coins.contains(k)) {
                    arr[i] = k;
                    SecondCombination(arr, n - k, i + 1);
                }

            }
        }
    }
    //function to print combinations
    public static void Printingfunction ( int arr[], int m)
    {
        for (int i = 0; i < m; i++)
            System.out.print(+arr[i] + "  ");
        System.out.println("{Thread 2}");
        try {
            Thread.sleep(400);
        } catch (Exception e) { }

    }


}


class Main
{
    public static void main (String[] args) {
        int num = 0, d = 0;
        if (args[0].contains("test")) {

            num = 4;
            System.out.println("Number to test for first Thread: " + num);
       System.out.println();
            d = 3;
            System.out.println("Number to test for second Thread: "+ d);



        }

        int[] arr = new int[num];
        int[] array = new int[d];
        Printclass1 print = new Printclass1(arr, num, 0);//calling first thread(class)
        print.start();


        Printclass2 print2 = new Printclass2(array, d, 0);//calling Second thread(class)
        print2.start();


    }

//        System.out.println("Number to test for second Thread");
//        Scanner number = new Scanner(System.in);
//        int d = number.nextInt();
//        int[] array = new int[d];
//        Printclass2 print2 = new Printclass2(array,d,0);//calling Second thread(class)
//        print2.start();


    }
