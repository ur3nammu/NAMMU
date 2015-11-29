package gz.vin.nammu.core.service;

public abstract class BooleanDataFilter<E> implements IDataFilter<E> {
	private String property; 
	private Boolean value;
	
	public BooleanDataFilter() {
		
	}
	
	public BooleanDataFilter(String property, Boolean value) {
		super();
		this.property = property;
		this.value = value;
	}
	
	public String getProperty() {
		return property;
	}
	
	public void setProperty(String property) {
		this.property = property;
	}
	
	public Boolean getValue() {
		return value;
	}
	
	public void setValue(Boolean value) {
		this.value = value;
	}
	
	public abstract E getExpression();
	
}
