import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


//错误1：卡号登录，而不是用户名登录
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
                        System.out.println("现在已经有用户"+accounts.get(i).getNums()+","+
                                accounts.get(i).getName().charAt(0)+(accounts.get(i).getSex()==1?"先生":"女士"));
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
                    int index2 = login(input,accounts);
                    Option(index2,accounts,input);
                    break;
                case 2 :
                    if (register(input,accounts)){
                        int index3 = login(input,accounts);
                        Option(index3,accounts,input);
                    }
                    break;
                default :
                    System.out.println("请重新输入选项");
                    break;
            }
        }
    }

    /**
     * 注册
     * @param input 输入对象
     * @param accounts 账户集合
     * @return
     */
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
                System.out.println("用户名重复，请重新输入用户名");
            }
        }
    }

    /**
     * 登录
     * @param input 输入对象
     * @param accounts 账户集合
     * @return 返回用户名在账户集合的索引
     */
    public static int login(Scanner input,ArrayList<Account> accounts){
        int count = 3;
        int index = -1;
        System.out.println("请登录：请输入你的卡号");
        String nums = input.next();

        OFF:
        if (accounts.size()!=0) {
            for (int i=0 ; i<accounts.size();i++) {
                if(accounts.get(i).getNums().equals(nums)){
                    while (count>0) {
                        System.out.println("请输入你的密码");
                        String pass = input.next();

                        if(accounts.get(i).getPassword().equals(pass)){
                            System.out.println("登录成功，欢迎你"+accounts.get(i).getName());
                            index = i;
                            break OFF;
                        }
                        else {
                            System.out.println("密码错误，您还有"+(count-1)+"次机会");
                        }
                        count --;
                    }
                    System.out.println("登录失败，请稍后再来");
                    break OFF;
                }
            }

            System.out.println("你还没有注册，请你先注册");
            register(input,accounts);
            index = login(input,accounts);

        }
        else {
            System.out.println("现在没有人注册过，你需要先注册");
            if(register(input,accounts)){
                index = login(input,accounts);
            }
        }
        return index;
    }

    /**
     * 自动生成20位卡号
     * @param accounts 账户集合
     * @return 生成卡号
     */
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

    /**
     * 判断是否重名用户
     * @param accounts  账户集合
     * @param name 用户名
     * @return 是否重名
     */
    public static boolean IfRepeatName(ArrayList<Account> accounts,String name) {
        for (int i = 0; i < accounts.size(); i++) {
            if (name.equals(accounts.get(i).getName())) {
                System.out.println("该用户名的账户已经注册");
                return true;
            }
        }
        return false;
    }

    /**
     * 建立账户（逻辑有些问题，应该在注册里面，但是有重复两次，不知道怎么改）
     * @param accounts 账户集合
     * @param input 输入对象
     * @param name 用户名
     * @return 是否建立成功
     */
    public static boolean createAccount(ArrayList<Account> accounts,Scanner input,String name){
        Account a1 = new Account();
        boolean passed = false;
        a1.setName(name);
        int count = 3;
        while (count>0) {
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
                System.out.println("请选择您的性别");
                System.out.println("输入1为女");
                System.out.println("输入2为男");
                int opt = input.nextInt();
                switch (opt){
                    case 1:
                        a1.setSex(0);
                        break;
                    case 2:
                        a1.setSex(1);
                        break;
                    default:
                        System.out.println("重新输入正确性别");
                        break;
                }
                accounts.add(a1);
                System.out.println("恭喜您，"+a1.getName().charAt(0)+(a1.getSex()==1 ?"先生":"女士")+"，注册成功，您的卡号是"+a1.getNums()+"，请登录");
                System.out.println("现在有多少个用户："+accounts.size());
                passed = true;
                break;
            }

            else {
                System.out.println("确认密码失败，你还有"+(count-1)+"次机会，请重新输入密码");
                passed = false;
                count--;
            }

        }
        if(count==0){
            System.out.println("您机会用完，请稍后再来");
        }
        return passed;

    }

    /**
     * 直接展示当前登录成功的账户对象的信息
     * @param accounts 账户集合
     * @param index 当前登录的用户账户
     */
    public static void GetAccounts(ArrayList<Account> accounts,int index){
        Account a = accounts.get(index);
        System.out.println("您的用户名是："+a.getName());
        System.out.println("您的卡号是：\t"+a.getNums());
        System.out.println("您的余额是：\t"+a.getRestmoney());
        System.out.println("您的取款限度是："+a.getCatchlimit());
    }

    /**
     * 内部操作页面
     * @param accounts 账户集合
     * @param input 输入
     * @param index 当前登录的用户账户
     */
    public static void Option(int index,ArrayList<Account> accounts,Scanner input){
        OFF:
        while (true) {
            if (index != -1) {
                System.out.println("----------------欢迎进入ATM内部操作页面-----------------------");
                System.out.println("----------------1.查询账户----------------------------------");
                System.out.println("----------------2.存款-------------------------------------");
                System.out.println("----------------3.取款-------------------------------------");
                System.out.println("----------------4.转账-------------------------------------");
                System.out.println("----------------5.修改密码----------------------------------");
                System.out.println("----------------6.退出-------------------------------------");
                System.out.println("----------------7.注销当前账户------------------------------");
                System.out.println("----------------请您输入数字，选择操作------------------------");
                int opt = input.nextInt();

                switch (opt) {
                    case 1:
                        GetAccounts(accounts, index);
                        break;
                    case 2:
                        Storemoney(accounts,input,index);
                        break;
                    case 3:
                        Catchmoney(accounts,input,index);
                        break;
                    case 4:
                        Transmoney(accounts,input,index);
                        break;
                    case 5:
                        Changepass(accounts,input,index);
                        break OFF;
                    case 6:
                        break OFF;
                    case 7:
                        RemoveA(accounts,input,index);
                        break OFF;
                    default:
                        System.out.println("请重新输入正确的选项");
                        break;
                }
            }
        }
    }
    /**
     * 存款
     * @param accounts 账户集合
     * @param input 输入
     * @param index 当前登录的用户账户
     */
    public static void Storemoney(ArrayList<Account> accounts,Scanner input,int index){
        Account a = accounts.get(index);
        System.out.println("您好"+a.getName()+",您现在有存款"+a.getRestmoney()+"元");
        System.out.println("请输入您现在想存款的金额");
        double money = input.nextDouble();
        System.out.println("您想存款"+money+"元,原有余额"+a.getRestmoney()+"元，存款后共计"+(money+a.getRestmoney())+"元");
        System.out.println("输入1确认存款");
        System.out.println("输入2取消存款");
        int opts = input.nextInt();
        switch (opts){
            case 1:
                a.setRestmoney(a.getRestmoney()+money);
                System.out.println("存款成功，您现在有"+a.getRestmoney()+"元");
                break;
            case 2:
                System.out.println("取消成功，您现在有"+a.getRestmoney()+"元");
                break;
            default:
                System.out.println("输入正确选项，谢谢");
                break;
        }
    }
    /**
     * 取款
     * @param accounts 账户集合
     * @param input 输入
     * @param index 当前登录的用户账户
     */
    public static void Catchmoney(ArrayList<Account> accounts,Scanner input,int index){

        Account a = accounts.get(index);
        System.out.println("您好"+a.getName()+",您现在有存款"+a.getRestmoney()+"元");
        if(a.getRestmoney()==0){
            System.out.println("您现在一分钱也没有存哦，不可以取款，先存款哦");
        }
        else {
            OFF:
            while (true) {
                System.out.println("请输入您现在想取款的金额");
                double catchmoney = input.nextDouble();
                System.out.println("您想取款"+catchmoney+"元,原有余额"+a.getRestmoney()+"元");

                if(a.getRestmoney()>=catchmoney){
                    System.out.println("您有足够的余额");
                    if(catchmoney<=a.getCatchlimit()){
                        System.out.println("您没有超出限额，恭喜你可以取款！");
                        System.out.println("输入1确认取款");
                        System.out.println("输入2取消取款");
                        int opt3 = input.nextInt();
                        switch (opt3){
                            case 1:
                                a.setRestmoney(a.getRestmoney()-catchmoney);
                                System.out.println("取款成功，您现在有"+a.getRestmoney()+"元");
                                break OFF;
                            case 2:
                                System.out.println("取消成功，您现在有"+a.getRestmoney()+"元");
                                break OFF;
                        }
                    }

                    else {
                        System.out.println("您的取款超出限额，请重新输出取款金额");
                    }
                }

                else {
                    System.out.println("您的余额不足，请重新输入取款金额");
                }
            }
        }
    }

 /*   转账功能需要判断系统中是否有2个账户对象及以上。
    同时还要判断自己账户是否有钱。
    接下来需要输入对方卡号，判断对方账户是否存在。
    对方账户存在还需要认证对方户主的姓氏。
    满足要求则可以把自己账户对象的金额修改到对方账户对象中去。*/
    /**
     * 转账
     * @param accounts 账户集合
     * @param input 输入
     * @param index 当前登录的用户账户
     */
    public static void Transmoney(ArrayList<Account> accounts,Scanner input,int index){
        int people2 = -1;
        Account a1 = accounts.get(index);
        double money = 0;
        int count = 3;
        if (accounts.size()>=2) {
            OFF1:
            while (count>0) {
                System.out.println("请输入您想转账的卡号");
                String cardin = input.next();
                boolean ifid = false;
                for (int i = 0; i < accounts.size(); i++) {
                    if (accounts.get(i).getNums().equals(cardin)) {
                        ifid = true;
                        people2 = i;
                        if (people2 != index) {
                            Account a2 = accounts.get(people2);
                            System.out.println("您想转账的用户姓氏是:");
                            String xing = input.next();
                            if(accounts.get(people2).getName().substring(0,1).equals(xing)){
                                xing = a2.getName().substring(0,1);
                                System.out.println("确认身份成功，您将转账给"+xing+(a2.getSex()==1?"先生":"女士"));
                                break OFF1;
                            }
                            else {

                                System.out.println("确认身份失败，请您重新确认转账对象，您还有"+(count-1)+"次机会");
                                count--;
                            }
                        }
                        else {
                            System.out.println("不可以给自己转账，请您重新输入卡号，您还有"+(count-1)+"次机会");
                            count--;
                        }
                    }
                }
                if(ifid==false){
                    System.out.println("查无此人，您还有"+(count-1)+"次机会");
                    count--;
                }
            }
            if(count<=0){
                System.out.println("三次机会用完，稍后再来");
                return;
            }
            Account a2 = accounts.get(people2);
            if (a1.getRestmoney() == 0) System.out.println("您的余额为0，无法转账，请先存款");
            else {
                OFF:
                while (true) {
                    System.out.println("请输入您想转账的金额");
                    money = input.nextDouble();

                    if (money <= accounts.get(index).getRestmoney()) {
                        if (money <= accounts.get(index).getCatchlimit()) {
                            System.out.println("您想给用户" + a2.getName() + "转账" + money + "元,您原有余额" + a1.getRestmoney() + "元");
                            System.out.println("输入1确认转账");
                            System.out.println("输入2取消转账");
                            int opt3 = input.nextInt();
                            switch (opt3) {
                                case 1:
                                    a1.setRestmoney(a1.getRestmoney() - money);
                                    a2.setRestmoney(a2.getRestmoney() + money);
                                    System.out.println("转账成功，您现在有" + a1.getRestmoney() + "元");
                                    break OFF;
                                case 2:
                                    System.out.println("取消成功，您现在有" + a1.getRestmoney() + "元");
                                    break OFF;
                            }
                        } else System.out.println("您转账超出限额，请重新输入金额");
                    } else {
                        System.out.println("您的余额不足");
                    }
                }
            }
        }
        else System.out.println("还不存在其他用户哦");
    }
    /**
     * 修改密码
     * @param accounts 账户集合
     * @param input 输入
     * @param index 当前登录的用户账户
     */
    public static void Changepass(ArrayList<Account> accounts,Scanner input,int index){
        Account a = accounts.get(index);
        int count1 = 3;
        int count2 = 3;
        OFF2:
        while (count1>0) {
            System.out.println("请输入原密码");
            String pass = input.next();
            if(a.getPassword().equals(pass)){
                System.out.println("原密码正确");
                while (count2>0) {
                    System.out.println("请输入新密码");
                    String newpass = input.next();
                    System.out.println("再输一次，确认新密码");
                    String new2 = input.next();
                    if(newpass.equals(new2)&&new2.equals(a.getPassword())){
                        count2--;
                        System.out.println("新旧密码不能相同,请重新输入新密码,您还有"+(count2)+"次机会");
                    }
                    else {
                        if(newpass.equals(new2)){
                            a.setPassword(new2);
                            System.out.println("密码修改成功，请您重新登录");
                            break OFF2;
                        }
                        else {
                            count2--;
                            System.out.println("确认密码不匹配，请重新输入新密码,您还有"+(count2)+"次机会");
                        }
                    }
                }
                if(count2<=0){
                    System.out.println("三次机会用完，请稍后再来");
                    return;
                }
            }
            else {
                count1--;
                System.out.println("原有密码错误，请重新输入原密码,您还有"+(count1)+"次机会");
            }
        }
    }

    /**
     * 销毁账户
     * @param accounts 账户集合
     * @param input 输入
     * @param index 当前登录的用户账户
     */
    public static void RemoveA(ArrayList<Account> accounts,Scanner input,int index){
        Account a = accounts.get(index);
        System.out.println("您确定要销毁账户？");
        System.out.println("您还有余额"+a.getRestmoney()+"元");
        System.out.println("输入1确认销毁账户");
        System.out.println("输入2取消销毁账户");
        int opt = input.nextInt();
        switch (opt) {
            case 1:
                accounts.remove(a);
                System.out.println("销毁账户成功");
                break;
            case 2:
                System.out.println("取消销毁，您的账户仍存在使用");
                break;
        }

    }

}



