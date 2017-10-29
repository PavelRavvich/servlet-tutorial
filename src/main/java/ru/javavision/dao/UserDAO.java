package ru.javavision.dao;

import ru.javavision.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Author : Pavel Ravvich.
 * Created : 29/10/2017.
 * <p>
 * UserDAO
 */
public class UserDAO {

    private final List<User> store = new ArrayList<>();

    public User getById(int id) {

        User result = new User();
        result.setId(-1);

        for (User user : store) {
            if (user.getId() == id) {
                result = user;
            }
        }

        return result;
    }

    public User getUserByLoginPassword(final String login, final String password) {

        User result = new User();
        result.setId(-1);

        for (User user : store) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                result = user;
            }
        }

        return result;
    }

    public boolean add(final User user) {

        for (User u : store) {
            if (u.getLogin().equals(user.getLogin()) && u.getPassword().equals(user.getPassword())) {
                return false;
            }
        }

        return store.add(user);
    }

    public User.ROLE getRoleByLoginPassword(final String login, final String password) {
        User.ROLE result = User.ROLE.UNKNOWN;

        for (User user : store) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                result = user.getRole();
            }
        }

        return result;
    }

    public boolean userIsExist(final String login, final String password) {

        boolean result = false;

        for (User user : store) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                result = true;
                break;
            }
        }

        return result;
    }
}
