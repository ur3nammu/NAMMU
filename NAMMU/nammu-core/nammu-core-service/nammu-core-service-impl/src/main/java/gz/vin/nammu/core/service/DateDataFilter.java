package gz.vin.nammu.core.service;

import java.util.Date;

public abstract class DateDataFilter<E> implements IDataFilter<E> {

	private String property;
	private Date minValue;
	private Date maxValue;
	
	public DateDataFilter() {
		
	}
	
	public DateDataFilter(String property, Date minValue, Date maxValue) {
		super();
		this.property = property;
		this.minValue = minValue;
		this.maxValue = maxValue;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public Date getminValue() {
		return minValue;
	}

	public void setminValue(Date minValue) {
		this.minValue = minValue;
	}

	public Date getmaxValue() {
		return maxValue;
	}

	public void setmaxValue(Date maxValue) {
		this.maxValue = maxValue;
	}

	public abstract E getExpression();
	
}
