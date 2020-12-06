package SimpleLove.beans;

public class USER_ACCOUNT {
 private String user_name;
 private String password;
 private String phone;
 private String email;
 private String role;
 private String active;
 private String address;
 private String gener;
 
 public static final String GENER_MALE="M";
 public static final String GENER_FEMALE="F";

 public static final String TRUE_ACTIVE="1";
 public static final String FALSE_ACTIVE="0";
 
 public  USER_ACCOUNT() 
 {
	 
 }
 public String getUserName()
 {
	 return user_name;
 }
 public void setUserName(String user_name)
 {
	 this.user_name= user_name;
 }
 public String  getPassWord()
 { 
	 return password;
}
public void setPassWord(String s)
{
	this.password= s;
}
public String getPhone()
{
	return phone;
}
public void setPhone(String phone)
{
	this.phone=phone;
}
public String getEmail()
{
	return email;
}
public void setEmail(String email)
{
	this.email= email;
}
public String getRole()
{
	return this.role;
}
public void setRole(String role)
{
	this.role= role;
}
public String getActive()
{
	return this.active;
}
public void setActive(String active)
{
	this.active= active;
}
public String getGener()
{
	 return this.gener;
}
public void setGener(String gener)
{
	this.gener= gener
}
}
