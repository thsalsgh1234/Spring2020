package com.biz.shop.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.jasypt.encryption.StringEncryptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import lombok.extern.slf4j.Slf4j;

/*
 * mybatis 설정을 xml을 사용하지 않고 java config 방식으로 설정
 * 1. dataSource
 * 2. SessionFactory
 * 3. SessionTemplate or TransactionManager
 * 
 */
@Slf4j
@Configuration

// src/main/resouces 폴더에 있는 db.conn..properties 파일을 읽어서
// 사용할 준비를 해 달라
@PropertySource("classpath:db.connection2.properties")
public class DBSetupConfig {

	// property에 저장되어 있는 mysql.username의 값을 읽어서
	// mySqlUserName 변수에 할당(저장)해 달라
	@Value("${mysql.username}")
	private String mySqlUserName;
	
	@Value("${mysql.password}")
	private String mySqlPassword;
	
	@Autowired
	StringEncryptor stringEnc;
	
	
	/*
	 * dataSource를 생성(new)하여 다른 method에 주입
	 */
	@Bean
	public DataSource ds() {

		BasicDataSource ds = new BasicDataSource();

		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/secur"
				+ "?serverTimeZone=Asia/Seoul");
		
		log.debug("USER NAME : " + stringEnc.decrypt(mySqlUserName));
		
		ds.setUsername(stringEnc.decrypt(mySqlUserName));
		ds.setPassword(stringEnc.decrypt(mySqlPassword));
		
		return ds;
	
	}
	
	@Bean
	public SqlSessionFactoryBean sqlSessionFacoty() {
		SqlSessionFactoryBean sf
		= new SqlSessionFactoryBean();
		sf.setDataSource(ds());
		return sf;
	}
	
	@Bean
	public DataSourceTransactionManager transaction() {
		DataSourceTransactionManager tsm 
		= new DataSourceTransactionManager(ds());
		return tsm;
	}
	
}






