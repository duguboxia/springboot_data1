package com.example.wu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class SpringbootDataApplicationTests {

    @Autowired
    DataSource dataSource;
    @Test
    void contextLoads() throws SQLException {
        //class com.zaxxer.hikari.HikariDataSource 查看默认的数据源
        System.out.println("这个是"+dataSource.getClass());

        //获得数据库连接
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }
}
