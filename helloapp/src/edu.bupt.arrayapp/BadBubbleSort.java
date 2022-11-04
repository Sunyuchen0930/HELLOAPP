import java.util.Scanner;

public class BadBubbleSort {
    public static void main(String[] args) {
        int nums [] = new int [5];
        Scanner input = new Scanner(System.in);
        System.out.println("请开始输入"+nums.length+"个integer值");
        for (int i = 0; i < nums.length; i++) {
            System.out.println("输入第"+(i+1)+"个数");
            nums[i] = input.nextInt();
        }
        System.out.println("元素值录入完毕");
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if(nums[i]<nums[j]){
                    int temp =nums[i];
                    nums[i] = nums [j];
                    nums[j] = temp;
                    System.out.println("第"+(i+1)+"大轮"+"第"+(j+1)+"小轮"+nums[i]+"和"+nums[j]+"交换了，现在是");
                    for (int k = 0; k < nums.length; k++) {
                        System.out.println(nums[k]);
                    }

                }
                else System.out.println("第"+(i+1)+"大轮"+"第"+(j+1)+"小轮"+nums[i]+"和"+nums[j]+"没有交换");

            }
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
