package Purse.AllDocuments;

import java.util.Date;

public abstract class Document implements DocumentOperations, Comparable<Document> {

    private static int globalNumber;
    private int number;
    private int sum;
    private Date docDate;

    public Document(int sum) {

        this.number     = ++globalNumber;
        this.sum        = sum;
        this.docDate    = new Date();

    }

    @Override
    public int compareTo(Document document) {

        if (this.docDate.after(document.docDate)) {
            return 1;
        } else if (this.docDate.before(document.docDate)) {
            return -1;
        } else {
            return 0;
        }

    }

    public int getNumber() {
        return number;
    }

    public Date getDocDate() {
        return docDate;
    }

    public int getSum() {
        return sum;
    }

}
