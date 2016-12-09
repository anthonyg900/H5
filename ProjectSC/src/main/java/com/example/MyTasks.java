package com.example;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MyTasks {
    RestTemplate restTemplate = new RestTemplate();

    int id = 1;

    //.POST
    @Scheduled(cron="*/1 * * * * *")
    public void addVehicle() {
        String url = "http://localhost:8080/addVehicle";
        int year = (int) (Math.random() * 30 + 1986);
        int price = (int) (Math.random() * 30000 + 15000);
        Vehicle v = new Vehicle(id, "VehicleName", year, price);
        restTemplate.postForObject(url, v, Vehicle.class);
        System.out.println("+ (Post)Added new vehicle: " + v);
        id++;
    }
    //.DELETE
    @Scheduled(cron="1/3 * * * * *")
    public void deleteVehicle() {}

    //.PUT
    @Scheduled(cron="*/1 * * * * *")
    public void updateVehicle() {
        String url = "http://localhost:8080/updateVehicle";
        int id = (int) (Math.random() * 100);
        int year = (int) (Math.random() * 30 + 1986);
        int price = (int) (Math.random() * 30000 + 15000);
        Vehicle v = new Vehicle(id, "VehicleName", year, price);
        restTemplate.put(url, v);
    }
}