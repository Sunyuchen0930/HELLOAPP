/*
双色球系统-业务分析
投注号码由6个红色球号码和1个蓝色球号码组成。红色球号码从1—33中选择﹔蓝色球号码从1—16中选择。

*/


import java.util.Random;

public class BadDoubleBalls {
    public static void main(String[] args) {
        System.out.println("开奖了");
        printarr(lucky());
    }
//    随机生成一组中奖号码
    public static int [] lucky(){
        int a [] = new int [7];
        Random r = new Random();
        a[0]  = r.nextInt(33)+1;
        a[6]=r.nextInt(16)+1;
        for (int i = 0; i < 5; i++) {//0,0,0,0,0,0
            //                             i 在这里，只需要辨认i前面的位置
            int newr = r.nextInt(33)+1;
            for (int j = 0; j < 6; j++) {
                if(newr==a[j]){
                    System.out.println("第"+(2+i)+"个随机的红色球跟第"+(j+1)+"个红色球有重复，重新随机一个数");
                    newr = r.nextInt(33)+1;//这个newr是没被判断的，怎么办呢！？
                    //再随机一个，知道不重复位置，如何一直判断呢？
                    i--;
                }
            }

            a[i+1] = newr;
        }

        return a;
    }

    public static void printarr(int a []){
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
    }

}

