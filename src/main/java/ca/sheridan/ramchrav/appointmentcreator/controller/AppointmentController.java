package ca.sheridan.ramchrav.appointmentcreator.controller;

import ca.sheridan.ramchrav.appointmentcreator.beans.Appointment;
import ca.sheridan.ramchrav.appointmentcreator.database.DatabaseAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

//Makes the class into a Controller
@Controller
public class AppointmentController {
    @Autowired
    private DatabaseAccess da;

    @GetMapping("/")
    public String getIndex(Model model, @ModelAttribute Appointment appointment){
        //Send database records to index.html
        model.addAttribute("aList", da.getAppointment());
        //Send empty object to index.html
        model.addAttribute("appointment", new Appointment());
        return "index";
    }
}
