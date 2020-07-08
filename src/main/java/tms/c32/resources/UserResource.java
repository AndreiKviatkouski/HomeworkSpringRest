package tms.c32.resources;


import org.springframework.stereotype.Service;
import tms.c32.entity.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserResource {

    private List<User> users = new ArrayList<>();

    public void save(User user){
        users.add(user);
    }

    public User getUserByLogin(String login){
        for (User user : users) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        throw new UserNotFoundException("Authorization error!");
    }
}
