package groupxii.userschema;

import com.mongodb.DBObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class JsonConverterTest {

    @Test
    public void leaderboardToString() {
        JsonConverter converter = new JsonConverter();
        List<DBObject> list = new ArrayList<>();
        assertEquals(list.toString(),"[" + converter.leaderboardToString(list) + "]");
    }
}