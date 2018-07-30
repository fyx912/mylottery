package com.yys.lottery.api.config.dataSources;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = {"com.yys.lottery.core.dao.*"}, sqlSessionTemplateRef = "lotterySqlSessionTemplate")
public class LotteryMybatisConfig {

    @Bean(name = "lotteryDataSource")
    @Primary //必须加此注解，不然报错，下一个类则不需要添加
    @ConfigurationProperties(prefix = "spring.datasource.lottery") // prefix值必须是application.properties中对应属性的前缀
    public DataSource userDataSource() {
        return DruidDataSourceBuilder.create().build();//阿里druid pool
//        return DataSourceBuilder.create().build();//默认的hikari连接池
    }

    @Bean
    public SqlSessionFactory lotterySqlSessionFactory(@Qualifier("lotteryDataSource") DataSource dataSource){
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
//        //添加XML目录
//        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
//            bean.setMapperLocations(resolver.getResources("classpath*:com/user/server/dao/mapping/*.xml"));
            return bean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Bean
    public SqlSessionTemplate lotterySqlSessionTemplate(@Qualifier("lotterySqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory); // 使用上面配置的Factory
        return template;
    }
}
