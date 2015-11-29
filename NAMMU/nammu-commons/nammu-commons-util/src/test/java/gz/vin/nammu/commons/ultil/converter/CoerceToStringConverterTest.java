package gz.vin.nammu.commons.ultil.converter;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Assert;
import org.junit.Test;

import gz.vin.nammu.commons.util.converter.CoerceToStringConverter;

public class CoerceToStringConverterTest {

	@Test
	public void coerceBooleanToString() {
		final CoerceToStringConverter converter = new CoerceToStringConverter();

		Assert.assertEquals("True is True", converter.coerce(Boolean.TRUE), "True");
		Assert.assertEquals("False is False", converter.coerce(Boolean.FALSE), "False");

	}

	@Test
	public void coerceCustonBooleanToString() {
		final CoerceToStringConverter converter = new CoerceToStringConverter(
				CoerceToStringConverter.DEFAULT_NUMBER_PATTERN, CoerceToStringConverter.DEFAULT_DATE_PATTERN,
				new String[] { "No", "Sí" });

		Assert.assertEquals("Custom True is Sí", converter.coerce(Boolean.TRUE), "Sí");
		Assert.assertEquals("Custom False is No", converter.coerce(Boolean.FALSE), "No");

	}

	@Test
	public void coerceIntegerToString() {
		final CoerceToStringConverter converter = new CoerceToStringConverter();

		Assert.assertEquals("Integer is 1.234", converter.coerce(new Integer(1234)), "1.234");
		Assert.assertEquals("Integer is -1.234", converter.coerce(new Integer(-1234)), "-1.234");
		Assert.assertEquals("Integer is 234", converter.coerce(new Integer(234)), "234");
		Assert.assertEquals("Integer is -234", converter.coerce(new Integer(-234)), "-234");
	}

	@Test
	public void coerceCustomIntegerToString() {
		final CoerceToStringConverter converter = new CoerceToStringConverter("00,000",
				CoerceToStringConverter.DEFAULT_DATE_PATTERN, new String[] { "No", "Sí" });

		Assert.assertEquals("Integer is 01.234", converter.coerce(new Integer(1234)), "01.234");
		Assert.assertEquals("Integer is -01.234", converter.coerce(new Integer(-1234)), "-01.234");
		Assert.assertEquals("Integer is 00.234", converter.coerce(new Integer(234)), "00.234");
		Assert.assertEquals("Integer is -00.234", converter.coerce(new Integer(-234)), "-00.234");
	}

	@Test
	public void coerceDecimalToString() {
		final CoerceToStringConverter converter = new CoerceToStringConverter();

		Assert.assertEquals("Decimal is 1.234,1", converter.coerce(new Double(1234.1)), "1.234,1");
		Assert.assertEquals("Decimal is -1.234,12", converter.coerce(new Double(-1234.123)), "-1.234,12");
		Assert.assertEquals("Decimal is 234,1", converter.coerce(new Double(234.1)), "234,1");
		Assert.assertEquals("Decimal is -234,12", converter.coerce(new Double(-234.123)), "-234,12");
	}

	@Test
	public void coerceCustomDecimalToString() {
		final CoerceToStringConverter converter = new CoerceToStringConverter("00,000.000",
				CoerceToStringConverter.DEFAULT_DATE_PATTERN, new String[] { "No", "Sí" });

		Assert.assertEquals("Decimal is 01.234,100", converter.coerce(new Double(1234.1)), "01.234,100");
		Assert.assertEquals("Decimal is -01.234,123", converter.coerce(new Double(-1234.123)), "-01.234,123");
		Assert.assertEquals("Decimal is 00.234,100", converter.coerce(new Double(234.1)), "00.234,100");
		Assert.assertEquals("Decimal is -00.234,123", converter.coerce(new Double(-234.123)), "-00.234,123");
	}

	@Test
	public void coerceBigDecimalToString() {
		final CoerceToStringConverter converter = new CoerceToStringConverter();

		Assert.assertEquals("Decimal is 1.234,1", converter.coerce(new BigDecimal(new Double(1234.1))), "1.234,1");
		Assert.assertEquals("Decimal is -1.234,12", converter.coerce(new BigDecimal(new Double(-1234.123))),
				"-1.234,12");
		Assert.assertEquals("Decimal is 234,1", converter.coerce(new BigDecimal(new Double(234.1))), "234,1");
		Assert.assertEquals("Decimal is -234,12", converter.coerce(new BigDecimal(new Double(-234.123))), "-234,12");
	}

	@Test
	public void coerceCustomBigDecimalToString() {
		final CoerceToStringConverter converter = new CoerceToStringConverter("00,000.000",
				CoerceToStringConverter.DEFAULT_DATE_PATTERN, CoerceToStringConverter.DEFAULT_BOOLEAN_PATTERN);

		Assert.assertEquals("Decimal is 01.234,100", converter.coerce(new BigDecimal(new Double(1234.1))),
				"01.234,100");
		Assert.assertEquals("Decimal is -01.234,123", converter.coerce(new BigDecimal(new Double(-1234.123))),
				"-01.234,123");
		Assert.assertEquals("Decimal is 00.234,100", converter.coerce(new BigDecimal(new Double(234.1))), "00.234,100");
		Assert.assertEquals("Decimal is -00.234,123", converter.coerce(new BigDecimal(new Double(-234.123))),
				"-00.234,123");
	}

	@Test
	public void coerceDateToString() throws ParseException {
		final CoerceToStringConverter converter = new CoerceToStringConverter();
		final SimpleDateFormat fmt = new SimpleDateFormat("dd/mm/yyyy");

		Assert.assertEquals("Date is 28-11-2015", converter.coerce(fmt.parse("28/11/2015")), "28-11-2015");
	}

	@Test
	public void coerceCustomDateToString() throws ParseException {
		final CoerceToStringConverter converter = new CoerceToStringConverter(
				CoerceToStringConverter.DEFAULT_NUMBER_PATTERN, "yyyy/mm/dd",
				CoerceToStringConverter.DEFAULT_BOOLEAN_PATTERN);
		final SimpleDateFormat fmt = new SimpleDateFormat("dd/mm/yyyy");

		Assert.assertEquals("Date is 2015/11/28", converter.coerce(fmt.parse("28/11/2015")), "2015/11/28");
	}

	@Test
	public void coerceObectToString() {
		final CoerceToStringConverter converter = new CoerceToStringConverter();

		Assert.assertEquals("Object is The Test Object Class", converter.coerce(new TestObject()), "The Test Object Class");
	}

	class TestObject {
		@Override
		public String toString() {
			return "The Test Object Class";
		}
	}

}
