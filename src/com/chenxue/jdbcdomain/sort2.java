package com.chenxue.jdbcdomain;

public class sort2 {

	private int sid;
	private String sname;
	private String sprice;
	private String sdesc;
	
	public sort2() {
		
	}
	
	public sort2(int sid, String sname, String sprice, String sdesc) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.sprice = sprice;
		this.sdesc = sdesc;
	}

	public int getSid() {
		return sid;
	}
	
	@Override
	public String toString() {
		return "sort2 [sid=" + sid + ", sname=" + sname + ", sprice=" + sprice + ", sdesc=" + sdesc + "]";
	}

	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSprice() {
		return sprice;
	}
	public void setSprice(String sprice) {
		this.sprice = sprice;
	}
	public String getSdesc() {
		return sdesc;
	}
	public void setSdesc(String sdesc) {
		this.sdesc = sdesc;
	}
	
}
