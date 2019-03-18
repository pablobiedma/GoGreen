package client.groupxii.vegetarianmeal;

import org.junit.Test;

import java.io.IOException;

import static junit.framework.TestCase.assertEquals;

public class SafeMealTest {

    private SafeMeal safeMeal = new SafeMeal();

    @Test
    public void safeMeal() throws IOException {
        assertEquals(":0}", safeMeal.safeMeal("APPLES", "BANANAS", 50, 50).substring(299, 302));
    }
}
