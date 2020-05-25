package com.test.controller;

import com.test.service.UserServiceOtherTables;
import com.test.service.UserServicePersonal;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OtherTablesController {

    private static Logger logger = Logger.getLogger(OtherTablesController.class);

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


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/getDepartment", method = RequestMethod.GET)
    public ModelAndView getDepartment(ModelAndView model) {
        model.addObject("listDepartments", userServiceOtherTables.getAllDepartments());
        model.addObject("task", 1);
        model.setViewName("otherTable");
        logger.debug("call getDepartment page");
        return model;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/getJobs", method = RequestMethod.GET)
    public ModelAndView getJobs(ModelAndView model) {
        model.addObject("listJobs", userServiceOtherTables.getAllJobs());
        model.addObject("task", 2);
        model.setViewName("otherTable");
        logger.debug("call getDepartment page");
        return model;
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_DOCTOR', 'ROLE_INTERN')")
    @RequestMapping(value = "/getDiagnosis", method = RequestMethod.GET)
    public ModelAndView getDiagnosis(ModelAndView model) {
        model.addObject("listDiagnosis", userServiceOtherTables.getAllDiagnosis());
        model.addObject("task", 3);
        model.setViewName("otherTable");
        logger.debug("call getDiagnosis page");
        return model;
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_DOCTOR', 'ROLE_INTERN')")
    @RequestMapping(value = "/getMedicine", method = RequestMethod.GET)
    public ModelAndView getMedicine(ModelAndView model) {
        model.addObject("listMedicine", userServiceOtherTables.getAllMedicines());
        model.addObject("task", 4);
        model.setViewName("otherTable");
        logger.debug("call getMedicine page");
        return model;
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_DOCTOR', 'ROLE_INTERN')")
    @RequestMapping(value = "/getTreatment", method = RequestMethod.GET)
    public ModelAndView getTreatment(ModelAndView model) {
        model.addObject("listTreatment", userServiceOtherTables.getAllTreatments());
        model.addObject("task", 5);
        model.setViewName("otherTable");
        logger.debug("call getTreatment page");
        return model;
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_DOCTOR', 'ROLE_INTERN')")
    @RequestMapping(value = "/getBoss", method = RequestMethod.POST)
    public ModelAndView getBoss(ModelAndView model, @RequestParam("idB") int idB, @RequestParam("idP") int idP) {
        if (idB == 0) {
            model.addObject("task", 1);
            model.addObject("task2", 3);
            model.addObject("listPerson", userServicePersonal.getByIdPersonal(idP));
        } else {
            model.addObject("listPerson", userServicePersonal.getByIdPersonal(idB));
            model.addObject("task2", 2);
        }
        model.setViewName("lookAtBoss");
        logger.debug("call getBoss page");
        return model;
    }
}
