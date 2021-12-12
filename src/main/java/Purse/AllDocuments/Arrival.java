package Purse.AllDocuments;

import Purse.SupportClasses.ActionType;
import Purse.SupportClasses.Contragent;

import java.util.Date;

public class Arrival extends Document {

    private Contragent payer;
    private ActionType type;

    public Arrival(ActionType type, Contragent payer, int sum) {

        super(sum);

        this.payer  = payer;
        this.type   = type;

    }

    @Override
    public String toString() {
        return "Поступление номер " + this.getNumber()
                + " на сумму " + this.getSum()
                + " от " + this.getDocDate();
    }

    public Contragent getPayer() {
        return payer;
    }

    public void setPayer(Contragent payer) {

        if (payer != null) {
            this.payer = payer;
        }

    }

    public ActionType getType() {
        return type;
    }

    public void setType(ActionType type) {

        if (type.equals(ActionType.ARRIVAL)) {
            this.type = type;
        }

    }
}
