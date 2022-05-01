package app.dataBase;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@ComponentScan
@Configuration
public class DataBaseConfig {

    /*private static final String HOST = "jdbc:sqlserver://localhost:1433;databaseName=SA";
    private static final String USERNAME = "qq";
    private static final String PASSWORD = "1234567890";
    Connection connection = DriverManager.getConnection(HOST, USERNAME, PASSWORD);

    public DataBaseConfig() throws SQLException {
    }*/

    @Bean(name = "dataSource")
    public DriverManagerDataSource src() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        driverManagerDataSource.setUrl("jdbc:sqlserver://localhost:1433;databaseName=SA");
        driverManagerDataSource.setUsername("qq");
        driverManagerDataSource.setPassword("1234567890");
        return driverManagerDataSource;
    }

    /*@Bean
    public DataSource dataSource(){
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        ds.setUrl("jdbc:sqlserver://localhost:1433;databaseName=SA");
        ds.setUsername("qq");
        ds.setPassword("1234567890");
        return ds;
    }*/

}
