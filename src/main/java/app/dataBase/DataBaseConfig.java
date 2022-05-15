package app.dataBase;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@ComponentScan
@Configuration
public class DataBaseConfig {

    @Bean(name = "dataSource")
    public DriverManagerDataSource src() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        driverManagerDataSource.setUrl("jdbc:sqlserver://localhost:1433;databaseName=SA");
        driverManagerDataSource.setUsername("qq");
        driverManagerDataSource.setPassword("1234567890");
        return driverManagerDataSource;
    }

}
