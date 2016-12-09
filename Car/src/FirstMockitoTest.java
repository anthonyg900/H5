import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.junit.Assert.assertTrue;

public class FirstMockitoTest {
    private Carr myFerrari = mock(Carr.class);

    @Test
    public void testIfCarIsACar() {
        assertTrue(myFerrari instanceof Carr);
    }
}