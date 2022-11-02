package lab.lab2.balance;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * bracketsBalance Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>10月 4, 2022</pre>
 */
public class BracketsBalanceTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }


    /**
     * Method: bBalance(String exp)
     */
    @Test
    public void testBBalance() throws Exception {
        bracketsBalance b = new bracketsBalance();
        Assert.assertTrue(b.bBalance("[]"));
        Assert.assertTrue(b.bBalance("[[]]"));
        Assert.assertTrue(b.bBalance("[[[]]]"));
        Assert.assertTrue(b.bBalance("[[[[]]]]"));
        Assert.assertTrue(b.bBalance("[[[[[]]]]]"));
        Assert.assertFalse(b.bBalance("["));
        Assert.assertFalse(b.bBalance("]"));
        Assert.assertFalse(b.bBalance("[]]"));
        Assert.assertFalse(b.bBalance("[[]"));
        Assert.assertFalse(b.bBalance("[[[[]]]"));
        Assert.assertFalse(b.bBalance("[[][][]]]][[[]"));
    }

}

