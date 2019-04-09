package cn.dao;

import cn.entity.Student;

import java.util.List;

public interface StudentDao {
    // 多对多查询
    public List<Student> findStudentByTid(Integer tid);
}
