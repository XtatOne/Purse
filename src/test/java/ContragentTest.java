import Purse.SupportClasses.Contragent;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ContragentTest {

    private static Contragent contragent;

    @BeforeClass
    public static void createNewContragent() {
        contragent = new Contragent("TestName");
    }

    @Test
    public void nameShouldtBeEmpty() {

        contragent.setName("");
        Assert.assertFalse(contragent.getName().isEmpty());

    }

}
