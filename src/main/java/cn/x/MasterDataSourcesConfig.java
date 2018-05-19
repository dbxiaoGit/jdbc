package cn.x;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
public class MasterDataSourcesConfig {

	@ConfigurationProperties("spring.datasource.ds1")
	@Primary
	@Bean(name = "masterDataSource")
	public DruidDataSource druidDataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf-8");
		dataSource.setUsername("root"); 
		dataSource.setPassword(""); 
		dataSource.setInitialSize(3); 
		dataSource.setMaxActive(20); 
		return dataSource;
	}

	@Bean(name = "masterTransactionManager")
	@Primary
	public DataSourceTransactionManager masterTransactionManager() {
		return new DataSourceTransactionManager(druidDataSource());
	}

	@Bean(name = "jdbcTemplate")
	public JdbcTemplate initJdbcTemplate(@Qualifier("masterDataSource") DataSource masterDataSource) {
		return new JdbcTemplate(masterDataSource);
	}

}