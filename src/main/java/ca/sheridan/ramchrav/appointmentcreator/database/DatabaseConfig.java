package ca.sheridan.ramchrav.appointmentcreator.database;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {
    @Bean
    public NamedParameterJdbcTemplate namedParameter(DataSource dataSource){
        return new NamedParameterJdbcTemplate(dataSource);
    }
}
