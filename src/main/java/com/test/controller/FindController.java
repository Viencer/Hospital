package com.test.controller;

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


@Controller
public class FindController {

    private static Logger logger = Logger.getLogger(FindController.class);

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


    //PERSONAL FIND
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/findP")
    public ModelAndView findPersonal(ModelAndView model) {
        model.setViewName("findByPersonal");
        logger.debug("call find controller");
        return model;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/findByName", method = RequestMethod.POST)
    public ModelAndView findPersById(ModelAndView model, @RequestParam("lastName") String lastName) {
        model.addObject("listPersonal", userServicePersonal.findByLastName(lastName));
        model.setViewName("findByPersonal");
        logger.debug("call find controller with name " + lastName);
        return model;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/findById", method = RequestMethod.POST)
    public ModelAndView findPersById(ModelAndView model, @RequestParam("id") int id) {
        model.addObject("listPersonal", userServicePersonal.getByIdPersonalList(id));
        model.setViewName("findByPersonal");
        logger.debug("call find controller with id " + id);
        return model;
    }

    //PATIENT FIND
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_DOCTOR')")
    @RequestMapping(value = "/findPatient")
    public ModelAndView findPatient(ModelAndView model) {
        model.setViewName("findByPatient");
        logger.debug("call find controller");
        return model;
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_DOCTOR')")
    @RequestMapping(value = "/findPatByName", method = RequestMethod.POST)
    public ModelAndView findPatById(ModelAndView model, @RequestParam("lastName") String lastName) {
        model.addObject("listPatient", userServicePatient.findByLastNamePatient(lastName));
        model.setViewName("findByPatient");
        logger.debug("call find controller with name " + lastName);
        return model;
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_DOCTOR')")
    @RequestMapping(value = "/findPatById", method = RequestMethod.POST)
    public ModelAndView findPatById(ModelAndView model, @RequestParam("id") int id) {
        model.addObject("listPatient", userServicePatient.getByIdPatientList(id));
        model.setViewName("findByPatient");
        logger.debug("call find controller with id " + id);
        return model;
    }
}
