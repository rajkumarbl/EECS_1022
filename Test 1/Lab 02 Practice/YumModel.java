package ca.roumani.mcalc;
public class YumModel {
    private double principle = 0.0D;
    private int amortization = 0;
    private double interest = 0.0D;
    private final int MONTH_PER_YEAR = 12;

    public YumModel() {
    }

    public void setPrinciple(String var1) {
        this.principle = Double.parseDouble(var1);
    }

    public void setAmortization(String var1) {
        this.amortization = Integer.parseInt(var1);
    }

    public void setInterest(String var1) {
        this.interest = Double.parseDouble(var1);
    }

    public String computePayment() {
        return String.format("$%,.2f", new Object[]{Double.valueOf(this.monthlyPayment())});
    }

    public String getFormattedPayment(int var1, boolean var2, String var3) {
        String var4 = var3 + "%";
        if(var2) {
            var4 = var4 + ",";
        }

        var4 = var4 + "." + var1 + "f";
        return String.format(var4, new Object[]{Double.valueOf(this.monthlyPayment())});
    }

    private double monthlyPayment() {
        double var1 = this.principle;
        int var3 = this.amortization * 12;
        double var4 = this.interest / 100.0D / 12.0D;
        double var6 = var4 * var1;
        double var8 = 1.0D - Math.pow(1.0D + var4, (double)(-var3));
        return var6 / var8;
    }

    public static void main(String[] var0) {
        YumModel var1 = new YumModel();
        var1.setPrinciple("700000");
        var1.setAmortization("25");
        var1.setInterest("2.75");
        System.out.println(var1.getFormattedPayment(4, false, "PP"));
    }
}
