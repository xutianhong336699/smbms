package cn.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtil {
    //终极目标，获取到 session对象
    //对外提供一个方法，可以返回一个SqlSession类型的对象
    //session是从哪里来的，工厂

    static InputStream is;
    static SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
    static {
        try {
            is= Resources.getResourceAsStream("mybaits-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static SqlSessionFactory factory=builder.build(is);

    public static SqlSession getSession(){
        //静态方法中不能直接访问非静态成员
        return factory.openSession();
    }
}
