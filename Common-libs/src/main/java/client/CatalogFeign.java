package client;

import model.User;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "eureka-service")
public interface CatalogFeign {
        @RequestMapping(method = RequestMethod.GET, value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
        List<User> findAll();

        @RequestMapping(method = RequestMethod.GET,value = "/user/{email}",produces = MediaType.APPLICATION_JSON_VALUE)
        User findByEmail( @PathVariable("email") String email);
}
