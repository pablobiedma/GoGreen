package groupxii.server;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Response {

    public @ResponseBody String response() {
        return "Hello ";
    }
}
