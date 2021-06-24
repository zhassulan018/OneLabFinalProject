package client;

import model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "eureka-service")
public interface CatalogFeign {
        @RequestMapping(method = RequestMethod.GET, value = "/users", consumes = "application/json")
        List<User> findAll();

        @RequestMapping(method = RequestMethod.GET,value = "/user/{email}",consumes = "application/json")
        User findByEmail( @PathVariable("email") String email);
}
