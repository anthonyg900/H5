import org.junit.Test;
        import static junit.framework.TestCase.*;
        import static org.mockito.Mockito.mock;

public class MockitoDefaultValuesTest {
    private Carr myFerrari = mock(Carr.class);

    @Test
    public void testDefaultBehaviourOfTestDouble() {
        assertFalse("new test double should return false as boolean", myFerrari.needsFuel());
        assertEquals("new test double should return 0.0 as double", 0.0, myFerrari.getEngineTemperature());
    }
}