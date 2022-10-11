import java.util.Scanner;

public class detech123 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int gewei = n%10;
        int shiwei = n/10%10;
        int baiwei = n/10/10%10;

        System.out.println("个位:"+gewei);
        System.out.println("十位:"+shiwei);
        System.out.println("百位:"+baiwei);
    }
}
