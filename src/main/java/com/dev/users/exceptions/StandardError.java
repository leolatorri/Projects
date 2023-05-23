package com.dev.users.exceptions;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
@Data
@RequiredArgsConstructor
public class StandardError implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private Instant timeStamp;
    private int status;
    private String error;
    private String message;
    private String path;

}
