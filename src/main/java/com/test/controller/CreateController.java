package com.test.controller;

import com.test.model.Patient;
import com.test.model.Personal;
import com.test.service.UserServiceOtherTables;
import com.test.service.UserServicePatient;
import com.test.service.UserServicePersonal;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class CreateController {
    private static Logger logger = Logger.getLogger(CreateController.class);

    private UserServicePatient userServicePatient;

    @Autowired
    public void setUserServicePatient(UserServicePatient userServicePatient) {
        this.userServicePatient = userServicePatient;
    }

    private UserServiceOtherTables userServiceOtherTables;

    @Autowired
    public void setUserServiceOtherTables(UserServiceOtherTables userServiceOtherTables) {
        this.userServiceOtherTables = userServiceOtherTables;
    }


    private UserServicePersonal userServicePersonal;

    @Autowired
    public void setUserServicePersonal(UserServicePersonal userServicePersonal) {
        this.userServicePersonal = userServicePersonal;
    }

    //CREATE PERSONAL
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/createNewPersonal")
    public ModelAndView add(ModelAndView model) {
        List<Personal> personals = userServicePersonal.allPersonal();
        List<Patient> patients = userServicePatient.allPatient();
        model.setViewName("create");
        model.addObject("task", 1);
        model.addObject("jobs", userServiceOtherTables.getAllJobs());
        model.addObject("dept", userServiceOtherTables.getAllDepartments());
        model.addObject("patient", patients);
        model.addObject("personal", personals);
        logger.debug("call create controller");
        return model;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/createPersonal", method = RequestMethod.POST)
    public ModelAndView create(ModelAndView model, @RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName,
                               @RequestParam("bossId") int bossId, @RequestParam("com") int premium,
                               @RequestParam("salary") int salary, @RequestParam("jobId") int jobId,
                               @RequestParam("username") String username, @RequestParam("password") String password,
                               @RequestParam("department") int department, @RequestParam("patient") Integer patient) {
        userServicePersonal.createPersonal(firstName, lastName, bossId, premium, salary, jobId, department, patient, username, password);
        model.addObject("msg", "personal added" + bossId);
        model.setViewName("create");
        logger.debug("call create controller with param");
        return model;
    }

    //CREATE PATIENT
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_DOCTOR')")
    @RequestMapping(value = "/createNewPatient")
    public ModelAndView addPatient(ModelAndView model) {
        model.setViewName("create");
        model.addObject("task", 2);
        model.addObject("diagnos", userServiceOtherTables.getAllDiagnosis());
        model.addObject("medicine", userServiceOtherTables.getAllMedicines());
        logger.debug("call create controller");
        return model;
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_DOCTOR')")
    @RequestMapping(value = "/createPatient", method = RequestMethod.POST)
    public ModelAndView createPatient(ModelAndView model, @RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName,
                                      @RequestParam("position") String position, @RequestParam("phone") int phone,
                                      @RequestParam("address") String address, @RequestParam("diagnosisId") int diagnosisId,
                                      @RequestParam("medicineId") int medicineId) {
        userServicePatient.createPatient(firstName, lastName, position, phone, address, diagnosisId, medicineId);
        model.addObject("msg", "patient added");
        model.setViewName("create");
        logger.debug("call create controller with param");
        return model;
    }

}
