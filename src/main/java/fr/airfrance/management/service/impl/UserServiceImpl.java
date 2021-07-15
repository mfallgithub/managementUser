package fr.airfrance.management.service.impl;

import fr.airfrance.management.controller.UserController;
import fr.airfrance.management.exception.BusinessException;
import fr.airfrance.management.model.User;
import fr.airfrance.management.repository.UserRepository;
import fr.airfrance.management.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;
    final Logger LOGGER= LoggerFactory.getLogger(UserController.class);
    /**
     * implement the method to register a newUser
     * @param newUser
     * */
    @Override
    public User saveUser(User newUser) throws BusinessException {
        User userSaved = null;
        try {
            userSaved = repository.save(newUser);
        } catch (Exception e) {
            throw new BusinessException(HttpStatus.INTERNAL_SERVER_ERROR, newUser.getUsername());
        }

        return userSaved;
    }
    /****
     * Implement the method to find a user by username
     * @param username
     */
    @Override
    public User findUserDetailsByUsername(String username) throws BusinessException {
        User userFound = null;
        try {
            if (username != null) {
                userFound = repository.findUserDetailsByUsername(username);
            }
            return userFound;

        } catch (Exception e) {
            LOGGER.info("The user is already exist [{}]",username);
            throw new BusinessException(HttpStatus.NO_CONTENT, "user not exists");
        }

    }

}
