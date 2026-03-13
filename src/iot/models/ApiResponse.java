package iot.models;

public class ApiResponse<T> {
    private int statusCode;
    private String message;
    private T data;

    public ApiResponse(int statusCode, String message, T data) {
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }

    @Override
    public String toString() {
        return String.format("HTTP %d [%s] -> %s", statusCode, message, (data != null ? data : "No Data"));
    }
}
