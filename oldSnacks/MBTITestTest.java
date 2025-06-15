import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MBTITestTest {

    @Test
    void testValidAnswersReturnsCorrectType() {
        String answers = "ABABABABABABABABABAB";
        String result = MBTITest.processAnswers(answers);
        assertNotNull(result);
        assertEquals(4, result.length());
    }

    @Test
    void testAllAAnswersReturnsESTJ() {
        String answes = "AAAAAAAAAAAAAAAAAAAA";
        String type = MBTITest.processAnswers(answes);
        assertEquals("ESTJ", type);
    }

    @Test
    void testAllBAnswersReturnsINFP() {
        String answers = "BBBBBBBBBBBBBBBBBBBB";
        String type = MBTITest.processAnswers(answers);
        assertEquals("INFP", type);
    }

      }
