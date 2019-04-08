import cn.dao.UserDao;
import cn.entity.Condition;
import cn.entity.User;
import cn.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test1 {

    @Test   // 查全
    public void test1() throws Exception {
        SqlSession sqlSession =  MybatisUtil.getSession();
        UserDao dao = sqlSession.getMapper(UserDao.class);
        List<User> userList = dao.findAll();
        for (User user:userList) {
            System.out.println(user);
        }
    }

    @Test  // 查一个
    public void test2() throws Exception {
        SqlSession sqlSession =  MybatisUtil.getSession();
        UserDao dao = sqlSession.getMapper(UserDao.class);
        User user = dao.findUserById(1);
        System.out.println(user);
    }

    @Test  // 增加一个
    public void test3() throws Exception {
        SqlSession sqlSession = MybatisUtil.getSession();
        UserDao dao = sqlSession.getMapper(UserDao.class);
        User user = new User();
        user.setUserName("北大青鸟");
        user.setUserpassword("123321");
        Integer count = dao.addUser(user);
        if(count>0){
            System.out.println("添加成功");
        }
        sqlSession.commit();
    }

    @Test  // 删除一个
    public void test4() throws Exception {
        SqlSession sqlSession =  MybatisUtil.getSession();
        UserDao dao = sqlSession.getMapper(UserDao.class);
        Integer count = dao.deleteUser(20);
        if(count>0){
            System.out.println("删除成功");
        }
        sqlSession.commit();
    }

    @Test  // 修改一个
    public void test5() throws Exception {
        SqlSession sqlSession = MybatisUtil.getSession();
        UserDao dao = sqlSession.getMapper(UserDao.class);
        User user = new User();
        user.setId(15);
        user.setUserpassword("123321");
        Integer count = dao.updateUser(user);
        if(count>0){
            System.out.println("修改成功");
        }
        sqlSession.commit();
    }

    @Test  // 多条件查询 1 封装实体类
    public void test6() throws Exception {
        SqlSession sqlSession =  MybatisUtil.getSession();
        UserDao dao = sqlSession.getMapper(UserDao.class);
        Condition condition = new Condition();
        condition.setUserName("徐田红");
        condition.setAddress("北京");
        List<User> list = dao.selectByCondition(condition);
        for (User user:list) {
            System.out.println(user);
        }
    }

    @Test  // 多条件查询 1 Map集合
    public void test7() throws Exception {
        SqlSession sqlSession =  MybatisUtil.getSession();
        UserDao dao = sqlSession.getMapper(UserDao.class);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("userName1","孙");  /* 与小配置文件里面的大括号里面的参数相同*/
        map.put("address1","北京");
        List<User> list = dao.selectByMap(map);
        for (User user:list) {
            System.out.println(user);
        }
    }

    @Test  //  智能标签if+where 查询(通过姓名查询用户信息,<也可以多条件查询，传实体类参数即可，此处加了个地址>)
    public void test8() throws Exception {
        SqlSession sqlSession =  MybatisUtil.getSession();
        UserDao dao = sqlSession.getMapper(UserDao.class);
        User user = new User();
        user.setUserName("徐田红");   // 此处小配置文件中没有用到模糊查询
        user.setAddress("北京");      // 此处小配置文件中没有用到模糊查询
        List<User> list = dao.ifTag(user);
        for (User item:list) {
            System.out.println(item);
        }
    }

    @Test  //  智能标签choose+where 查询(通过姓名查询用户信息,<也可以多条件查询，传实体类参数即可，此处加了个地址>)
    public void test9() throws Exception {
        SqlSession sqlSession =  MybatisUtil.getSession();
        UserDao dao = sqlSession.getMapper(UserDao.class);
        User user = new User();

/* 此处UserName 和 Address 只赋值一个即可，因为choose标签只需要一个条件就行<两个都写也行，实际sql语句只用到一个>，相当于switch方法  */
        /*user.setUserName("徐田红");*/   // 此处小配置文件中没有用到模糊查询
        user.setAddress("北京");      // 此处小配置文件中没有用到模糊查询
        List<User> list = dao.chooseTag(user);
        for (User item:list) {
            System.out.println(item);
        }
    }

    @Test  //  智能标签foreach 查询 (id 数组查询)
    public void test10() throws Exception {
        SqlSession sqlSession =  MybatisUtil.getSession();
        UserDao dao = sqlSession.getMapper(UserDao.class);
        int[] nums = {1,2,3};
        List<User> list = dao.forEachTag(nums);
        for (User item:list) {
            System.out.println(item);
        }
    }

    @Test  //  智能标签foreach 查询 (id List集合查询)
    public void test11() throws Exception {
        SqlSession sqlSession =  MybatisUtil.getSession();
        UserDao dao = sqlSession.getMapper(UserDao.class);
        List<Integer> list = new ArrayList <>();
        list.add(1);
        list.add(2);
        list.add(3);
        List<User> userlist = dao.forEachTagList(list);
        for (User item:userlist) {
            System.out.println(item);
        }
    }

    @Test  //  智能标签foreach 查询 (id List强类型集合查询)
    public void test12() throws Exception {
        SqlSession sqlSession =  MybatisUtil.getSession();
        UserDao dao = sqlSession.getMapper(UserDao.class);
        User user1 = new User();
        user1.setId(1);
        User user2 = new User();
        user2.setId(2);
        User user3 = new User();
        user3.setId(3);
        List<User> list = new ArrayList <>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        List<User> userlist = dao.forEachTagListUser(list);
        for (User item:userlist) {
            System.out.println(item);
        }
    }

}
