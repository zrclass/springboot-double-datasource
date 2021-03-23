package org.zrclass.doublesource.common.config;

/**
 * @author zhourui 20114535
 * @version 1.0
 * @date 2021/3/23 20:48
 */
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
/**指定dao的位置*/
@MapperScan(basePackages = "org.zrclass.doublesource.web.dao.mysql2" ,sqlSessionTemplateRef = "mysqlSqlSessionTemplate2")
public class MysqlSource2 {

    //创建数据源
    @Bean(name="mysqlDataSource2")
    /**指定数据源的前缀*/
    @ConfigurationProperties(prefix = "spring.datasource.dynamic.datasource.mysql2")
    public DataSource dataSource() {
        return new DataSource();
    }

    /**
     * 创建SqlSessionFactory
     */
    @Bean(name = "mysqlSqlSessionFactory2")
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();

        sqlSessionFactoryBean.setDataSource(dataSource());

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

        //指定mapper文件所在目录
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:mapper/mysql2/*Mapper.xml"));

        return sqlSessionFactoryBean.getObject();
    }

    /**创建事务管理器*/
    @Bean(name = "mysqlTransactionManager2")
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }


    @Bean(name = "mysqlSqlSessionTemplate2")
    public SqlSessionTemplate mysqlSqlSessionTemplate(@Qualifier("mysqlSqlSessionFactory2") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);

    }

}
