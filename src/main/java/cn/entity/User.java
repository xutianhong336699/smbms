package cn.entity;

import java.util.Date;

public class User {
  private Integer id;
  private String usercode;
  private String userName;
  private String userpassword;
  private Integer gender;
  private Date birthday;
  private String phone;
  private String address;
  private Integer userrole;
  private Integer createdby;
  private Date creationdate;
  private Integer modifyby;
  private Date modifydate;

  @Override
  public String toString() {
    return "User{" +
            "id=" + id +
            ", usercode='" + usercode + '\'' +
            ", userName='" + userName + '\'' +
            ", userpassword='" + userpassword + '\'' +
            ", gender=" + gender +
            ", birthday=" + birthday +
            ", phone='" + phone + '\'' +
            ", address='" + address + '\'' +
            ", userrole=" + userrole +
            ", createdby=" + createdby +
            ", creationdate=" + creationdate +
            ", modifyby=" + modifyby +
            ", modifydate=" + modifydate +
            '}';
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUsercode() {
    return usercode;
  }

  public void setUsercode(String usercode) {
    this.usercode = usercode;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getUserpassword() {
    return userpassword;
  }

  public void setUserpassword(String userpassword) {
    this.userpassword = userpassword;
  }

  public Integer getGender() {
    return gender;
  }

  public void setGender(Integer gender) {
    this.gender = gender;
  }

  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Integer getUserrole() {
    return userrole;
  }

  public void setUserrole(Integer userrole) {
    this.userrole = userrole;
  }

  public Integer getCreatedby() {
    return createdby;
  }

  public void setCreatedby(Integer createdby) {
    this.createdby = createdby;
  }

  public Date getCreationdate() {
    return creationdate;
  }

  public void setCreationdate(Date creationdate) {
    this.creationdate = creationdate;
  }

  public Integer getModifyby() {
    return modifyby;
  }

  public void setModifyby(Integer modifyby) {
    this.modifyby = modifyby;
  }

  public Date getModifydate() {
    return modifydate;
  }

  public void setModifydate(Date modifydate) {
    this.modifydate = modifydate;
  }
}
