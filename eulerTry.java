import java.util.*;
public class eulerTry 
{
    public static int f(int n)
    {
        int arr[] = new int[20];
        for(int i=0; i<20; i++) arr[i] = 1;
        int temp = 0;
        int ctr = 0;
        int final_result = 0;
        while (n>0)
        {
            temp = n%10;
            while (temp>0)
            {
                arr[ctr] = arr[ctr] * temp;
                temp = temp - 1;
            }
            n = n/10;
            ++ctr;
        }
        for(int i=0; i<ctr; i++) final_result = final_result + arr[i];
        return final_result;
    }
    public static int sf(int n)
    {
        int o1 = n;
        int sum = 0;
        int temp = 0;
        int fn = f(n);
        while (fn > 0)
        {
            temp = fn%10;
            sum = sum+temp;
            fn = fn/10;
        }
        //System.out.println("sf("+o1+") = "+sum);
        return sum;
    }
    public static int g(int i)
    {
        int temp1 = 10000;
        int temp2, smallest=0;
        while (temp1>0)
        {
            temp2 = sf(temp1);
            if (temp2==i)
            {
                smallest = temp1;
            }
            --temp1;
        }
        //System.out.println("g("+i+") = "+smallest);
        return smallest;
    }
    public static int sg(int i)
    {
        int o1 = i;
        int sum = 0;
        int temp = 0;
        int gi = g(i);
        while (gi > 0)
        {
            temp = gi%10;
            sum = sum+temp;
            gi = gi/10;
        }
        //System.out.println("sg("+o1+") = "+sum);
        return sum;
    }
    public static void main(String args[]) 
    {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt(), sum = 0;
        int n[] = new int[q];
        int m[] = new int[q];
        for(int i=0; i<q; i++)
        {
            n[i] = sc.nextInt();
            m[i] = sc.nextInt();
        }
        /*System.out.println("f(342) = "+f(342));
        /*sf(342);
        sf(25);
        g(5);
        g(20);
        sg(5);
        sg(20);*/
        //System.out.print(g(5));
        //f(342);
        /*for(int i=1; i<=3; i++)
        {
            sg(i);
        }*/
        for(int i=0; i<q; i++)
        {
            sum = 0;
            for(int j=1; j<=n[i]; j++)
            {
                sum += sg(j);
                //System.out.println("Sum = "+sum);
            }
            System.out.println(sum%m[i]);
        }
    }
}
