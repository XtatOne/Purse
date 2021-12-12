package Purse.AllDocuments;

import Purse.SupportClasses.ActionType;
import Purse.SupportClasses.Contragent;

public class Spending extends Document {

    private Contragent recipient;
    private ActionType type;

    public Spending(ActionType type, Contragent recipient, int sum) {

        super(sum);

        this.recipient  = recipient;
        this.type       = type;

    }

    @Override
    public String toString() {
        return "Списание номер " + this.getNumber()
                + " на сумму " + this.getSum()
                + " от " + this.getDocDate();
    }

    public Contragent getRecipient() {
        return recipient;
    }

    public void setRecipient(Contragent recipient) {

        if (recipient != null) {
            this.recipient = recipient;
        }

    }

    public ActionType getType() {
        return type;
    }

    public void setType(ActionType type) {

        if (type.equals(ActionType.SPENDING)) {
            this.type = type;
        }
    }
}
