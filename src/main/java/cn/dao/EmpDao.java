package cn.dao;

import cn.entity.Emp;

public interface EmpDao {
    // 多对一  单条Sql 根据员工编号 检索员工名称和所属部门
    public Emp getEmpByEmpno(Integer empno) throws Exception;

    // 多对一  多条Sql 根据员工编号 检索员工名称和所属部门
    public Emp getEmpByEmpnoMutil(Integer empno) throws Exception;
}
