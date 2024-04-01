package com.springboot.integration.model.fileWriter;

import org.beanio.annotation.Field;
import org.beanio.builder.Align;

public class Trailer {

    @Field(length = 1, rid = true, align = Align.LEFT, ordinal = 20,  until = 34)
    private String recordType;

    @Field(length = 1, align = Align.RIGHT, ordinal = 14,  until = 23)
    private String fileType;

    public Trailer() {
    }

    public Trailer(String recordType, String fileType) {
        this.recordType = recordType;
        this.fileType = fileType;
    }

    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
}
