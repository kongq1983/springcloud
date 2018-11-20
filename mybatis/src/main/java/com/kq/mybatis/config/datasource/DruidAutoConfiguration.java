package com.kq.mybatis.config.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.io.Serializable;
import java.sql.SQLException;

/**
 * @author kq
 * @date 2017年3月28日
 */
@SuppressWarnings("Duplicates")
@Configuration
@EnableConfigurationProperties(DruidProperties.class)
@ConditionalOnClass(DruidDataSource.class)
@ConditionalOnProperty(prefix = "datasource", name = "use", havingValue = "druid")
@AutoConfigureBefore(DataSourceAutoConfiguration.class)
public class DruidAutoConfiguration implements Serializable {

    @Autowired
    private DruidProperties properties;

    @Bean
    public DataSource dataSource() throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setName(properties.getName());
        dataSource.setUrl(properties.getUrl());
//        if(properties.isEncrypted()) {
//            DesEncrypt encrypt = DesEncrypt.getInstance();
//            dataSource.setUsername(encrypt.decrypt(properties.getUsername()));
//            dataSource.setPassword(encrypt.decrypt(properties.getPassword()));
//        }else{
            dataSource.setUsername(properties.getUsername());
            dataSource.setPassword(properties.getPassword());
//        }
        if (properties.getInitialSize() > 0) {
            dataSource.setInitialSize(properties.getInitialSize());
        }
        if (properties.getMinIdle() > 0) {
            dataSource.setMinIdle(properties.getMinIdle());
        }
        if (properties.getMaxActive() > 0) {
            dataSource.setMaxActive(properties.getMaxActive());
        }

        dataSource.setDriverClassName(properties.getDriverClass());
        dataSource.setMaxWait(properties.getMaxWait());
        dataSource.setPoolPreparedStatements(properties.isPoolPreparedStatements());
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(properties.getMaxPoolPreparedStatementPerConnectionSize());
        dataSource.setValidationQuery(properties.getValidationQuery());
        dataSource.setValidationQueryTimeout(properties.getValidationQueryTimeout());
        dataSource.setTestOnBorrow(properties.isTestOnBorrow());
        dataSource.setTestOnReturn(properties.isTestOnReturn());
        dataSource.setTestWhileIdle(properties.isTestWhileIdle());
        dataSource.setKeepAlive(properties.isKeepAlive());
        dataSource.setTimeBetweenEvictionRunsMillis(properties.getTimeBetweenEvictionRunsMillis());
        dataSource.setMinEvictableIdleTimeMillis(properties.getMinEvictableIdleTimeMillis());
        dataSource.setConnectionInitSqls(properties.getConnectionInitSqls());
        dataSource.setExceptionSorter(properties.getExceptionSorter());
        dataSource.setFilters(properties.getFilters());

        if(properties.isRemoveAbandoned()) {
            dataSource.setRemoveAbandoned(properties.isRemoveAbandoned());
            dataSource.setRemoveAbandonedTimeout(properties.getRemoveAbandonedTimeout());
            dataSource.setLogAbandoned(properties.isLogAbandoned());
        }

        try {
            dataSource.init();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return dataSource;
    }
}
