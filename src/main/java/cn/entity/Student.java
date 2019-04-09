package cn.entity;

public class Student {
    private Integer sid;
    private String sname;

    @Override
    public String toString() {
        return "Stu_Teach{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                '}';
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }
}
