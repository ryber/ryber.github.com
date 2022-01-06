package ryber.generator;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArticleTest {

    @Test
    void name() {
        DateTime dt = new DateTime(2011, 4, 19, 0, 0);

        System.out.println("dt = " + DateTimeFormat.mediumDate().print(dt));
    }
}