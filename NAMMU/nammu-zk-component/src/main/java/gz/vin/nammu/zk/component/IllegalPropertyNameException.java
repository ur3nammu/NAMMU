package gz.vin.nammu.zk.component;

public class IllegalPropertyNameException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IllegalPropertyNameException() {
		super();
	}

	public IllegalPropertyNameException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public IllegalPropertyNameException(String message, Throwable cause) {
		super(message, cause);
	}

	public IllegalPropertyNameException(String message) {
		super(message);
	}

	public IllegalPropertyNameException(Throwable cause) {
		super(cause);
	}

	
}
