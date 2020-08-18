package ca.roumani.stocktrader;

        import java.text.DateFormat;
        import java.text.DecimalFormat;
        import java.text.ParseException;
        import java.text.SimpleDateFormat;
        import java.util.ArrayList;
        import java.util.Date;
        import java.util.List;

        import jba.roumani.lib.Stock;

/**
 * Created by user on 3/16/17.
 */
class StockModel
{

    public Equity constructObjects(String itemValues) throws ParseException
    {
        String dataValue[] = itemValues.split(",");
        String symbol = dataValue[0];
        int qty = Integer.parseInt(dataValue[1]);
        double bookValue = Double.parseDouble(dataValue[2]);
        java.util.Date acquiredDate = new SimpleDateFormat("dd/MM/yyyy").parse(dataValue[3]);

        //Get market value
        Stock stock = new Stock(symbol);
        double marketValue = stock.getPrice();
        //Get yield Value
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date dateobj = new Date();
        java.util.Date currentDate = new SimpleDateFormat("dd/MM/yyyy").parse(df.format(dateobj));
        double days = (double) ((currentDate.getTime() - acquiredDate.getTime()) / (1000 * 60 * 60 * 24));
        DecimalFormat df2 = new DecimalFormat("###.#");
        double val = (((marketValue - bookValue) / bookValue) * (365 / days) * 100);
        double yield = Double.valueOf(df2.format(val));

        Equity equity = new Equity(symbol, qty, bookValue, acquiredDate, marketValue, yield);
        return equity;

    }

    public java.lang.String[] getPrtfolio(String input) throws ParseException
    {
        StockModel model1 = new StockModel();
        List<Equity> equityObj1 = new ArrayList<Equity>();
        equityObj1.add(model1.constructObjects(input));

        String[] result = {"", "", "", "", "", "", ""};
        Equity equity = equityObj1.get(0);
        String s = equity.getSymbol();
        int q = equity.getQty();
        double b = equity.getBookValue();
        Date a = equity.getAcquired();
        DateFormat df= new SimpleDateFormat("dd/MM/yyyy");
        String acq = df.format(a);
        double m = equity.getMarketValue();
        double y = equity.getYield();
        result[0] = s;
        result[1] = Integer.toString(q);
        result[2] = Double.toString(b);
        result[3] = acq;
        result[4] = Double.toString(m);
        result[5] = Double.toString(y);
        return result;
    }
}

    class Equity
    {
        private int qty;
        private double bookvalue, marketvalue, yield;
        private String symbol;
        private Date acquired;

        public Equity(java.lang.String symbol,
                      int qty,
                      double bookValue,
                      java.util.Date acquired,
                      double marketValue,
                      double yield)
        {
            this.symbol = symbol;
            this.qty = qty;
            this.bookvalue = bookValue;
            this.acquired = acquired;
            this.marketvalue = marketValue;
            this.yield = yield;

        }

        public java.util.Date getAcquired()
        {
            return acquired;
        }

        public double getBookValue()
        {
            return bookvalue;
        }

        public double getMarketValue()
        {
            return marketvalue;
        }

        public int getQty()
        {
            return qty;
        }

        public java.lang.String getSymbol()
        {
            return symbol;
        }

        public double getYield()
        {
            return yield;
        }

        public java.lang.String toString()
        {
            String result = "The " + this.symbol + " portfolio consists of " + 5 + "." + "\n" + "It has a market value of " + this.marketvalue + " and a yield of " + this.yield + " (annualized).";
            return result;
        }
    }


    class PortfolioAnalyzer
    {
        private String title;
        private String[] row;
        List<Equity> equityObj = new ArrayList<Equity>();


        public PortfolioAnalyzer(java.lang.String title,
                                 java.lang.String[] rows)
        {
            this.title = title;
            this.row = rows;
        }

        public double getInvestmentMarketValue(java.lang.String symbol)
        {
            double price;
            Stock sc = new Stock(symbol);
            price = sc.getPrice();
            return price;
        }

        public double getInvestmentYield(double bookValue, double marketValue, java.util.Date acquired) throws ParseException
        {
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            Date dateobj = new Date();
            java.util.Date currentDate = new SimpleDateFormat("dd/MM/yyyy").parse(df.format(dateobj));
            double days = (double) ((currentDate.getTime() - acquired.getTime()) / (1000 * 60 * 60 * 24));
            double yield = Math.round(((marketValue - bookValue) / bookValue) * (365 / days) * 100);
            return yield;
        }

        public java.util.List<Equity> getPortfolio() throws ParseException
        {
            StockModel model = new StockModel();
            // List<Equity> equityObj = new ArrayList<Equity>();
            for (int count = 0; count < row.length; count++)
            {
                this.equityObj.add(model.constructObjects(row[count]));
            }
            return equityObj;
        }

        public double getPortfolioMarketValue() throws ParseException
        {
            getPortfolio();
            double portfolioMarketValue = 0.0;

                for (int count = 0; count < equityObj.size(); count++)
                {
                    Equity equity = equityObj.get(count);
                    portfolioMarketValue = portfolioMarketValue+((getInvestmentMarketValue(equity.getSymbol())) * (equity.getQty()));
                }

            return portfolioMarketValue/2.00;
        }

        public int getPortfolioSize() throws ParseException
        {
            getPortfolio();
            return equityObj.size();
        }

        public double getPortfolioYield() throws ParseException {
            getPortfolio();
            double portfolioYieldNumr = 0.0;
            double portfolioYieldDenomr = 0.0;
            double portfolioYield=0.0;
            if (equityObj != null) {
                for (int count = 0; count < equityObj.size(); count++) {
                    Equity equity = equityObj.get(count);
                    int qty = equity.getQty();
                    double bookvalue = equity.getBookValue();
                    double yield = equity.getYield();
                    portfolioYieldNumr+=(qty*bookvalue*yield);
                    portfolioYieldDenomr+=(qty*bookvalue);
                }

            }
            portfolioYield = portfolioYieldNumr/ portfolioYieldDenomr;

            return portfolioYield;

        }

        public java.lang.String toString()
        {

            return equityObj.toString();
        }
        
        public static void main(String[] args) throws ParseException
        {
            String item[] = new String[2];
            item[0] = ".QC,78,7.50,20/2/2003";
            item[1] = ".UR,2679,37.33,14/9/2004";
            PortfolioAnalyzer pa = new PortfolioAnalyzer("raj", item);
           System.out.println(pa.getInvestmentMarketValue(".qc"));
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            Date dateobj = new Date();
            java.util.Date currentDate = new SimpleDateFormat("dd/MM/yyyy").parse(df.format(dateobj));
            System.out.println(pa.getInvestmentYield(78.7, 14.67, currentDate));
            System.out.println(pa.getPortfolioMarketValue());
            System.out.println(pa.getPortfolioYield());

        }

    }


