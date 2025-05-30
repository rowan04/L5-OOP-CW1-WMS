public class Finances {
    public double balance;
    public int report_num;
    public Report report;

    public Finances(
            double balance
    ) {
        this.balance = balance;
        this.report_num = 0;
    }

    public double getBalance() {
        return balance;
    }

    public int getReportNum() {
        return report_num;
    }

    public Report getReport() {
        return report;
    }

    public void setReport_num(int report_num) {
        this.report_num = report_num;
    }

    public void setReport(Report report) {
        this.report = report;
    }

    public void updateBalance(double balanceChange) {
        this.balance = this.balance + balanceChange;
        System.out.println("Balance is now: " + this.balance);
    }
}
