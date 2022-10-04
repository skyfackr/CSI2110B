package lab.lab2.balance;



import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runners.JUnit4;
import org.junit.Assert;


import java.util.ArrayList;

/**
 * bracketsBalance Tester.
 *
 * @author <Authors name>
 * @since <pre>10月 4, 2022</pre>
 * @version 1.0
 */
public class BracketsBalanceTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }



    /**
     *
     * Method: bBalance(String exp)
     *
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

