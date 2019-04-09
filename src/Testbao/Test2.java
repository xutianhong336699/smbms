import cn.dao.CategoryDao;
import cn.dao.DeptDao;
import cn.dao.EmpDao;
import cn.dao.StudentDao;
import cn.entity.Category;
import cn.entity.Dept;
import cn.entity.Emp;
import cn.entity.Student;
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

    @Test  /*   自关联查询,< N:1  父级菜单列表应用 >   */
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

}
