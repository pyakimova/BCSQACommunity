package agolova;

public class Portfolio {
    private String proposalName;
    private float sumOfInvestment;
    private String currency;
    private String riskProfile;
    private int termOfInvestment;
    private double excpectedReturn;
    private double var;


    public Portfolio(String proposalName, float sumOfInvestment, String currency, String riskProfile, int termOfInvestment, double excpectedReturn, double var){
        this.proposalName = proposalName;
        this.sumOfInvestment = sumOfInvestment;
        this.currency = currency;
        this.riskProfile = riskProfile;
        this.termOfInvestment = termOfInvestment;
        this.excpectedReturn = excpectedReturn;
        this.var = var;

    }



}
