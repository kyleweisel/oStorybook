package edu.drexel.se410;

public final class ResponseWrapper {

    public final int responseCode;
    public final String response;

    public ResponseWrapper(final int responseCode, final String response) {
        this.responseCode = responseCode;
        this.response = response;
    }

    public boolean isError() {
        return this.responseCode > SimpleRESTClient.MAX_SUCCESS_CODE;
    }

}
