package fr.airfrance.management.service;

import fr.airfrance.management.exception.BusinessException;
import fr.airfrance.management.model.User;

public interface UserService {
    User saveUser(User user) throws BusinessException;

    User findUserDetailsByUsername(String username) throws BusinessException;
}
