import Purse.SupportClasses.ActionType;
import Purse.SupportClasses.Contragent;
import Purse.AllDocuments.Spending;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class SpendingTest {

    private static Contragent testContragent;
    private static Spending testSpending;

    @BeforeClass
    public static void createAllObjectsForTests() {

        testContragent  = new Contragent("TestName");
        testSpending     = new Spending(ActionType.SPENDING, testContragent, 0);

    }

    @Test
    public void spendingShouldntBeEmpty() {

        testSpending.setRecipient(null);
        Assert.assertNotNull(testSpending.getRecipient());

    }

    @Test
    public void spendingShouldHaveTypeArrival() {

        testSpending.setType(ActionType.ARRIVAL);
        Assert.assertEquals(ActionType.SPENDING, testSpending.getType());

    }


}
