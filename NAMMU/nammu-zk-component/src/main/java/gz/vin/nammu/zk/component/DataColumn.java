package gz.vin.nammu.zk.component;

import org.zkoss.zul.Column;

public class DataColumn extends Column {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 1L;
	
	private String property;
	
	private Boolean filterable;
	
	private Boolean sortable;
	
	private Boolean editable;
	
	private Boolean visible;

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public Boolean getFilterable() {
		return filterable;
	}

	public void setFilterable(Boolean filterable) {
		this.filterable = filterable;
	}

	public Boolean getSortable() {
		return sortable;
	}

	public void setSortable(Boolean sortable) {
		this.sortable = sortable;
	}

	public Boolean getVisible() {
		return visible;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

	public Boolean getEditable() {
		return editable;
	}

	public void setEditable(Boolean editable) {
		this.editable = editable;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
