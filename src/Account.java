import java.util.Date;

 class Account {
    private int id;
    private double balance;
    private static double annualInterestRate = 9;
    private Date dateCreated;

///////////////   Сеттеры          /////////////////////////////////////

    Account() {
        id = 0;
        balance = 0;
        dateCreated = new Date();

    }

    Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
        this.dateCreated = new Date();
    }
//////////////     Геттеры         /////////////////////////////////////

    public int getId() {

        return id;
    }

    public double getBalance() {

        return balance;
    }

    public Date getDateCreated() {

        return dateCreated;
    }

    public double getMonthlyInterest() {
        return getBalance() * ((annualInterestRate / 12) / 100);
    }

    ////////////     Методы изменения счёта      /////////////////////////////////
    public void setId(int id) {
        this.id = id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public static void setAnnualInterestRate(double annualInterestRate) {
        Account.annualInterestRate = annualInterestRate;
    }
    ////////////    Методы внесения / снятия сумм   //////////////////////////////

    public void withdraw(double amount) {
        this.balance = this.balance - amount;

    }
    public void deposit(double amount) {
        this.balance = this.balance + amount;

    }
     //метод печати информации об аккаунте

     public void printAccount1(){
         System.out.println("id              " + getId());
         System.out.println("Balance         " + getBalance());
         System.out.println("dateCreated     " + getDateCreated());
         System.out.println("MonthlyInterest   " + getMonthlyInterest());
     }

}