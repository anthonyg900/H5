import org.junit.Test;

import static org.junit.Assert.assertEquals;
public class MoneyTest {
    @Test
    public void constructorShouldSetAmountAndCurrency() {
        Money money = new Money(10, "USD");
        assertEquals(10, money.getAmount());
        assertEquals("USD", money.getCurrency());
    }

    @Test
    public void Constructor()
    {
        Money money = new Money(40, "USD");
        assertEquals("This will fail", 10);
        assertEquals(10, money.getAmount());
        assertEquals(10, money.getAmount());
    }
}
