package com.test.controller;

import com.test.service.UserServicePatient;
import com.test.service.UserServicePersonal;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DeleteController {

    private static Logger logger = Logger.getLogger(DeleteController.class);

    private UserServicePatient userServicePatient;

    @Autowired
    public void setUserServicePatient(UserServicePatient userServicePatient) {
        this.userServicePatient = userServicePatient;
    }

    private UserServicePersonal userServicePersonal;

    @Autowired
    public void setUserServicePersonal(UserServicePersonal userServicePersonal) {
        this.userServicePersonal = userServicePersonal;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/delete/{personalId}")
    public ModelAndView delete(ModelAndView model, @PathVariable("personalId") int personalId) {
        userServicePersonal.deletePersonal(personalId);
        model.setViewName("delete");
        logger.debug("call delete controller with delete id: " + personalId);
        return model;
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @RequestMapping(value = "/deletePatient/{patientId}")
    public ModelAndView deletePatient(ModelAndView model, @PathVariable("patientId") int patientId) {
        userServicePatient.deletePatient(patientId);
        model.setViewName("delete");
        logger.debug("call delete controller with delete id: " + patientId);
        return model;
    }

}
