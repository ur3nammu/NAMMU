package gz.vin.nammu.core.service;

public abstract class IntegerDataFilter<E> implements IDataFilter<E> {

	private String property;
	private Integer minValue;
	private Integer maxValue;
	
	public IntegerDataFilter() {
		
	}
	
	public IntegerDataFilter(String property, Integer minValue, Integer maxValue) {
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

	public Integer getminValue() {
		return minValue;
	}

	public void setminValue(Integer minValue) {
		this.minValue = minValue;
	}

	public Integer getmaxValue() {
		return maxValue;
	}

	public void setmaxValue(Integer maxValue) {
		this.maxValue = maxValue;
	}

	public abstract E getExpression();
	
}
