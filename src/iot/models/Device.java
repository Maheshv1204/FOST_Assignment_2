package iot.models;

public class Device {
    private String id;
    private String type;
    private String status;

    public Device(String id, String type, String status) {
        this.id = id;
        this.type = type;
        this.status = status;
    }

    // Getters and Setters (Encapsulation)
    public String getId() { return id; }
    public String getType() { return type; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return String.format("[ID: %s | Type: %s | Status: %s]", id, type, status);
    }
}
