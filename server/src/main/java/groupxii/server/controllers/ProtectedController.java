package groupxii.server.controllers;

import groupxii.database.Database;
import groupxii.database.VehicleEntry;
import groupxii.server.Transportation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class ProtectedController {

    @RequestMapping(method = RequestMethod.GET, value = "/protected")
    public String protectedEndpoint (Principal principal) {
        return "Hello, "+principal.getName()+"!";
    }
}
