package iot.api;

import iot.models.*;
import iot.service.SecurityService;
import java.util.*;

public class MockController {
    private final Map<String, Device> registry = new HashMap<>();
    private final SecurityService securityService = new SecurityService();

    public ApiResponse<Device> postDevice(String id, String type) {
        if (id == null || id.isEmpty()) {
            return new ApiResponse<>(400, "Bad Request: Missing ID", null);
        }

        Device newDevice = new Device(id, type, "ACTIVE");

        // Execute Security Integration
        if (!securityService.validateAndSecure(newDevice)) {
            return new ApiResponse<>(403, "Forbidden: Security Validation Failed", null);
        }

        registry.put(id, newDevice);
        return new ApiResponse<>(201, "Created & Secured", newDevice);
    }

    public ApiResponse<Device> getDevice(String id) {
        if (!registry.containsKey(id)) {
            return new ApiResponse<>(404, "Not Found", null);
        }
        return new ApiResponse<>(200, "OK", registry.get(id));
    }
}
