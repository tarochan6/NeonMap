package domain;

public class Member {
private Integer id;
private String loginId;
private String memberName;
private String loginPass;

public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getLoginId() {
	return loginId;
}
public void setLoginId(String loginId) {
	this.loginId = loginId;
}
public String getMemberName() {
	return memberName;
}
public void setMemberName(String memberName) {
	this.memberName = memberName;
}
public String getLoginPass() {
	return loginPass;
}
public void setLoginPass(String loginPass) {
	this.loginPass = loginPass;
}


}
