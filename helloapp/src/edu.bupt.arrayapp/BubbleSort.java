import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        int nums [] = new int [5];
        Scanner input = new Scanner(System.in);
        System.out.println("请开始输入"+nums.length+"个integer值");
        for (int i = 0; i < nums.length; i++) {
            System.out.println("输入第"+(i+1)+"个数");
            nums[i] = input.nextInt();
        }
        System.out.println("元素值录入完毕");
        //定义要比较的趟数,一趟就是从头到尾走一遭！
        for (int i = 0; i < nums.length; i++) {
            //定义每一趟要比较的次数和占位
            //i从0到4共4趟
            //为什么j小于长度-i：每一趟，都会确定一个最大值沉底
            //所以每次一趟过后，就可以少比较一轮
            //i==0 第1趟比较的次数是length-1=4次，j-1 = 0 1 2 3，j=1,2,3,4
            //i==1 第2趟比较次数是3次 j-1 = 0 1 2，因为下标4已经固定了,如果前一个大于后一个就交换，固定了最大的
            //i==2 第3趟比较次数是2次 j-1 = 0 1 ，因为下标3,4已经固定了，下次只需要排序0,1,2下标比较
            //i==3 第4趟比较次数是1次 j-1 = 0 ，因为下标2,3,4已经固定了
            for (int j = 1; j < nums.length-i; j++) {
                //j-1 = 0，j=1，长度-i = 5-0 =5，j小于5，j-1=0,1,2,3，j=1,2,3,4
                if (nums[j-1] > nums[j]) {
                    int temp = nums[j-1];
                    nums[j-1] = nums[j];
                    nums[j] = temp;
                    System.out.println("\n第" +(i+1)+ "趟" + "第" +  (j) + "次交换，" + "nums["+(j-1)+"]"+nums[j-1] + "和" +"nums["+(j)+"]"+ nums[j] + "交换了，现在是");
                    for (int k = 0; k < nums.length; k++) {
                        System.out.print(nums[k]);
                    }
                } else
                    System.out.println("\n第" + (i+1) + "趟" + "第" +  (j) + "次交换，" + "nums["+(j-1)+"]"+nums[j-1] + "和" + "nums["+(j)+"]"+nums[j] + "没有交换");
            }
            }
 }
}
