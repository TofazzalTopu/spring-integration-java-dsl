package com.springboot.integration.exceptions;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class NotAcceptableException extends AbstractThrowableProblem {

    private static final URI TYPE
            = URI.create("https://locahost");

    public NotAcceptableException(String message) {
        super(
                TYPE,
                Status.NOT_ACCEPTABLE.name(),
                Status.NOT_ACCEPTABLE,
                message);
    }
}
