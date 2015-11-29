package gz.vin.nammu.core.service;

import java.math.BigDecimal;

public abstract class BigDecimalDataFilter<E> implements IDataFilter<E> {

	private String property;
	private BigDecimal minValue;
	private BigDecimal maxValue;
	
	public BigDecimalDataFilter() {
		
	}
	
	public BigDecimalDataFilter(String property, BigDecimal minValue, BigDecimal maxValue) {
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

	public BigDecimal getminValue() {
		return minValue;
	}

	public void setminValue(BigDecimal minValue) {
		this.minValue = minValue;
	}

	public BigDecimal getmaxValue() {
		return maxValue;
	}

	public void setmaxValue(BigDecimal maxValue) {
		this.maxValue = maxValue;
	}

	public abstract E getExpression();
	
}
