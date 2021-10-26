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

    public void insertAppointment(Appointment appointment){
        MapSqlParameterSource namedParameter = new MapSqlParameterSource();
        String query = "INSERT INTO appointment(firstName, email, aDate, aTime) " +
                "VALUES(:firstName, :email, :aDate, :aTime)";
        namedParameter.addValue("firstName", appointment.getFirstName());
        namedParameter.addValue("email", appointment.getEmail());
        namedParameter.addValue("aDate", appointment.getADate());
        namedParameter.addValue("aTime", appointment.getATime());

        jdbc.update(query, namedParameter);
    }
}
