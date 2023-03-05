import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.example.Main.getParseLine;
import static org.example.Main.trim;

public class ParseTextTest {
    @Test
    void parseLineTest(){
       String string ="\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"";
       String expected="Студент Иванов получил 5 по предмету Математика";
       String actual =getParseLine(string);
        Assertions.assertEquals(actual,expected);

    }
    @Test
    void trimTest(){
        String string ="!someText!";
        String expected="someText";
        String actual=trim(string);
        Assertions.assertEquals(actual,expected);
    }
}
