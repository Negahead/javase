package POJO;

import annotations.InvoiceFieldName;

import java.util.List;

public class InvoiceInfo {

    @InvoiceFieldName("开票日期")
    private String makeDate;
    @InvoiceFieldName("计划付款日期")
    private String planPayDate;
    @InvoiceFieldName("实际付款日期")
    private String payDate;
    @InvoiceFieldName("计划提交财务日期")
    private String planSubmitDate;
    @InvoiceFieldName("实际提交财务日期")
    private String submitDate;

    private List<InvoiceDetail> invoiceDetailList;

    public String getMakeDate() {
        return makeDate;
    }

    public void setMakeDate(String makeDate) {
        this.makeDate = makeDate;
    }

    public String getPlanPayDate() {
        return planPayDate;
    }

    public void setPlanPayDate(String planPayDate) {
        this.planPayDate = planPayDate;
    }

    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }

    public String getPlanSubmitDate() {
        return planSubmitDate;
    }

    public void setPlanSubmitDate(String planSubmitDate) {
        this.planSubmitDate = planSubmitDate;
    }

    public String getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(String submitDate) {
        this.submitDate = submitDate;
    }

    public List<InvoiceDetail> getInvoiceDetailList() {
        return invoiceDetailList;
    }

    public void setInvoiceDetailList(List<InvoiceDetail> invoiceDetailList) {
        this.invoiceDetailList = invoiceDetailList;
    }
}
