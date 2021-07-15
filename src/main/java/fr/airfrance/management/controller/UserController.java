package fr.airfrance.management.controller;

import fr.airfrance.management.exception.BusinessException;
import fr.airfrance.management.model.User;
import fr.airfrance.management.repository.UserRepository;
import fr.airfrance.management.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/management")
public class UserController {
    @Autowired
    private UserService service;
    @Autowired
    UserRepository repository;
    final Logger LOGGER= LoggerFactory.getLogger(UserController.class);
    @PostMapping(value = "/user/register")
    public ResponseEntity<User> saveUser(@RequestBody User newUser) throws BusinessException {
        List<User>users=repository.findAll();
        User userRegistered = null;
        for(User user:users){
            if(user.equals(newUser)){
              LOGGER.info("The user is already exist [{}]",newUser);
            }
        }
        userRegistered = service.saveUser(newUser);
        return ResponseEntity.ok().body(userRegistered);
    }

    @GetMapping("/user/find")
    public ResponseEntity<User> findUserDetailsByUsername(@RequestParam(name = "username") String username) throws BusinessException {
        User userFound = null;
        if (username != null) {
            userFound = service.findUserDetailsByUsername(username);
        }
        if (userFound == null) {
            LOGGER.info("The user is already exist [{}]",username);
            throw new BusinessException("The user with this username is not found",HttpStatus.INTERNAL_SERVER_ERROR, username);
        }
        return ResponseEntity.ok().body(userFound);
    }

}
