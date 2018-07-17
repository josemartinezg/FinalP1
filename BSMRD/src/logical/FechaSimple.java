package logical;

import java.util.Calendar;

public class FechaSimple {
	private int day;
	private int month;
	private int year;
	private static FechaSimple fecha = null;
	
	public FechaSimple(int day, int month, int year)  {
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	private FechaSimple() {
		Calendar fecha = Calendar.getInstance();
		this.day = fecha.get(Calendar.DAY_OF_MONTH);
		this.month = fecha.get(Calendar.MONTH)+1;
		this.year = fecha.get(Calendar.YEAR);
	}

	public int getDay() {
		return day;
	}

	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public void setYear(int year) {
		this.year = year;
	}
	public static FechaSimple getInstance() {
		if(fecha == null) {
			fecha = new FechaSimple();
		}
		return fecha;
	}
	public boolean isEqual(FechaSimple fechaParam) {
		return (
				this.getDay() == fechaParam.getDay() &&
				this.getMonth() == fechaParam.getMonth() &&
				this.getYear() == fechaParam.getYear()
		);
	}
}
