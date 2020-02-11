package plz;

import java.io.Serializable;

public class BoardDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int num;
	private String id;
	private String title;
	private String content;
	private String writeday;
	private int readcnt;
	private int repRoot;
	private int repStep;
	private int repIndent;
	private int notice;
	
	public BoardDTO() {
		// TODO Auto-generated constructor stub
	}

	
	
	public BoardDTO(int num, String id, String title, String content, String writeday, int readcnt, int repRoot,
			int repStep, int repIndent, int notice) {
		super();
		this.num = num;
		this.id = id;
		this.title = title;
		this.content = content;
		this.writeday = writeday;
		this.readcnt = readcnt;
		this.repRoot = repRoot;
		this.repStep = repStep;
		this.repIndent = repIndent;
		this.notice = notice;
	}



	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriteday() {
		return writeday;
	}

	public void setWriteday(String writeday) {
		this.writeday = writeday;
	}

	public int getReadcnt() {
		return readcnt;
	}

	public void setReadcnt(int readcnt) {
		this.readcnt = readcnt;
	}

	public int getRepRoot() {
		return repRoot;
	}

	public void setRepRoot(int repRoot) {
		this.repRoot = repRoot;
	}

	public int getRepStep() {
		return repStep;
	}

	public void setRepStep(int repStep) {
		this.repStep = repStep;
	}

	public int getRepIndent() {
		return repIndent;
	}

	public void setRepIndent(int repIndent) {
		this.repIndent = repIndent;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getNotice() {
		return notice;
	}



	public void setNotice(int notice) {
		this.notice = notice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + num;
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
		BoardDTO other = (BoardDTO) obj;
		if (num != other.num)
			return false;
		return true;
	}

	
	
}
