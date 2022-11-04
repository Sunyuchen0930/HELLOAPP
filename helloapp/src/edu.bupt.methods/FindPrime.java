/*
除了1和它本身以外，不能被其他正整数整除，就叫素数。
判断101-200内有多少素数，并输出所有素数
判断规则是：从2开始遍历到该数的一半的数据，看是否有数据可以整除它，有则不是素数，没有则是素数。

*/

import static java.lang.Math.sqrt;

public class FindPrime {
    public static void main(String[] args) {
       int a[] =new int[21];
       //好烦这个必须知道个数定义的数组
       a = check2(a);
       for (int i = 0; i < a.length; i++) {
           System.out.println(a[i]);
        }
    }
    public static int[] check(int a []){
        int count = 0;
        boolean flag = true;
        for (int i =101; i<=200; i++) {
            for (int j =2;j<i/2;j++){
                //从2开始遍历到该数的一半的数据，看是否有数据可以整除它，有则不是素数，没有则是素数。
                if(i%j==0){
                    flag = false;
                    break;
                }
            }
            if(flag){ a[count++]=i;}
            flag = true;//可以不用flag，直接sum-max-min
        }
        System.out.println("一共有"+count+"个素数");
        return a;
    }

    public static int[] check2(int a []){
        int count = 0;
        boolean flag = true;
        for (int i =101; i<=200; i++) {
            for (int j =2;j<=sqrt(i);j++){//小于等于根号i，不是小于！
                //从2开始遍历到该数的一半的数据，看是否有数据可以整除它，有则不是素数，没有则是素数。
                if(i%j==0){
                    flag = false;
                    break;
                }
            }
            if(flag){ a[count++]=i;}
            flag = true;
        }
        System.out.println("一共有"+count+"个素数");
        return a;

    }
}
