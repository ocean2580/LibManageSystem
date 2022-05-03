package book.manage.sql;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;


public class SqlUtil {
    private SqlUtil() {}

    private static SqlSessionFactory factory;
    static {
        try {
            // 取出 resources 文件
            factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public SqlSession getSession() {
        return factory.openSession(true);
    }
}
