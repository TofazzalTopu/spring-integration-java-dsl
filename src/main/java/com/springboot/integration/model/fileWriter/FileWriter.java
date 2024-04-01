package com.springboot.integration.model.fileWriter;

import java.util.List;

public class FileWriter {

    private Header header;
    private List<Detail> details;

    private Trailer trailer;

    public FileWriter() {
    }

    public FileWriter(Header header, List<Detail> details, Trailer trailer) {
        this.header = header;
        this.details = details;
        this.trailer = trailer;
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public List<Detail> getEmployees() {
        return details;
    }

    public void setEmployees(List<Detail> details) {
        this.details = details;
    }

    public Trailer getTrailer() {
        return trailer;
    }

    public void setTrailer(Trailer trailer) {
        this.trailer = trailer;
    }
}
