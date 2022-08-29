package domain;

import java.util.Date;

public class Neon {
private String name;
private Integer id;
private Integer memberId;
private String memberName;
private String address;
private Date registered;
private String note;


public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public Integer getMemberId() {
	return memberId;
}
public void setMemberId(Integer memberId) {
	this.memberId = memberId;
}
public String getMemberName() {
	return memberName;
}
public void setMemberName(String memberName) {
	this.memberName = memberName;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public Date getRegistered() {
	return registered;
}
public void setRegistered(Date registered) {
	this.registered = registered;
}
public String getNote() {
	return note;
}
public void setNote(String note) {
	this.note = note;
}


}
