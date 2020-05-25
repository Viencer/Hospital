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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UpdateController {

    private static Logger logger = Logger.getLogger(UpdateController.class);

    private UserServicePersonal userServicePersonal;

    @Autowired
    public void setUserServicePersonal(UserServicePersonal userServicePersonal) {
        this.userServicePersonal = userServicePersonal;
    }

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


    ////UPDATE PERSONAL
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/update/{personalId}")
    public ModelAndView findById(ModelAndView model, @PathVariable("personalId") int personalId) {
        List<Personal> personals = userServicePersonal.allPersonal();
        List<Patient> patients = userServicePatient.allPatient();
        model.addObject("Personal", userServicePersonal.getByIdPersonal(personalId));
        model.addObject("jobs", userServiceOtherTables.getAllJobs());
        model.addObject("dept", userServiceOtherTables.getAllDepartments());
        model.addObject("patient", patients);
        model.addObject("personals", personals);
        model.addObject("task", 1);
        model.setViewName("update");
        logger.debug("called update controller with id to update: " + personalId);
        return model;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/updateP", method = RequestMethod.POST)
    public ModelAndView update(ModelAndView model, @RequestParam("id") int id, @RequestParam("lastName") String lastName,
                               @RequestParam("bossId") int bossId, @RequestParam("com") int com,
                               @RequestParam("salary") int salary, @RequestParam("jobId") int jobId,
                               @RequestParam("department") int department, @RequestParam("patient") Integer patient) {
        userServicePersonal.updatePersonal(id, lastName, bossId, com, salary, jobId, department, patient);
        model.addObject("msg", "personal updated");
        model.setViewName("update");
        logger.debug("called update controller with param");
        return model;
    }

    ////UPDATE PATIENT
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_DOCTOR')")
    @RequestMapping(value = "/updatePatient/{patientId}")
    public ModelAndView findByIdPatient(ModelAndView model, @PathVariable("patientId") int patientId) {
        model.addObject("diagnos", userServiceOtherTables.getAllDiagnosis());
        model.addObject("medicine", userServiceOtherTables.getAllMedicines());
        model.addObject("Patient", userServicePatient.getByIdPatient(patientId));
        model.addObject("task", 2);
        model.setViewName("update");
        logger.debug("called update controller with id to update: " + patientId);
        return model;
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_DOCTOR')")
    @RequestMapping(value = "/updatePatient", method = RequestMethod.POST)
    public ModelAndView updatePatient(ModelAndView model, @RequestParam("id") int id,
                                      @RequestParam("diagnosisId") int diagnosisId, @RequestParam("medicineId") int medicineId) {
        userServicePatient.updatePatient(id, diagnosisId, medicineId);
        model.addObject("msg", "patient updated");
        model.setViewName("update");
        logger.debug("called update controller with param");
        return model;
    }
}
