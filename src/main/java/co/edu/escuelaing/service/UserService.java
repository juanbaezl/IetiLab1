package co.edu.escuelaing.service;

import java.util.Date;
import java.util.List;

import co.edu.escuelaing.entities.User;

public interface UserService {
    User create(User user);

    User findById(String id);

    List<User> getAll();

    void deleteById(String id);

    User update(User user, String userId);

    List<User> findUsersWithNameOrLastNameLike(String queryText);

    List<User> findUsersCreatedAfter(Date startDate);

    User findByEmail(String email);
}
