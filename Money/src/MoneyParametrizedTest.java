import junitparams.*;
import org.junit.Test;
import org.junit.runner.*;

import static junit.framework.TestCase.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class MoneyParametrizedTest {
    private static final Object[] getMoney() {
        return new Object[]{
                new Object[]{10, "USD"},
                new Object[]{20, "EUR"}
        };
    }

    @Test
    @Parameters(method = "getMoney")
    public void constructorShouldSetAmountAndCurrency(
            int amount, String currency) {
        Money money = new Money(amount, currency);
        assertEquals(amount, money.getAmount());
        assertEquals(currency, money.getCurrency());
    }

        @Test
        @Parameters(method = "getMoney")
        public void test3(
                int amount, String currency) {
            Money money = new Money(amount, currency);
            assertEquals(amount, money.getAmount());
            assertEquals(currency, money.getCurrency());
        }
    @Test
    @Parameters(method = "getMoney")
    public void test4(
            int amount, String currency) {
        Money money = new Money(amount, currency);
        assertEquals(amount, money.getAmount());
        assertEquals(currency, money.getCurrency());
    }
    @Test
    @Parameters(method = "fail")
    public void test5(
            int amount, String currency) {
        Money money = new Money(amount, currency);
        assertEquals(amount, money.getAmount());
        assertEquals(currency, money.getCurrency());
    }
    }
