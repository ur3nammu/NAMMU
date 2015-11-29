package gz.vin.nammu.commons.util.bean;

import java.util.StringTokenizer;

import org.apache.commons.beanutils.PropertyUtils;

public class SetPropertyUtils {

	public static boolean hasSetProperties(String property) {

		if (property.contains("#.")) {

			return true;
		}

		return false;

	}

	@SuppressWarnings("rawtypes")
	public static boolean isReadable(Object bean, String name) throws Exception {

		Object value = bean;
		final StringTokenizer stk = new StringTokenizer(name, "#.");

		while (stk.hasMoreTokens()) {
			final String property = stk.nextToken();
			
			if (!PropertyUtils.isReadable(value, property)) {
				return false;
			}

			value = PropertyUtils.getProperty(value, property);

			if (value instanceof Iterable) {
				value = ((Iterable) value).iterator().next();
			}
		}

		return true;
	}

	@SuppressWarnings("rawtypes")
	public static Object getProperty(Object bean, String name) throws Exception {

		Object value = bean;
		final StringTokenizer stk = new StringTokenizer(name, "#.");

		while (stk.hasMoreTokens()) {
			value = PropertyUtils.getProperty(value, stk.nextToken());
			if (value instanceof Iterable) {
				value = ((Iterable) value).iterator().next();
			}
		}

		return value;
	}

}
