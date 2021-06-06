package Purse;

public class Arrival extends Document{

    private Contragent payer;
    private ActionType type;

    public Arrival(ActionType type, Contragent payer, int sum) {

        super(sum);

        this.payer  = payer;
        this.type   = type;

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
