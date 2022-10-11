import java.util.Scanner;

public class IfandSwitch {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("只能输入int类型哦！输入你考了几分？");
        int s = input.nextInt();

        if (s>=90 && s<=94){
            System.out.println("游乐园");
        }
        else if (s<90 && s >= 80){
            System.out.println("toy");
        }
        else if (s>=95 && s<=100){//不能这样s>=95，万一有错误数据，加上范围！
            System.out.println("NB");
        }
//        不能这样s>=95，万一有错误数据，加上范围！
        else if (s>=0 && s<80)
            System.out.println("G");
        else System.out.println("你别乱输入啊！");
//        switch----------------------------
//        便利贴判断周一周二...然后告诉用户做什么？
        System.out.println("今天周几呀?");
        String num = input.next();
        System.out.println("你今天需要做的是：");
        switch(num){
//            case num = "周一":错了
//            每个case后面不要忘了break！！！！
            case "周一":
                System.out.println("打工");
                break;
            case "周二":
                System.out.println("相亲");
                break;
            case "周三":
                System.out.println("doi");
                break;
            case "周四":
                System.out.println("回家");
                break;
            case "周五":
                System.out.println("应付人");
                break;
            case "周六":
                System.out.println("摸鱼");
                break;
            case "周日":
                System.out.println("睡觉");
                break;
            default:
                System.out.println("你确定你输入的是周几吗？？？");
        }
    }
}
