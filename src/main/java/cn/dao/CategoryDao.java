package cn.dao;

import cn.entity.Category;

import java.util.List;

public interface CategoryDao {

    // 自关联 1：N
    public List<Category> findCategoryByPid(Integer pid) throws Exception;
    // 自关联 N:1
    public List<Category> findCategoryByCid(Integer cid) throws Exception;
}
