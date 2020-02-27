package com.example.wu.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;
import java.util.HashMap;


@Configuration
public class druidConfig {
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean  //注入bean中并绑定yml
    public DataSource druidDataSource(){
        return new DruidDataSource();
    }

    //后台监控 相当于web.xml
    //因为springBoot内置了servlet容器 所有没有web.xml，替代方法为 ServletRegistrationBean
    @Bean
    public ServletRegistrationBean StatViewServlet(){
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");

        //后台需要登录，账号密码配置

        HashMap<String, String> initParameters = new HashMap<>();
        //增加配置,注意登录的username and password是固定的 loginUsername loginPassword
        initParameters.put("loginUsername","admin");
        initParameters.put("loginPassword","123456");

        //允许谁可以访问
        initParameters.put("allow","");

        //禁止谁访问 initParameters.put("hhh","169.254.80.100");

        bean.setInitParameters(initParameters);//设置初始化参数
        return bean;
    }

    //filters
    @Bean
    public FilterRegistrationBean WebStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean<>();

        bean.setFilter(new WebStatFilter());

        HashMap<String, String> initParameters = new HashMap<>();

        //不过滤的内容
        initParameters.put("exclusions","*.js,*.css,/druid/*");

        bean.setInitParameters(initParameters);
        return bean;
    }
}
