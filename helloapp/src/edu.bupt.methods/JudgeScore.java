/*
需求 :
        在唱歌比赛中，有6名评委给选手打分，分数范围是[0 - 100]之间的整数。
        选手的最后得分为：去掉最高分、最低分后的4个评委的平均分，请完成上述过程并计算出选手的得分。
*/

import java.util.Scanner;

public class JudgeScore {
    public static void main(String[] args) {
        int peoples = 6;
        System.out.println("激动人心的打分环节开始辣~~~~~~");
        Scanner input = new Scanner(System.in);
        int a [] = new int [peoples];
        for (int i = 0; i < peoples; i++) {
            System.out.println("请输入第"+(i+1)+"个评委的分数：");
            a[i] = input.nextInt();
        }
        System.out.println("选手综合得分是："+check(a));
    }
    public static double check(int [] a){
        int max = a[0];
        int min = a[0];
        double sum = 0;
        for (int i = 0; i < a.length; i++) {
            if(max<a[i]){
                max = a [i];
            }
        }
        for (int i = 0; i < a.length; i++) {
            if(min>a[i]){
                min = a[i];
            }
        }
        boolean flagmax = false;
        boolean flagmin = false;
        for (int i = 0; i < a.length; i++) {
            if(a[i]==max && flagmax ==false){
                System.out.println("去掉一个最高分"+max);
                flagmax = true;
                continue;
            }
            if(a[i]==min && flagmin ==false){
                System.out.println("去掉一个最低分"+min);
                flagmin = true;
                continue;
            }
            sum += a[i];
        }
        return sum/(a.length-2);
    }
}
