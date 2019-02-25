package client;

import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.constraints.AssertTrue;
import static org.junit.Assert.*;

public class MainTest {

    @BeforeClass
    public static void StartClient(){
        String[] arguments = new String[] {"123"};
        server.ServerApplication.main(arguments);
        Main.main(arguments);
    }
}