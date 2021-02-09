package myException;
/**
 * 自定义异常
 * @author CAOto
 *
 */
public class MyException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2529413298868261470L;

	public MyException(String msg) {
		super();
		this.msg = msg;
	}
	public MyException() {
		super();
	}

	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
