package gz.vin.nammu.core.service;

public abstract class StringDataFilter<E> implements IDataFilter<E> {
	private String property;
	private String value;

	public StringDataFilter() {

	}

	public StringDataFilter(String property, String value) {
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

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public abstract E getExpression();

}
