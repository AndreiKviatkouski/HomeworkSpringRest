package tms.c32.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tms.c32.entity.User;
import tms.c32.resources.UserResource;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserRestController {
    @Autowired
    private List<User> userList;
    @Autowired
    UserResource userResource;


    @PostMapping(path = "/reg")
    public ResponseEntity<String> reg(User user) {
        userResource.save(user);
        return new ResponseEntity<>("Registration is successful", HttpStatus.BAD_REQUEST);
    }


    @PostMapping(path = "/auth")
    public ResponseEntity<String> auth(User user, HttpSession httpSession) {
        User userByLogin = userResource.getUserByLogin(user.getPassword());
        if (userByLogin.getPassword().equals(user.getPassword())) {
            httpSession.setAttribute("user", userByLogin);
            httpSession.setAttribute("checkAuth", true);
            userList.add(userByLogin);
            return new ResponseEntity<>("Hi" + userByLogin, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>("Invalid authorization!", HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping(path = "/logout")
    public ResponseEntity<String>logout(HttpSession httpSession) {
        httpSession.invalidate();
        return new ResponseEntity<>("Bye!", HttpStatus.BAD_REQUEST);
    }
}