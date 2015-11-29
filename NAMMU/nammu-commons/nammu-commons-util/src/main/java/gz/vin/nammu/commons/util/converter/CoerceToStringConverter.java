package gz.vin.nammu.commons.util.converter;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CoerceToStringConverter {

	private static final String EMPTY_STRING = "";
	public static final String DEFAULT_DATE_PATTERN = "dd-mm-yyyy";
	public static final String DEFAULT_NUMBER_PATTERN = "#,###.##";
	public static final String DEFAULT_TRUE = "True";
	public static final String DEFAULT_FALSE = "False";
	public static final String[] DEFAULT_BOOLEAN_PATTERN = new String[] { DEFAULT_FALSE, DEFAULT_TRUE };

	private String datepattern;
	private String numberpattern;
	private String[] booleanpattern;

	public CoerceToStringConverter() {
		this.datepattern = DEFAULT_DATE_PATTERN;
		this.numberpattern = DEFAULT_NUMBER_PATTERN;
		this.booleanpattern = DEFAULT_BOOLEAN_PATTERN;
	}

	public CoerceToStringConverter(String numberpattern, String datepattern, String[] booleanpattern) {
		this.datepattern = datepattern;
		this.numberpattern = numberpattern;
		this.booleanpattern = booleanpattern;		
	}

	public String coerce(Object object) {

		if (object == null) {
			return EMPTY_STRING;
		}

		if (object instanceof String) {
			return (String) object;
		}

		if (object instanceof Number) {
			DecimalFormat fmt = new DecimalFormat(numberpattern);
			return fmt.format(object);
		}

		if (object instanceof Date) {
			final SimpleDateFormat fmt = new SimpleDateFormat(datepattern);
			return fmt.format(object);
		}

		if (object instanceof Boolean) {
			return ((Boolean) object).equals(Boolean.FALSE) ? booleanpattern[0] : booleanpattern[1];
		}

		return object.toString();
	}

}
