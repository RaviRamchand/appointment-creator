package ca.sheridan.ramchrav.appointmentcreator.database;

import ca.sheridan.ramchrav.appointmentcreator.beans.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DatabaseAccess {
    @Autowired
    protected NamedParameterJdbcTemplate jdbc;

    //Get all records from the database and send it to Appointment.class as an object
    public List<Appointment> getAppointment(){
        MapSqlParameterSource namedParameter = new MapSqlParameterSource();
        String query = "SELECT * FROM appointment";
        return jdbc.query(query, namedParameter, new BeanPropertyRowMapper<Appointment>(Appointment.class));
    }
}
