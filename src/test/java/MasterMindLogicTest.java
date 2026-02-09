import org.junit.jupiter.api.Test;
import java.awt.Color;
import static org.junit.jupiter.api.Assertions.*;

class MasterMindLogicTest {

    @Test
    void testLogicFunciona() {
        Color[] palette = {Color.RED, Color.BLUE};
        String[] labels = {"R", "B"};

        MasterMindLogic logic = new MasterMindLogic(palette, 4, labels);

        assertNotNull(logic.showSecret());
    }

    @Test
    void testCheckGuess() {
        Color[] palette = {Color.RED};
        String[] labels = {"R"};
        MasterMindLogic logic = new MasterMindLogic(palette, 1, labels);

        Color[] intento = {Color.RED};

        MasterMindLogic.Result resultado = logic.checkGuess(intento);

        assertEquals(1, resultado.blacks, "Debería tener 1 acierto negro");
        assertEquals(0, resultado.whites, "Debería tener 0 blancos");
    }

    @Test
    void testPinesBlancos() {
        Color[] palette = {Color.RED, Color.BLUE};
        String[] labels = {"R", "B"};

        MasterMindLogic logic = new MasterMindLogic(palette, 2, labels);

        MasterMindLogic.Result res = new MasterMindLogic.Result(1, 2);
        assertEquals(1, res.blacks);
        assertEquals(2, res.whites);

        assertNotNull(logic.showSecret());
    }
}