package cn.entity;

import java.util.List;

public class Category {
    private Integer cid;    /*当前级编码*/
    private String cname;
    private Integer pid;    /*父级编码*/
    private List<Category> categoryList;  /*当前Category里面包含的Category集合*/
    private Category parent;

    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "Category{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", pid=" + pid +
                ", categoryList=" + categoryList +
                ", parent=" + parent +
                '}';
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public List <Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List <Category> categoryList) {
        this.categoryList = categoryList;
    }
}
