package co.edu.escuelaing.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import co.edu.escuelaing.entities.User;
import co.edu.escuelaing.service.UserService;

@Service
public class UserServiceHashMap implements UserService {

    private HashMap<String, User> userMap = new HashMap<>();

    @Override
    public User create(User user) {
        if (userMap.containsKey(user.getId())) {
            return null;
        }
        userMap.put(user.getId(), user);
        return user;
    }

    @Override
    public User findById(String id) {
        return userMap.get(id);
    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        userMap.values().forEach(users::add);
        return users;
    }

    @Override
    public void deleteById(String id) {
        if (userMap.containsKey(id)) {
            userMap.remove(id);
        }
    }

    @Override
    public User update(User user, String userId) {
        if (!userMap.containsKey(userId)) {
            return null;
        }
        deleteById(userId);
        return create(user);
    }

}
