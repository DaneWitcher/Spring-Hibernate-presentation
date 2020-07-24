package usergroup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import usergroup.service.UserService;
import usergroup.model.User;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

//    @Autowired
//    public UserController(UserService service) {
//        this.service = service;
//    }
//
//    @Autowired
//    public void setService(UserService service) {
//        this.service = service;
//    }

    @GetMapping
    public List<User> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/{id}")
    public User findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @PostMapping(value = "/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody User user) {
        service.create(user);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable( "id" ) Long id, @RequestBody User user) {
        service.findById(id);
        service.update(user);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        service.deleteById(id);
    }
}
