package com.instinctools.test.app.controller;

import com.instinctools.test.app.repository.entity.AlertEntity;
import com.instinctools.test.app.repository.entity.TagEntity;
import com.instinctools.test.app.repository.entity.UserEntity;
import com.instinctools.test.domain.model.Role;
import com.instinctools.test.domain.model.User;
import com.instinctools.test.domain.service.TagService;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import com.instinctools.test.app.repository.entity.validation.UserValidator;

import com.instinctools.test.domain.service.AlertService;
import com.instinctools.test.domain.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Controller
@RequestMapping("/signup")
public class SignupController {
    @Autowired
    private UserValidator signupValidator;
    private UserService userService;
    private AlertService alertService;
    private TagService tagService;

    @Autowired
    public SignupController(UserService userService, AlertService alertService, TagService tagService) {
        this.userService = userService;
        this.alertService = alertService;
        this.tagService = tagService;
    }

    protected static Logger logger = Logger.getLogger("controller");
   


    @RequestMapping(value = "/addTag", method = RequestMethod.GET)
    public String getAddTag(Model model) {
        logger.debug("Received request to show add page");
        model.addAttribute("tag", new TagEntity());
        return "tags";
    }

    @RequestMapping(value = "/addTag", method = RequestMethod.POST)
    public String addNewTagPost(@ModelAttribute("tag") TagEntity tag, BindingResult results) {
        this.tagService.save(tag);
        logger.debug("Received request to add new user");
        return "signup.jsp";
    }

    @RequestMapping(value = "/addAlert", method = RequestMethod.GET)
    public String getAddAlert(Model model) {
        logger.debug("Received request to show add page");
        model.addAttribute("alert", new AlertEntity());
        return "alerts";
    }


    @RequestMapping(value = "/addAlert", method = RequestMethod.POST)
    public String addNewAlertUserPost(@ModelAttribute("alert") AlertEntity alert, Model model, BindingResult results) {
        TagEntity tagEntity = alert.getTagEntity();
        String sTagName = alert.getTagEntity().getTagName();
        UserEntity userEntity = alert.getUserEntity();
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String sUserName = userDetails.getUsername();
        String sUserPassword = userDetails.getPassword();
        userEntity.setUsername(sUserName);
        userEntity.setPassword(sUserPassword);
        UserEntity userEntity1 = this.userService.loadUserByCredentials(sUserName, sUserPassword);
        TagEntity tagEntity1 = this.tagService.getTagByName(sTagName);
        if (tagEntity1 != null)
            alert.setTagEntity(tagEntity1);
        else this.tagService.save(tagEntity);
        alert.setUserEntity(userEntity1);
        this.alertService.save(alert);
        List<AlertEntity> alert1 = this.alertService.getAlerts();
        model.addAttribute("alerts", alert1);
        logger.debug("Received request to add new user");
        return "signup";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public String getAdd(Model model) {
        logger.debug("Received request to show add page");
        model.addAttribute("user", new UserEntity());
        return "registrationUser";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addNewUserPost(@ModelAttribute("user") UserEntity user, Model model, BindingResult results) {
        user.setIdRole(Role.USER);
        this.userService.save(user);
        List<AlertEntity> alert = this.alertService.getAlerts();
        model.addAttribute("alerts", alert);
        logger.debug("Received request to add new user");
        return "signup";
    }

    @RequestMapping(value = "/tagByName/{tagName}", method = RequestMethod.GET)
    public String getAlertByTag(@PathVariable String tagName, Model model) {
        List<AlertEntity> alertEntities = this.alertService.getAlertsByTagName(tagName);
        model.addAttribute("alertEntities", alertEntities);
        return "tagByName";
    }


}
