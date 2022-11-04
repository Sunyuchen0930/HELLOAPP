import java.util.Random;
import java.util.Scanner;

public class RandGameArrayVerision {
    public static void main(String[] args) {
        System.out.println("猜数字小游戏数组版");
        Random r = new Random();
        int rand1[] = new int[6];
        for (int i = 0; i < 5; i++) {
            rand1[i] = r.nextInt(20)+1;
        }
        Scanner input = new Scanner(System.in);
        System.out.println("输入1-20的整数：");
        int count = 0;
        OUT:
        //新学的~
        while(true){
            boolean flag = false;//不用flag怎么办呢
            int a = input.nextInt();
            for (int i = 0; i < 5; i++) {
                if(a == rand1[i]) {
                    System.out.println("随机数" + a + "猜中了，他在数组的位置是rand1[" + i + "]");
                    flag = true ;
                    count++;
                    break OUT;//这样就可以结束整个死循环而不是for循环
                }
            }
            if(flag){
                System.out.println("你猜中了"+count+"次，按1继续，按其他结束游戏");
                if(input.nextInt()==1){
                    System.out.println("再试试看，输入1-20的整数：");
                }
                else {
                    System.out.println("所有的随机数是");
                    for (int i = 0; i < 5; i++) {

                        System.out.println("随机数" + rand1[i] + "在数组的位置是rand1[" + i + "]");
                    }
                    System.out.println("游戏结束");
                    break;
                }
            }
            else System.out.println("没命中，再试试看");
            for (int i = 0; i < 5; i++) {
                System.out.println(rand1[i]);

            }

        }
    }
}
