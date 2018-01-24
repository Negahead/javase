package POJO;

import annotations.InvoiceFieldName;

public class InvoiceDetail {

    public InvoiceDetail() {
    }

    public InvoiceDetail(int detailId, String invoiceNo, String invoiceAmount) {
        this.detailId = detailId;
        this.invoiceNo = invoiceNo;
        this.invoiceAmount = invoiceAmount;
    }

    private int detailId;
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

    public int getDetailId() {
        return detailId;
    }

    public void setDetailId(int detailId) {
        this.detailId = detailId;
    }

    @Override
    public String toString() {
        return "InvoiceDetail{" +
                "detailId=" + detailId +
                ", invoiceNo='" + invoiceNo + '\'' +
                ", invoiceAmount='" + invoiceAmount + '\'' +
                '}';
    }
}
