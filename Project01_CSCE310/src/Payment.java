public class Payment {
    private int payID;
    private String cardNumber;
    private String cardHolder;
    private String expirationDate;
    private String CVVNumber;
    private double paymentAmount;

    public void setPayID(int payID)
    {
        this.payID = payID;
    }

    public int getPayID()
    {
        return payID;
    }

    public void setCardNumber(String cardNumber)
    {
        this.cardNumber = cardNumber;
    }
    public String getCardNumber()
    {
        return cardNumber;
    }

    public void setCardHolder(String cardHolder)
    {
        this.cardHolder = cardHolder;
    }

    public String getCardHolder()
    {
        return cardHolder;
    }

    public void setExpirationDate(String expirationDate)
    {
        this.expirationDate = expirationDate;
    }

    public String getExpirationDate()
    {
        return expirationDate;
    }

    public void setCVVNumber(String CVVNumber)
    {
        this.CVVNumber = CVVNumber;
    }

    public String getCVVNumber()
    {
        return CVVNumber;
    }

    public void setPaymentAmount(double paymentAmount)
    {
        this.paymentAmount = paymentAmount;
    }

    public double getPaymentAmount()
    {
        return paymentAmount;
    }

    public String toString()
    {
        return "Payment Information -> payID: " + payID + ", Credit Card Number: " + cardNumber +
                ", Credit Card Holder: " +  cardHolder + ", Credit Card Expiration Date: " + expirationDate
                + ", Credit Card CVV: " + CVVNumber + ", Payment Amount = " + paymentAmount;
    }
}
