package cn.entity;

public class Condition {
    private String userName;
    private String address;

    @Override
    public String toString() {
        return "Condition{" +
                "userName='" + userName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
