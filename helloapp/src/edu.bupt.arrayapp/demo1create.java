import java.util.Random;
import java.util.Scanner;

public class demo1create {
    public static void main(String[] args) {
        double scores[] = new double[]{55.5, 66.5, 90};
        System.out.println(scores);
//        [D@119d7047
        System.out.println(scores.length);
        double s[] = new double[5];
        s[1] = 100;
        System.out.println(s[0]);
//        某部门5名员工的销售额分别是：16、26、36、6、100，请计算出他们部门的总销售额。
        int arr[] = new int[]{16, 26, 36, 6, 100};
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += arr[i];
        }
        System.out.println("销售额是：" + sum);


    }
}
