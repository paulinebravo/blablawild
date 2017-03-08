package fr.wcs.blablawild;


import java.util.Date;

public class TripResultModel {
    public String mFirstname;
    public Date mDate;
    public int mPrice;

    public TripResultModel (String mFirstname, Date mDate, int mPrice) {
        this.mFirstname = mFirstname;
        this.mDate = mDate;
        this.mPrice= mPrice;
    }

    public String getmFirstname() {
        return this.mFirstname;
    }

    public Date getmDate() {
        return this.mDate;
    }

    public int getmPrice() {
        return this.mPrice;
}

    public void setmFirstname(String mFirstname) {
        this.mFirstname = mFirstname;
    }

    public void setmDate(Date mDate) {
        this.mDate = mDate;
    }

    public void setmPrice(int mPrice) {
        this.mPrice = mPrice;
    }
}

