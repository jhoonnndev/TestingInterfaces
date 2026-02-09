import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.swing.*;
import java.awt.*;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MasterMindUITest {

    @BeforeEach
    void setup() {
        System.setProperty("java.awt.headless", "true");
    }

    @Test
    void testFlujoCompletoDeJuego() {
        Color[] col = {Color.RED, Color.BLUE};
        String[] lab = {"R", "B"};
        MasterMindLogic logicMock = mock(MasterMindLogic.class);

        //  Mock
        when(logicMock.checkGuess(any())).thenReturn(new MasterMindLogic.Result(4,0));

        MasterMindUI ui = new MasterMindUI(col, lab, 10, logicMock);

        List<JButton> botonesColores = ui.getColorButtons();
        botonesColores.get(0).doClick();


        MasterMindUI.Circle[] fila1 = ui.getGuessRows().get(0);

        for (MasterMindUI.Circle circulo : fila1) {
            circulo.doClick();
        }

        ui.getCheckButton().doClick();

        verify(logicMock, times(1)).checkGuess(any());

    }

    @Test
    void testCircleDirectamente() {

        MasterMindUI.Circle circulo = new MasterMindUI.Circle(Color.BLACK, 10, true);

        circulo.setCircleColor(Color.WHITE);
        assertEquals(Color.WHITE, circulo.getColor());

        java.awt.image.BufferedImage img = new java.awt.image.BufferedImage(1,1,1);
        circulo.paintComponent(img.getGraphics());
    }
}