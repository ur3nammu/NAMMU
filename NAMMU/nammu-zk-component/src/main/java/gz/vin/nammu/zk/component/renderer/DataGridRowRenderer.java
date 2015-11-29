package gz.vin.nammu.zk.component.renderer;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.zkoss.zk.ui.Component;
import org.zkoss.zul.Cell;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import gz.vin.nammu.commons.util.bean.SetPropertyUtils;
import gz.vin.nammu.commons.util.converter.CoerceToStringConverter;
import gz.vin.nammu.zk.component.DataColumn;
import gz.vin.nammu.zk.component.IllegalPropertyNameException;

public class DataGridRowRenderer implements RowRenderer<Object>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CoerceToStringConverter converter;

	public void render(Row row, Object data, int index) throws Exception {

		final Grid grid = ((Grid) row.getParent().getParent());
		final List<Component> columns = grid.getColumns().getChildren();

		if (converter == null) {
			converter = new CoerceToStringConverter();
		}

		for (Component column : columns) {
			final Cell cell;
			final String value;
			final Label label;
			final String property = ((DataColumn) column).getProperty();

			if (StringUtils.isEmpty(property)) {
				throw new IllegalPropertyNameException(
						"La propiedad Property de DataColumn no puede ser nula o vacia.");
			}

			if (!SetPropertyUtils.isReadable(data, property)) {
				value = converter.coerce(null);
			} else {
				value = converter.coerce((SetPropertyUtils.getProperty(data, property)));
			}

			label = new Label(value);

			cell = new Cell();
			cell.appendChild(label);
			cell.setParent(row);
		}

	}

}
