import Purse.ActionType;
import Purse.Arrival;
import Purse.Contragent;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ArrivalTest {

    private static Contragent testContragent;
    private static Arrival testArrival;

    @BeforeClass
    public static void createAllObjectsForTests() {

        testContragent  = new Contragent("TestName");
        testArrival     = new Arrival(ActionType.ARRIVAL, testContragent, 0);

    }

    @Test
    public void arrivalShouldntBeEmpty() {

        testArrival.setPayer(null);
        Assert.assertNotNull(testArrival.getPayer());

    }

    @Test
    public void arrivalShouldHaveTypeArrival() {

        testArrival.setType(ActionType.SPENDING);
        Assert.assertEquals(ActionType.ARRIVAL, testArrival.getType());

    }


}
