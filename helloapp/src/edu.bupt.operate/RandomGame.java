import java.util.Random;
import java.util.Scanner;

public class RandomGame {
    public static void main(String[] args) {
        Random rand = new Random();
        int r1 = rand.nextInt(100)+1;
        System.out.println("猜猜随机数是多少呀");
        while(true){
            System.out.println("请输入：");
            Scanner input = new Scanner(System.in);
            int g = input.nextInt();
            if(g==r1){
                System.out.println("你居然猜对了，随机数是"+r1);
                break;
            }
            else if(g>r1){
                System.out.println("猜大啦，再试试吧！");
            }
            else System.out.println("猜小了，再试试吧！");
        }

    }
}
