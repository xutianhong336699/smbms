package cn.dao;

import cn.entity.Condition;
import cn.entity.User;

import java.util.List;
import java.util.Map;

public interface UserDao {

    // 查找所有
    public List<User> findAll() throws Exception;

    // 查找一个
    public User findUserById(Integer id) throws Exception;

    // 增加一个
    public Integer addUser(User user) throws Exception;

    // 删除一个
    public Integer deleteUser(Integer id) throws Exception;

    // 修改一个
    public Integer updateUser(User user) throws Exception;

    // 封装成实体类作为参数,多条件查询
    public List<User> selectByCondition(Condition condition) throws Exception;

    // 封装成集合作为参数,多条件查询
    public List<User> selectByMap(Map<String,Object> map) throws Exception;

    // 封装成数组作为参数,查询
    public List<User> selectByArray(int Array[]) throws Exception;

    // 智能标签if+where 通过姓名,地址查询信息<只要是实体类User 里面的任意多个属性组合都能查询>
    public List<User> ifTag(User user) throws Exception;

    // 智能标签choose+where 通过姓名查询信息
    public List<User> chooseTag(User user) throws Exception;

    // 智能标签forEach 通过用户id 数组,查询用户信息
    public List<User> forEachTag(int[] id) throws Exception;

    // 智能标签forEach 通过用户id 集合 list<Integer>,查询用户信息
    public List<User> forEachTagList(List<Integer> list) throws Exception;

    // 智能标签forEach 通过用户id 集合list<User>,查询用户信息
    public List<User> forEachTagListUser(List<User> list) throws Exception;

}
