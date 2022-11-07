public class Account {

    private String name;
    private String nums;
    private double restmoney;
    private double catchlimit;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;

    public Account(String name, String nums, double restmoney, double catchlimit,String password) {
        this.name = name;
        this.nums = nums;
        this.restmoney = restmoney;
        this.catchlimit = catchlimit;
        this.password = password;
    }

    public Account() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNums() {
        return nums;
    }

    public void setNums(String nums) {
        this.nums = nums;
    }

    public double getRestmoney() {
        return restmoney;
    }

    public void setRestmoney(double restmoney) {
        this.restmoney = restmoney;
    }

    public double getCatchlimit() {
        return catchlimit;
    }

    public void setCatchlimit(double catchlimit) {
        this.catchlimit = catchlimit;
    }



}
