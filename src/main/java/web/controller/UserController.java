/*
CREATE TABLE IF NOT EXISTS users (
        id bigint not null,
        firstName varchar(255),
        lastName varchar(255),
        userName varchar(255),
        primary key (id)
        );


        INSERT INTO users (id,firstName, lastName, userName) VALUES
        (31,'Ivan', 'Ivanov', 'Ivanovich'),
        (32,'Petr', 'Petrov', 'Petrovich'),
        (33,'Raj', 'Kumar', 'Hirani');
        */

package web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import web.model.User;
import web.service.UserService;

@Controller
public class UserController {
    private UserService userService;

    public UserController() {
    }

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
    public ModelAndView hello(HttpServletResponse response) throws IOException {
        ModelAndView model = new ModelAndView();
        model.setViewName("homepage");
        return model;
    }

    @RequestMapping(value = "/all-users", method = RequestMethod.GET)
    public ModelAndView viewAllUser() {
        ModelAndView model = new ModelAndView();
        List userList = this.userService.getAllUsers();
        model.addObject("userList", userList);
        model.setViewName("all-users");
        return model;
    }
    @RequestMapping(value = "/all-users", method = RequestMethod.POST)
    public ModelAndView displayAllUser() {
        ModelAndView model = new ModelAndView();
        List userList = this.userService.getAllUsers();
        model.addObject("userList", userList);
        model.setViewName("all-users");
        return model;
    }

    @RequestMapping(value = "/add-user", method = RequestMethod.GET)
    public ModelAndView displayNewUserForm() {
        ModelAndView model = new ModelAndView("add-user");
        model.addObject("headerMessage", "Добавьте пользователя:");
        model.addObject("user", new User());
        return model;
    }
    @RequestMapping(value = "/add-user", method = RequestMethod.POST)
    public ModelAndView saveNewUser(@ModelAttribute User user, BindingResult bindingResult) {
        ModelAndView model = new ModelAndView("redirect:/all-users");
        if (bindingResult.hasErrors()) {
            return new ModelAndView("error");
        }
        boolean saveUser = this.userService.saveUser(user);
        if (saveUser) {
            model.addObject("message", "Новый пользователь успешно добавлен");
        } else {
            return new ModelAndView("error");
        }
        return model;
    }

    @RequestMapping(value = "/edit-user/{id}", method = RequestMethod.GET)
    public ModelAndView displayEditUserForm(@PathVariable Long id) {
        ModelAndView model = new ModelAndView("edit-user");
        User user = this.userService.getUserById(id);
        model.addObject("headerMessage", "Редактирование пользователя");
        model.addObject("user", user);
        return model;
    }
    @RequestMapping(value = "/edit-user/{id}", method = RequestMethod.POST)
    public ModelAndView saveEditedUser(@ModelAttribute User user, BindingResult bindingResult) {
        ModelAndView model = new ModelAndView("redirect:/all-users");
        if (bindingResult.hasErrors()) {
            return new ModelAndView("error");
        }
        boolean saveUser = this.userService.saveUser(user);
        if (!saveUser) {
            return new ModelAndView("error");
        }
        return model;
    }

    @RequestMapping(value = "/delete-user/{id}", method = RequestMethod.GET)
    public ModelAndView deleteUserById(@PathVariable Long id) {
        boolean isDeleted = this.userService.deleteUserById(id);
        ModelAndView model = new ModelAndView("redirect:/all-users");
        return model;
    }

}
