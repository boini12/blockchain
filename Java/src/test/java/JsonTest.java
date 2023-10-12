import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class JsonTest {

    @Test
    public void getNameFromJson_correctJson_outputCorrect(){
        // given
        String input = "{\"name\": \"Ines\"}";

        // when
        String output = Main.getNameFromJson(input);

        // then
        Assertions.assertEquals("Ines", output);
    }

    @Test
    public void getNameFromJson_jsonWithoutName_throwsIllegalArgumentExceptions(){
        // given
        String input = "{\"test\": \"Ines\"}";

        // then
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Main.getNameFromJson(input);
        });

        Assertions.assertEquals("JSON does not contain name", exception.getMessage());
    }

    @Test
    public void getNameFromJson_simpleString_throwsIllegalStateException(){
        // given
        String input = "name";
        String expectedMessage = "Not a JSON Object: \"name\"";

        // then
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            Main.getNameFromJson(input);
        });

        Assertions.assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void getNameFromJson_null_throwsNullPointerException(){
        // given
        String input = null;
        String expectedMessage = "input must not be null";

        // then
        Exception exception = assertThrows(NullPointerException.class, () -> {
            Main.getNameFromJson(input);
        });

        Assertions.assertEquals(expectedMessage, exception.getMessage());
    }
}
