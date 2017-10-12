package net.madinpro.evaleasy.exceptions;

@SuppressWarnings({ "unused", "serial" })
public class DaoException extends RuntimeException {

	private int code;
	private String message;

	public DaoException(int code) {
		super();
		this.code = code;
	}

	public DaoException(String message) {
		super(message);

	}

	public DaoException(int code, String message) {
		super(message);
		this.code = code;
	}

	public DaoException(Throwable cause, int code) {
		super(cause);
		this.code = code;
	}

	public DaoException(String message, Throwable cause, int code) {
		super(message, cause);
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
