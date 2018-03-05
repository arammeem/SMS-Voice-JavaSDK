package com.otsdc.sdk.resources;

public class ApiException extends RuntimeException {
    private final int statusCode;
    private final String reasonPhrase;

    public ApiException(final String message, final Throwable cause) {
        this(message, null, null, cause);
    }

    public ApiException(final String message, final Integer statusCode, final String reasonPhrase, final Throwable cause) {
        super(message, cause);
        this.statusCode = statusCode;
        this.reasonPhrase = reasonPhrase;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getReasonPhrase() {
        return reasonPhrase;
    }

    @Override
    public String toString() {
        return "ApiException{" +
                "statusCode=" + statusCode +
                ", reasonPhrase='" + reasonPhrase + '\'' +
                "} " + super.toString();
    }
}
