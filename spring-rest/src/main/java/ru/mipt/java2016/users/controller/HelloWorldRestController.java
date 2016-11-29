package ru.mipt.java2016.users.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import ru.mipt.java2016.users.model.User;
import ru.mipt.java2016.users.service.UserService;

@RestController
@RequestMapping("/user")
public class HelloWorldRestController {
    @Autowired
    private UserService userService;

    private static final Logger logger =
            LoggerFactory.getLogger(HelloWorldRestController.class.getName());

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> listAllUsers() {
        logger.info("Fetching all users ");

        List<User> users = userService.findAllUsers();
        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public User getUser(@PathVariable("id") long id) {
        logger.info("Fetching User with id " + id);
        User user = userService.findById(id);
        if (user == null) {
            logger.error("User with id " + id + " not found");
            throw new UserNotFoundException(id);
        }
        return user;
    }


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
        logger.info("Creating User " + user.getName());

        if (userService.isUserExist(user)) {
            logger.info("A User with name " + user.getName() + " already exist");
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        userService.saveUser(user);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public User updateUser(@PathVariable("id") long id, @RequestBody User user) {
        logger.info("Updating User " + id);

        User currentUser = userService.findById(id);

        if (currentUser == null) {
            logger.error("User with id " + id + " not found");
            throw new UserNotFoundException(id);
        }

        currentUser.setName(user.getName());
        currentUser.setAge(user.getAge());
        currentUser.setSalary(user.getSalary());

        userService.updateUser(currentUser);
        return currentUser;
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUser(@PathVariable("id") long id) {
        logger.info("Fetching & Deleting User with id " + id);

        User user = userService.findById(id);
        if (user == null) {
            logger.error("Unable to delete. User with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        userService.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteAllUsers() {
        logger.info("Deleting All Users");

        userService.deleteAllUsers();
    }


    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Error spittleNotFound(UserNotFoundException e) {
        long userId = e.getUserId();
        return new Error(4, "User [" + userId + "] not found");
    }
}