/*
需求：
        某系统的数字密码：比如1983，采用加密方式进行传输，
        规则如下：先得到每位数，然后每位数都加上5,再对10求余，最后将所有数字反转，得到一串新数。
*/

import java.util.Scanner;

public class Encryption {
    public static void main(String[] args) {
        System.out.println("input your digital password：");
        Scanner input = new Scanner(System.in);
        long password = input.nextInt();
        long pss = password;
        int len = 0;
        while(password%10!=0){//如何获取整数位数
            len++;
            password /= 10;
        }
        System.out.println("您的密码是"+len+"位");
        int a [] = secret(pss,len);
        System.out.println("您的密码已加密传输~密文是：");
        for (int i = 0; i < len; i++) {
            System.out.print(a[i]);
        }
        System.out.println("\n");
        System.out.println("您的密码不幸被破解了，密码是：");
        int b [] = decrypt(a,len);
        for (int i = 0; i < len; i++) {
            System.out.print(b[i]);
        }
    }
/*    将每位数据存入到数组中去，遍历数组每位数据按照规则进行更改，把更改后的数据从新存入到数组中。
    将数组的前后元素进行交换，数组中的最终元素就是加密后的结果。*/
    public static int [] secret(long password,int len){
        int chu = 1;
        int a [] = new int [len];
        for (int i = 0; i < len; i++) {
            if(i==0){
                a[i] =(int) (password%10);
            }
            else{
                a[i] =(int)(password/chu%10);
            }
            chu*=10;
        }
        for (int i = 0; i < len; i++) {
            a[i] += 5;
            a[i] %= 10;
        }
//        数字翻转不用了，上面已经存位数的时候是翻转过的。
        return a;
    }
    //        请将加密后的数据解密出来
    public static int [] decrypt(int b [],int len){
        for (int i = 0; i < len/2; i++) {
            int temp =b[i];
            b[i] = b[len-1-i];
            b[len-1-i] = temp;
        }
        
//        也可以换个方法交换
//        for (int i = 0,j=len-1; i < j; i++,j--) {
//            //交换b[i]、b[j]
//        }
        //只有明文大于等于5的数字才需要进位，所以5+5得到0,6+5得到1，7+5得到2,8+5得到3,9+5得到4
        //而明文0-4的内容+5之后会变成5-9
        for (int i = 0; i < len; i++) {
            if(b[i]<=9&&b[i]>=5){
                b[i]=b[i]-5;
            }
            else if(b[i]>=0&&b[i]<=4){
                b[i] = b[i]+5;
            }
        }
        return b;
    }
}
