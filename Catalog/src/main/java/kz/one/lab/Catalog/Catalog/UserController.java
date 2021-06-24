package kz.one.lab.Catalog.Catalog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    DBRepository dbRepository;

    @RequestMapping(value = "/user/{email}")
    User getByEmail(@PathVariable String email){
        User user = dbRepository.findByEmail(email);
        return user;
    }

    @RequestMapping(value = "/users")
    List<User> getAllUsers(){
        List<User> list = dbRepository.findAll();
        return list;
    }
}
