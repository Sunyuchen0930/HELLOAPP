public class CreatemethodsinClass {
    public static void main(String[] args) {
        int a =50;
        int b = sums(a);
        int c [] = new int [] {3,0,11,334,2};
        System.out.println(b);
        System.out.println(JudgeOddOrEven(a));
        System.out.println(ChooseMax(c));
        System.out.println("地址"+c);//地址不变
        System.out.println("值"+c[0]);//地址不变
        change(c);
        System.out.println("地址"+c);
        System.out.println("值"+c[0]);
        System.out.println(a);
        changeint(a);
        System.out.println(a);//不会改的，因为形参变了只是值传递
    }
    public static int sums(int n){
//        需求：定义一个方法，方法中计算出 1到n的和并返回。
        int sum =0 ;
        for (int i = 1; i <=n; i++) {
            sum +=i;
        }
        return sum;
    }
//    需求：拿一个整数，然后调用方法，把整数交给方法，在方法中输出该数为奇数还是偶数
    public static String JudgeOddOrEven (int a){
        if(a%2==0){
            return "even";
        }
        else return "odd";
    }

    public static  int ChooseMax(int a[]){
        int max =a[0];//数组第一个作为参照，别0 了
        for (int i = 0; i < a.length; i++) {
            if(max<a[i]) max = a[i];
        }
        return max;
    }
    public static int[] change(int a[]){
        a[0]=9999;
        return a;
    }

    public static int changeint(int a){
        a=1000009;
        return a;
    }


}
