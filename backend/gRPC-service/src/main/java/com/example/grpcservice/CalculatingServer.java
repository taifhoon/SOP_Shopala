package com.example.grpcservice;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class CalculatingServer {
    public static void main(String[] args) {
        System.out.println("Cal gRPC");
        Server server = ServerBuilder
                .forPort(50055)
                .addService(new CalculateServiceImpl())
                .build();
        try {
            server.start();
            System.out.println("Cal Server Start");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Runtime.getRuntime().addShutdownHook(new Thread(
                () -> {
                    System.out.println("Received Shutdown Request");
                    server.shutdown();
                    System.out.println("Successfully Shutdown Server");
                }
        ));
        try {
            server.awaitTermination();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
