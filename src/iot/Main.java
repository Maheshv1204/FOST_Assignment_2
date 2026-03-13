package iot;

import iot.api.MockController;
import iot.models.ApiResponse;
import iot.models.Device;

public class Main {
    public static void main(String[] args) {
        System.out.println("================================================\n");

        MockController api = new MockController();

        // 1. EXECUTION: Simulate POST Request
        System.out.println("CLIENT REQUEST: POST /api/register {id: 'CBIT-IOT-01'}");
        ApiResponse<Device> postResponse = api.postDevice("CBIT-IOT-01", "Environment_Sensor");
        System.out.println(postResponse + "\n");

        // 2. EXECUTION: Simulate GET Request (Success)
        System.out.println("CLIENT REQUEST: GET /api/device/CBIT-IOT-01");
        ApiResponse<Device> getResponse = api.getDevice("CBIT-IOT-01");
        System.out.println(getResponse + "\n");

        // 3. EXECUTION: Simulate GET Request (Failure/404)
        System.out.println("CLIENT REQUEST: GET /api/device/UNKNOWN");
        ApiResponse<Device> errorResponse = api.getDevice("UNKNOWN");
        System.out.println(errorResponse + "\n");

        System.out.println("================================================");
        System.out.println("COMPLETED SUCCESSFULLY");
    }
}
