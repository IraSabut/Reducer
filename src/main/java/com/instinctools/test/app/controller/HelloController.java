package com.instinctools.test.app.controller;

import com.instinctools.test.app.repository.entity.AlertEntity;
import com.instinctools.test.app.repository.entity.TagEntity;
import com.instinctools.test.app.repository.entity.UserEntity;
import com.instinctools.test.domain.model.Alert;
import com.instinctools.test.domain.service.AlertService;
import com.instinctools.test.domain.service.TagService;
import com.instinctools.test.domain.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HelloController {

    private UserService userService;
    private TagService tagService;
    private AlertService alertService;

    protected static Logger logger = Logger.getLogger("controller");

@Autowired
    public HelloController(UserService userService,TagService tagService ,AlertService alertService) {
    this.userService=userService;
    this.tagService=tagService;
    this.alertService=alertService;
    }

   @RequestMapping(value = "/",method = RequestMethod.GET)
    public String signup(Model model) {
        List<AlertEntity> alert= this.alertService.getAlerts();
        model.addAttribute("alerts", alert);
        return "signup";
    }


    @RequestMapping(value = "/tag",method = RequestMethod.GET)
    public String getTags(Model model) {
        List<TagEntity> tag= this.tagService.getTags();
          model.addAttribute("tags", tag);
        return "tag";
    }



    @RequestMapping(value ="/getAlert{id}", method = RequestMethod.GET)
    public String getAlert(@PathVariable Long id,Model model) {
        AlertEntity alert =  this.alertService.getAlertByID(id);
        model.addAttribute("alertById", alert);
        return "alertById";
    }


    @RequestMapping(value = "/profil{username}",method = RequestMethod.GET)
    public String getProfile(@PathVariable String username,String password, Model model) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String sUserName=userDetails.getUsername();
        List <AlertEntity> alertEntities =this.alertService.getAlertsByUserName(sUserName);
        model.addAttribute("alertUserEntities", alertEntities);
        return "profil";
    }

  @RequestMapping(value = "/addUser",method = RequestMethod.GET)
  public String addNewUser(Model model) {
      model.addAttribute("user", new UserEntity());
      return "registrationUser";
  }


}