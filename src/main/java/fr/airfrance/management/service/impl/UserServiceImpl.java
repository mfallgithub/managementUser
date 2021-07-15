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
    @Override
    public User saveUser(User user) throws BusinessException {
        User userSaved = null;
        try {
            userSaved = repository.save(user);
        } catch (Exception e) {
            throw new BusinessException(HttpStatus.INTERNAL_SERVER_ERROR, user.getUsername());
        }

        return userSaved;
    }

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
