package com.devmind.devtools.storage;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class LoadDataException extends RuntimeException {

    public LoadDataException(Throwable cause) {
        super(cause);
    }

}
