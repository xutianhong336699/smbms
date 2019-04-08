package cn.dao;

import cn.entity.Dept;
import cn.entity.Emp;

public interface DeptDao {

    // 一对多,单条sql查询
    public Dept getDeptByDeptno(Integer deptno) throws Exception;

    // 一对多,多条sql查询
    public Dept getDeptByIdMultiSQL(Integer deptno) throws Exception;
}
