/*
需求:
        机票价格按照淡季旺季、头等舱和经济舱收费；
        输入机票原价、月份和头等舱或经济舱。
        机票最终优惠价格的计算方案如下：旺季（5-10月）头等舱9折，经济舱8.5折，淡季（11月到来年4月）头等舱7折，经济舱6.5折。
*/

import java.util.Scanner;

public class BuyTickets {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("请输入原始票价");
        double fee = input.nextDouble();
        System.out.println("请输入月份");
        int month = input.nextInt();
        System.out.println("请输入头等舱或经济舱");
        String seat = input.next();
        double finalfee = check(fee,month,seat);
        System.out.println("机票原价"+fee+"现在是"+finalfee+"元");

    }

    public static double check(double fee,int month,String seat){
        double discount = 1;
        if(month>=5&&month<=10){
            System.out.println("现在是旺季");
            if(seat.equals("头等舱")){
                System.out.println("头等舱9折");
                discount = 0.9;
            }
            else if (seat.equals("经济舱")){
                System.out.println("经济舱85折");
                discount = 0.85;
            }
            else System.out.println("请输入正确的座位舱类型！");
        }

        else if (month>=1&&month<5 || month>10&&month<=12){//注意月份呢不是0！！
            System.out.println("现在是淡季");
            if(seat.equals("头等舱")){
                System.out.println("头等舱7折");
                discount = 0.7;
            }
            else if (seat.equals("经济舱")){
                System.out.println("经济舱65折");
                discount = 0.65;
            }
            else System.out.println("请输入正确的座位舱类型！");
        }
        else System.out.println("请输入正确的月份！");
        return fee*discount;
    }
}
