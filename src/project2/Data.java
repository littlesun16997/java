package project2;

import java.io.Serializable;

public class Data implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private double value;
    private String month, year;

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return month + "/" + year + "," + value;
    }
}
