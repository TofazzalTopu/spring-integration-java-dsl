package com.springboot.integration.exceptions;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class InvalidCreditCardException extends AbstractThrowableProblem {

    private static final URI TYPE
            = URI.create("https://locahost");

    public InvalidCreditCardException(String message) {
        super(
                TYPE,
                Status.NOT_ACCEPTABLE.name(),
                Status.NOT_ACCEPTABLE,
                message);
    }
}
