package cn.dao;

import cn.entity.Category;

import java.util.List;

public interface CategoryDao {
    public List<Category> findCategoryByPid(Integer pid) throws Exception;
}
