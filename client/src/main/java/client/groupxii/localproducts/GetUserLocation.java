package client.groupxii.localproducts;

import javax.servlet.http.HttpServletRequest;

public class GetUserLocation {

    public String getClientIpAddress(HttpServletRequest request){
        String ip = request.getHeader("X-FORWARDED-FOR");
        return ip;
    }
}
