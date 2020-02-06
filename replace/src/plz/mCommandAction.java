package plz;

public class mCommandAction {
	private boolean isRedirect;
	private String where;
	
	public mCommandAction() {
		// TODO Auto-generated constructor stub
	}

	public mCommandAction(boolean isRedirect, String where) {
		super();
		this.isRedirect = isRedirect;
		this.where = where;
	}

	public boolean isRedirect() {
		return isRedirect;
	}

	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}

	public String getWhere() {
		return where;
	}

	public void setWhere(String where) {
		this.where = where;
	}
	
	
}
