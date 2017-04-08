package exercise2_3;

public class Date {
	private int day, month, year;
	public static final String[] MONTHNAMES = {"January", "February",
		"March", "April", "May", "June", "July", "August",
		"September", "October", "November", "December"};
	
	public Date() {
		java.time.LocalDate today = java.time.LocalDate.now();
		day = today.getDayOfMonth();
		month = today.getMonthValue();
		year = today.getYear();
	}
	
	public Date(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public Date(String date) {
		int dd, mm, yyyy;
		// String[] parts = date.split("\\.");
		dd = Integer.parseInt(date.substring(0,2));
		this.day = dd;
		mm = Integer.parseInt(date.substring(3,5));
		this.month = mm;
		yyyy = Integer.parseInt(date.substring(6,10));
		this.year = yyyy;
	}
	
	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	public String toString() {
		return (day + "." + month + "." + year);
	}
	
	public String date() {
		return ("the " + day + "th of " + MONTHNAMES[month-1] + ", " + year);
	}
	
	public static int month(String month) {
		int i,j=0;
		for (i = 0; i < MONTHNAMES.length; i++) {
			// month.equalsIgnoreCase(MONTHNAMES[i])
			if (month.toLowerCase().equals(MONTHNAMES[i].toLowerCase())) {
				j = i;
				break;
			}
		}
		return j + 1;
	}
	public boolean equals(Date another) {
		if (day == another.day && month == another.month && year == another.year) {
            return true;
        }
		else {
			return false;
		}
	}
}
