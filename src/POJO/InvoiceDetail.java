package POJO;

import annotations.InvoiceFieldName;

public class InvoiceDetail {

    @InvoiceFieldName("发票编号")
    private String invoiceNo;
    @InvoiceFieldName("发票金额")
    private String invoiceAmount;

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public String getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(String invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    interface MyEntry {
        void doNothing();
    }
}
