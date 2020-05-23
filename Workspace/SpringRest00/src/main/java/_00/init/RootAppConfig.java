package _00.init;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import _00.utils.GlobalService;

@Configuration
@EnableTransactionManagement //*****有寫這個註釋，後續才可以使用@Transaction功能
public class RootAppConfig {
	// ------ 資料庫連線資訊 ------
	@Bean
	public DataSource sqlDataSource() {
		ComboPooledDataSource ds = new ComboPooledDataSource();
		ds.setUser("scott");
		ds.setPassword("tiger");
		try {
			ds.setDriverClass("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		ds.setJdbcUrl("jdbc:sqlserver://localhost:1433;databaseName=ProjectGreen");
		ds.setInitialPoolSize(4);
		ds.setMaxPoolSize(8);
		return ds;
	}
	// ----- 建立sessionFactory -----
	//*****重要的LocalSessionFactoryBean class，功能為輔助建立session工廠
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
		//*****映射資訊
		factory.setPackagesToScan(new String[] { "_01", "_02", "_00", "_03", "_04", "social",
				"transportation","comment","restaurant","accommodation","attractions","member"});
		//*****連線資訊，上面的datasource Bean
//		if (GlobalService.DB_TYPE == GlobalService.DB_TYPE_SQLSERVER) {
			factory.setDataSource(sqlDataSource());
			factory.setHibernateProperties(additionalPropertiesMsSQL());
//	    } 
		return factory;
	}
	// ------ 交易管理員 -----
	//*****重要：transactionManager Bean
	//*****@AutoWired放在方法上，自動傳參數
	@Bean(name="transactionManager")
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
         HibernateTransactionManager txManager = new HibernateTransactionManager();
         txManager.setSessionFactory(sessionFactory);
         return txManager;
      }	
	//*****Hibernate Properties → standard java class
	private Properties additionalPropertiesMsSQL() {
		Properties properties=new Properties();
		//*****方言必須注意org.hibernate.dialect.SQLServer2012Dialect.class
		properties.put("hibernate.dialect", org.hibernate.dialect.SQLServer2012Dialect.class);
		properties.put("hibernate.show_sql", Boolean.TRUE); //** for developing
		properties.put("hibernate.format_sql", Boolean.TRUE);
		properties.put("default_batch_fetch_size", 100);
		//*****"create"→把舊的砍光，別亂用
		//*****"update"→啟動時有資料，檢查O/R mapping關係，
		//*****if persistence class 8column→alter table 6 + 2，反之不會刪
		properties.put("hibernate.hbm2ddl.auto", "update");
		return properties;
	}
}
