package Purse;

public abstract class Document implements DocumentOperations {

    private static int globalNumber;
    private int number;
    private int sum;

    public Document(int sum) {

        this.number = ++globalNumber;
        this.sum    = sum;

    }

    public int getSum() {
        return sum;
    }

}
