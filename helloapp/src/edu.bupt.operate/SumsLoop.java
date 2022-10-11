public class SumsLoop {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 10; i += 2) {
//            求小于10的奇数和，为什么i=0开始不行？因为0+2永远是偶数，姐
//            i+=2和下面的if条件只需选一个即可！一样的东西判断了2次
            if (i % 2 == 1) {
                sum += i;
            }
        }
//        在循环外定义变量sum累加数据
        System.out.println(sum);
//        需求：在控制台输出所有的“水仙花数”，水仙花数必须满足如下2个要求：
//        水仙花数是一个三位数
//        水仙花数的个位、十位、百位的数字立方和等于原数
//        Scanner input = new Scanner(System.in);
//        int narcissus  = input.nextInt();
//        此处的需求不是判断，而是输出所有水仙花
        int count = 0;
        for (int j = 100; j <= 999; j++) {
            //第一步让for能访问所有三位数
            int ge = j % 10;
            int shi = j / 10 % 10;
            int bai = j / 10 / 10;//一共就3位数才可以这么写！
            int sums = ge * ge * ge + shi * shi * shi + bai * bai * bai;
//第二部筛选出水仙花
            if (sums == j) {
                System.out.println("水仙花" + j);
                count++;
            }

//一直没有水仙花，是身体错了，立方看成平方！！！如果还要知道水仙花数的个数怎么办？
//在循环外定义一个变量count用于记录水仙花数。
//每输出水仙花数时，让count++。

        }
        System.out.println("水仙花一共有" + count + "个");

// 需求：世界最高山峰是珠穆朗玛峰(8848.86米=8848860毫米)，假如我有一张足够大的纸，它的厚度是0.1毫米。
// 请问，折叠多少次，可以折成珠穆朗玛峰的高度。
//思路：这种不清楚要循环多少次的情况可以选择用while实现。
        int qomo = 8848860;
        int counts = 0;
        double thick  = 0.1;
        while(thick<qomo){
            System.out.println("纸折叠"+counts+"次，厚度为"+thick+"毫米");
            thick *= 2;
            counts++;

        }
        System.out.println("纸折叠"+counts+"次，厚度为"+thick+"毫米"+"，此时折成珠峰");

    }
}