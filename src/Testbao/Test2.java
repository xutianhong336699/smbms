import cn.dao.*;
import cn.entity.*;
import cn.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class Test2 {

    @Test /*    一对多,单条sql查询    */
    public void test1() throws Exception{
        SqlSession sqlSession =  MybatisUtil.getSession();
        DeptDao dao = sqlSession.getMapper(DeptDao.class);
        Dept dept = dao.getDeptByDeptno(1);
        System.out.println(dept.getDeptName());
        System.out.println("---------------------");
        for (Emp emp:dept.getEmps()) {
            System.out.println(emp.getEmpName());
        }
    }

    @Test /*    一对多,多条sql查询    */
    public void test2() throws Exception{
        SqlSession sqlSession =  MybatisUtil.getSession();
        DeptDao dao = sqlSession.getMapper(DeptDao.class);
        Dept dept = dao.getDeptByIdMultiSQL(1);
        System.out.println(dept.getDeptName());
        System.out.println("---------------------");
        for (Emp emp:dept.getEmps()) {
            System.out.println(emp.getEmpName());
        }

    }

    @Test /*    多对一,单条sql查询    */
    public void test3() throws Exception{
        SqlSession sqlSession =  MybatisUtil.getSession();
        EmpDao dao = sqlSession.getMapper(EmpDao.class);
        Emp emp = dao.getEmpByEmpno(1);
        System.out.println(emp.getEmpName());
        System.out.println("---------------------");
        System.out.println(emp.getDept().getDeptName());
    }


    @Test /*    多对一,多条sql查询    */
    public void test4() throws Exception{
        SqlSession sqlSession = MybatisUtil.getSession();
        EmpDao dao = sqlSession.getMapper(EmpDao.class);
        Emp emp = dao.getEmpByEmpnoMutil(4);
        System.out.println(emp.getEmpName());
        System.out.println("---------------------");
        System.out.println(emp.getDept().getDeptName());
    }


    @Test  /*   自关联查询,< 1：N  多级菜单列表应用 >   */
    public void test5() throws Exception{
        SqlSession sqlSession =  MybatisUtil.getSession();
        CategoryDao dao = sqlSession.getMapper(CategoryDao.class);
        List <Category> list = dao.findCategoryByPid(0);
        for (Category category:list) {
            System.out.println(category);
        }
    }

    @Test  /*   自关联查询,   < N:1  父级菜单列表应用 >   */
    public void test6() throws Exception{
        SqlSession sqlSession =  MybatisUtil.getSession();
        CategoryDao dao = sqlSession.getMapper(CategoryDao.class);
        List <Category> categoryList = dao.findCategoryByCid(5);
        for (Category category:categoryList) {
            System.out.println(category);
        }
    }

    @Test  /*   多对多查询    */
    public void test7() throws Exception{
        SqlSession sqlSession =  MybatisUtil.getSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List <Student> studentList = dao.findStudentByTid(1);
        for (Student stu:studentList) {
            System.out.println(stu);
        }
    }

    @Test /*证明一级缓存的存在*/
    public void test8() throws Exception{
        SqlSession sqlSession = MybatisUtil.getSession();
        UserDao dao = sqlSession.getMapper(UserDao.class);

        /*只有第一次查询，连接了数据库，后面两次查询不是查询数据库，二是从一级缓存中拿数据
        * < 通过控制台打印结果可以看出：后两次查询都没有调用sql语句 >*/
        List <User> list1 = dao.findAll();
        for (User user:list1) {
            System.out.println(user.getUserName());
        }

        System.out.println("-----------------------");

        List <User> list2 = dao.findAll();
        for (User user:list2) {
            System.out.println(user.getUserName());
        }

        System.out.println("-----------------------");
        List <User> list3 = dao.findAll();
        for (User user:list3) {
            System.out.println(user.getUserName());
        }
    }

    @Test /* 增删改对一级缓存的影响 ———— 使一级缓存失效 */
    public void test9() throws Exception{
        SqlSession sqlSession = MybatisUtil.getSession();
        UserDao dao = sqlSession.getMapper(UserDao.class);

        /*第一次查询，连接了数据库，增< 删,改 >操作以后，一级缓存失效，再次查询的话，需重新连接数据库。
        * < 通过控制台打印结果可以看出：增操作的前后两次查询都调用sql语句 >*/
        List <User> list1 = dao.findAll();
        for (User user:list1) {
            System.out.println(user.getUserName());
        }

        System.out.println("-----------------------");

        User user = new User();
        user.setUserName("无敌大胃王");
        user.setAddress("火锅之城");
        dao.addUser(user);

        List <User> list2 = dao.findAll();
        for (User item:list2) {
            System.out.println(item.getUserName());
        }
    }

    @Test /* 二级缓存    命中率=(n-1)/n   n:sqlSession关闭的次数   */
    public void test10() throws Exception{
        SqlSession sqlSession1 = MybatisUtil.getSession();
        UserDao dao1 = sqlSession1.getMapper(UserDao.class);
        List <User> list1 = dao1.findAll();
        for (User item:list1) {
            System.out.println(item.getUserName());
        }
        MybatisUtil.closeSession(sqlSession1);

        System.out.println("-----------------------");

        SqlSession sqlSession2 = MybatisUtil.getSession();
        UserDao dao2 = sqlSession2.getMapper(UserDao.class);
        List <User> list2 = dao2.findAll();
        for (User item:list2) {
            System.out.println(item.getUserName());
        }
        MybatisUtil.closeSession(sqlSession2);
    }
}
