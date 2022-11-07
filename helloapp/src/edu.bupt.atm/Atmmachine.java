import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Atmmachine {
    public static void main(String[] args) {
        ArrayList <Account> accounts = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        //首页：登录和注册
        //先输入用户名密码，判断是否登录
        while (true){

            System.out.println("----------------欢迎你进入ATM------------------------");
            if (accounts.size()!=0) {
                for (int i = 0; i < accounts.size(); i++) {
                    if(accounts.get(i)!=null){
                        System.out.println("现在已经有用户"+accounts.get(i).getName());
                    }
                }
            }
            else System.out.println("现在还没有用户，你需要先注册！");
            System.out.println("输入1，即可登录");
            System.out.println("输入2，即可注册");
            //这一步必须输入int
            int opt = input.nextInt();

            switch(opt){
                case 1 :
                    login(input,accounts);
                    break;
                case 2 :
                    if (register(input,accounts)){
                        System.out.println("注册成功");
                    }
                    break;
                default :
                    System.out.println("请重新输入选项");
                    break;
            }
        }
    }


    public static boolean register(Scanner input,ArrayList<Account> accounts){

        while (true) {
            System.out.println("请注册：请输入你的用户名");
            String name = input.next();
            if(accounts.size()==0){
                return createAccount(accounts,input,name);
            }
            else if(IfRepeatName(accounts,name)==false){
                //false代表没重复，true代表重复注册
                createAccount(accounts,input,name);
                return true;
            }
            else {
                System.out.println("请重新输入用户名");
            }
        }
    }

    public static boolean login(Scanner input,ArrayList<Account> accounts){
        boolean flag = true;
        int count = 3;
        System.out.println("请登录：请输入你的用户名");
        String name = input.next();
        System.out.println("你的用户名是"+name);
        OFF:
        if (accounts.size()!=0) {
            for (int i=0 ; i<accounts.size();i++) {
                if(accounts.get(i).getName().equals(name)){
                    while (count>0) {
                        System.out.println("请输入你的密码");
                        String pass = input.next();

                        if(accounts.get(i).getPassword().equals(pass)){
                            System.out.println("登录成功");
                            flag = true;
                            break OFF;
                        }
                        else {
                            System.out.println("密码错误，您还有"+(count-1)+"次机会");
                            flag = false;
                            System.out.println(flag);
                        }
                        count --;
                    }
                    System.out.println("登录失败，请稍后再来");
                    flag =  false;
                    break OFF;
                }
            }

            System.out.println("你还没有注册，请你先注册");
            flag = register(input,accounts);

        }
        else {
            System.out.println("现在没有人注册过，你需要先注册");
            flag = register(input,accounts);
        }
        return flag;
    }

    public static String RandomCardid(ArrayList<Account> accounts){
        Random rands = new Random();
        String datas = "0123456789";
        String cardid = "";
        //卡号长度20位
        while (true) {
            for (int i = 0; i < 20; i++) {
                int one = rands.nextInt(10);
                cardid += datas.charAt(one);
                System.out.println("卡号已经生成进度"+(i+1)*5+"%");
            }

            if(accounts.size()==0){
                return cardid;
            }

            for (int i = 0; i < accounts.size(); i++) {
                if (cardid.equals(accounts.get(i).getNums())==true){
                    System.out.println("重复卡号，重新生成卡号");
                }
                else{
                    return cardid;
                }
            }
        }

    }
    public static boolean IfRepeatName(ArrayList<Account> accounts,String name) {
        for (int i = 0; i < accounts.size(); i++) {
            if (name.equals(accounts.get(i).getName())) {
                System.out.println("该用户名的账户已经注册");
                return true;
            }
        }
        System.out.println("您的用户名是"+name);
        return false;
    }
    public static boolean createAccount(ArrayList<Account> accounts,Scanner input,String name){
        Account a1 = new Account();

        a1.setName(name);
        boolean iflogin = false;
        System.out.println("请输入你的密码");
        String pass = input.next();

        a1.setPassword(pass);
        System.out.println("请确认一次密码");
        String pass1 = input.next();
        if(pass1.equals(a1.getPassword())){
            System.out.println("正在生成你的卡号");
            a1.setNums(RandomCardid(accounts));
            a1.setCatchlimit(0);
            a1.setRestmoney(0);
            accounts.add(a1);

            System.out.println("注册成功!!您的卡号是"+a1.getNums()+",用户名是"+a1.getName()+",请登录");
            System.out.println("现在有多少个用户："+accounts.size());
            iflogin = login(input,accounts);
        }
        return iflogin;
    }
}
