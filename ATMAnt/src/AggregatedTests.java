import org.junit.Assert;
import org.junit.Test;

//J-Unit Tests
public class AggregatedTests {

    @Test
    public void testTripple() {

        Triple tri1 = new Triple(2, "ayy", "lmao");
        Assert.assertEquals(2, tri1.getLeft());
        Assert.assertEquals("ayy", tri1.getMiddle());
        Assert.assertEquals("lmao", tri1.getRight());
    }

    @Test
    public void testTripple2() {

        Triple tri2 = new Triple(668, true, "perfect");
        Assert.assertEquals(668, tri2.getLeft());
        Assert.assertEquals(true, tri2.getMiddle());
        Assert.assertEquals("perfect", tri2.getRight());
    }

    @Test
    public void testTripple3() {

        Triple tri3 = new Triple(true, false, true);
        Assert.assertEquals(2, tri3.getLeft());
        Assert.assertEquals(4, tri3.getMiddle());
        Assert.assertEquals(true, tri3.getRight());
    }
}