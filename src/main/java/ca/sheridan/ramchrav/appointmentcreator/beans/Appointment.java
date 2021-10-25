package ca.sheridan.ramchrav.appointmentcreator.beans;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
public class Appointment implements Serializable {
    private long id;
    private String firstName;
    private String email;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate aDate;

    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime aTime;
}
