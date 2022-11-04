import java.util.Random;
import java.util.Scanner;

public class RandSort {
    public static void main(String[] args) {
      /*  某公司开发部5名开发人员，要进行项目进展汇报演讲，现在采取随机排名后进行汇报。
        请先依次录入5名员工的工号，然后展示出一组随机的排名顺序。*/
//        int num [] = new int [] {22,33,35,80,13};


        int num [] = new int [5];
        Scanner input = new Scanner(System.in);
        System.out.println("请输入员工工号录入5人");
        for (int i = 0; i < num.length; i++) {
            System.out.println("请输入第"+(i+1)+"人工号");
            num [i] = input.nextInt();
        }
//        依次遍历数组中的每个元素，随机一个索引数据，让当前元素与该索引位置处的元素进行交换。
        for (int i = 0; i < num.length; i++) {
            Random r = new Random();
            int rand1 = r.nextInt(num.length);
//            swap(num[i],num[rand1]);
            int temp = 0;
            temp = num [i];
            num[i] = num [rand1];
            num[rand1] = temp;
        }

        for (int i = 0; i < num.length; i++) {
            System.out.println("随机输出数组");
            System.err.print(num[i]+"\n");
        }


    }
}
