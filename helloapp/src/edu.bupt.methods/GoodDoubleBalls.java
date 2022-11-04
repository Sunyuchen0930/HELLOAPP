import java.util.Random;
import java.util.Scanner;

public class GoodDoubleBalls {
    public static void main(String[] args) {
        int a []=new int [7];
        a = lucky(a);
        //调用一次lucky，相当于出了一期中奖号码
        System.out.println("开奖啦");
        printarr(a);
        System.out.println("请输入您的号码");
        int prize = usercheck(a);
        System.out.print("你是的奖金是："+prize);
    }

    public static int [] lucky(int a[] ){
        Random r = new Random();
        a[6] = r.nextInt(16)+1;
        //1、错在没想到一直判定可以使用死循环
        //3、错在i的范围是0-5，i小于6而不是5，data可以正常赋值，不用i+1为下标
        //0,0,0,0,0,0
        //      i下标3 在这里，只需要辨认i前面的位置，与0,1,2比，所以j小于i
        //j就是i之前的内容，data需要跟他之前的比
        //2、错在这里，不用往后比那么多，j不是小于6，而是小于i！！
        for (int i = 0; i < a.length-1; i++) {
            while(true){
                int data = r.nextInt(33)+1;
                boolean flag = true;
                for (int j = 0; j < i; j++) {
                    if(a[j]==data){
                        System.out.println("重复");
                        flag = false;
                        break;
                    }
                }
                //没有重复成功赋值退出死循环
                if(flag){
                    a[i] = data;
                    break;
                }
                //有重复就继续死循环，去随机新的data，而不能break
            }
        }
        return a;
    }

    public static void printarr(int a []){
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
    }

    public static int usercheck(int []b){
        System.out.println("请输入您的7个球号码！");
        Scanner input = new Scanner(System.in);
        int a [] = new int [7];
        boolean flag1 = true;
        System.out.println("请输入您的蓝色球号码");
        a[6] = input.nextInt();
        for (int i = 0; i < 6; i++) {
            while(true){
                System.out.println("请输入第"+(i+1)+"个红球号码,要求不重复！");
                int temp = input.nextInt();
                for (int j = 0; j < i; j++) {
                    flag1=true;
                    if(temp==a[j]){
                        System.out.println("您的输入有重复，请重新输入");
                        flag1 = false;
                        break;
                    }
                }
                if(flag1) {
                    a[i]=temp;
                    break;
                }
            }
        }

        System.out.println("你的号码最后是");
        printarr(a);
        System.out.println("奖池号码是");
        printarr(b);

        int redcount = 0;
        int bluecount = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if(a[i] == b[j]){
                    redcount++;
                    System.out.println("\n你中了"+redcount+"个红色球");
                }
            }
        }
        if(a[6]==b[6]){
            bluecount++;
            System.out.println("你中了"+bluecount+"个蓝色球");
        }

        if(redcount==6&&bluecount==1){
            System.out.println("\n一等奖，最高1000万");
            return 10000000;
        }
        else if(redcount==6&&bluecount==0){
            System.out.println("\n二等奖，最高500万");
            return 5000000;
        }
        else if(redcount==5&&bluecount==1){
            System.out.println("\n三等奖，3000元");
            return 3000;
        }
        else if(redcount==5||redcount==4&&bluecount==1){
            System.out.println("\n四等奖，200元");
            return 200;
        }
        else if(redcount==4||redcount==3&&bluecount==1){
            System.out.println("\n五等奖，10元");
            return 10;
        }
        else if(redcount==1&&bluecount==1||redcount==2&&bluecount==1||bluecount==1){
            System.out.println("\n六等奖，5元");
            return 5;
        }
        else{
            System.out.println("\n很遗憾没中奖呀~~~");
            return 0;
        }
    }

}
