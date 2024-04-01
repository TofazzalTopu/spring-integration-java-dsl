package com.springboot.integration.model.fileWriter;

import org.beanio.annotation.Field;
import org.beanio.builder.Align;

public class Detail {

    @Field(length = 14, rid = true, align = Align.RIGHT, at = 20,  until = 34)
    private String referenceNo;

    @Field(length = 16, align = Align.RIGHT, at = 40,  until = 56)
    private String amount;

    public Detail() {
    }

    public Detail(String referenceNo, String amount) {
        this.referenceNo = referenceNo;
        this.amount = amount;
    }

    public String getReferenceNo() {
        return referenceNo;
    }

    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
