package com.example.grpc;

import com.proto.calculate.CalculateRequest;
import com.proto.calculate.CalculateResponse;
import com.proto.calculate.CalculateServiceGrpc;
import com.proto.calculate.Calculating;
import io.grpc.stub.StreamObserver;

public class CalculateServiceImpl extends CalculateServiceGrpc.CalculateServiceImplBase {

    @Override
    public void calculate(CalculateRequest request, StreamObserver<CalculateResponse> responseStreamObserver){
        Calculating calculating = request.getCalculating();
        int quantity = calculating.getQuantity();
        double price = calculating.getPrice();

        double result = quantity*price;
        CalculateResponse response = CalculateResponse.newBuilder()
                .setResult(result)
                .build();

        System.out.println("Server Output - Price : " + result);
        responseStreamObserver.onNext(response);

        responseStreamObserver.onCompleted();
    }
}
