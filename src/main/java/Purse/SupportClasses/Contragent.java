package Purse.SupportClasses;

public class Contragent {

    private String name;

    public Contragent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        if (!name.isEmpty()) {
            this.name = name;
        }

    }

}
