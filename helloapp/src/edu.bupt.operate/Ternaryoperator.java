import java.util.Scanner;

public class Ternaryoperator {
    public static void main(String[] args) {
//        需求：找出三者最大值，运用三元运算符
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();
//        step1:找出二者最大值
        int temp = a>b?a:b;
//        step2:二者最大的临时值与第三值比较，取最大值
        int max = temp>c?temp:c;
        int newmax = a>b?a>c?a:c:b>c?b:c;
        System.out.println(newmax);
        System.out.println(max);
        System.out.println(10 > 3 || 10 > 3 && 10 < 3);  // true
        System.out.println( (10 > 3 || 10 > 3 ) && 10 < 3);  // false
        String st = a>5?"chicken":"dog";
        System.out.println(st);


    }
}
