package com.dms.demo;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.junit.Test;

/**
 * 初始化表
 * @author dms
 * ProcessEngine 是最核心的类
 *
 */
public class InitTable {
	
	@Test
	public void initTables() {
		
		//配置数据源
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/activiti-demo");
//		dataSource.setUsername("root");
//		dataSource.setPassword("root");
		
		//创建流程引擎的配置
		ProcessEngineConfiguration configuration = ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration();
		configuration.setJdbcDriver("com.mysql.jdbc.Driver");
		configuration.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/activiti-demo");
		configuration.setJdbcUsername("root");
		configuration.setJdbcPassword("root");
//		configuration.setDataSource(dataSource);
		
		
		/**
		 * ProcessEngineConfiguration.DB_SCHEMA_UPDATE_FALSE  不管数据库中是否有act的表，都不会进行创建
		 * ProcessEngineConfiguration.DB_SCHEMA_UPDATE_CREATE_DROP 创建表，使用完后删除
		 * ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE 如果数据库中没有表，就创建
		 * ProcessEngineConfiguration.
		 */
		// 配置表的初始化方式
		configuration.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
		
		// 得到流程引擎
		ProcessEngine processEngine = configuration.buildProcessEngine();
		System.out.println(processEngine);
		
	}
	
	@Test
	public void initTables2() {
		//创建流程引擎的配置
		ProcessEngineConfiguration configuration = ProcessEngineConfiguration
			.createProcessEngineConfigurationFromResource("/activiti.cfg.xml");
		ProcessEngine processEngine = configuration.buildProcessEngine();
		System.out.println(processEngine);
	}
	
	@Test
	public void initTables3() {
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		System.out.println(processEngine);
		
		processEngine.getTaskService();
	}

}
