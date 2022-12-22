package com.example.grpcservice;

import com.proto.calculate.CalculateRequest;
import com.proto.calculate.CalculateResponse;
import com.proto.calculate.CalculateServiceGrpc;
import com.proto.calculate.Calculating;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class Controller {

    @RequestMapping(value = "/cal", method = RequestMethod.POST)
    public double calculate(@RequestBody Entity entity){
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost",50055)
                .usePlaintext().build();
        CalculateServiceGrpc.CalculateServiceBlockingStub calClient
                = CalculateServiceGrpc.newBlockingStub(channel);
        CalculateRequest request = CalculateRequest.newBuilder().setCalculating(
                Calculating.newBuilder()
                        .setPrice(entity.getPrice())
                        .setQuantity(entity.getQuantity())).build();
        CalculateResponse response = calClient.calculate(request);
        System.out.println(response.getResult());
        return response.getResult();
    }
}
