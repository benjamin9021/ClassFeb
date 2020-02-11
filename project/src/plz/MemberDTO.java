package plz;

import java.io.Serializable;


public class MemberDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String pw;
	private String name;
	private String birthday;
	private int nKey;
	private String signupday;
	
	public MemberDTO() {
		// TODO Auto-generated constructor stub
	}




	public MemberDTO(String id, String pw, String name, String birthday, int nKey, String signupday) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.birthday = birthday;
		this.nKey = nKey;
		this.signupday = signupday;
	}



	public String getSignupday() {
		return signupday;
	}



	public void setSignupday(String signupday) {
		this.signupday = signupday;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public int getnKey() {
		return nKey;
	}

	public void setnKey(int nKey) {
		this.nKey = nKey;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MemberDTO other = (MemberDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}




	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", pw=" + pw + ", name=" + name + ", birthday=" + birthday + ", nKey=" + nKey
				+ ", signupday=" + signupday + "]";
	}
	
	
	
	
	
	
}
