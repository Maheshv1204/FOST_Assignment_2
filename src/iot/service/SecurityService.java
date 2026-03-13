package iot.service;

import iot.models.Device;
import java.util.Base64;

public class SecurityService {

    /**
     * General Security Layer: Performs Data Sanitization and Mock Encryption.
     * This simulates production-level middleware security.
     */
    public boolean validateAndSecure(Device device) {
        // 1. Input Sanitization (General Security)
        if (device.getId().contains("<script>") || device.getId().contains("DROP TABLE")) {
            System.out.println("[SECURITY ALERT] Malicious input detected in ID: " + device.getId());
            return false;
        }

        // 2. Mock Data Masking/Encryption
        String originalStatus = device.getStatus();
        String secureStatus = "ENC_" + Base64.getEncoder().encodeToString(originalStatus.getBytes());
        device.setStatus(secureStatus);

        System.out.println("[SECURITY] Input sanitized and status encrypted for: " + device.getId());
        return true;
    }
}
