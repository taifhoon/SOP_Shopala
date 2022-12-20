package Server;

import com.proto.shopala.Product;
import com.proto.shopala.ShopalaRequest;
import com.proto.shopala.ShopalaResponse;
import com.proto.shopala.ShopalaServiceGrpc;
import io.grpc.stub.StreamObserver;

import java.math.BigDecimal;

public class ShopalaServiceImpl extends ShopalaServiceGrpc.ShopalaServiceImplBase {

    @Override
    public void shopala(ShopalaRequest request, StreamObserver<ShopalaResponse>
            responseObserver) {
        // Block 1: extract the data required
        Product product = request.getProduct();
        double price = product.getPrice();
        int quantity = product.getQuantity();
        // Block 2: create the response message
        double result = price*quantity;
        ShopalaResponse response = ShopalaResponse.newBuilder()
                .setResult(result)
                .build();
        // Block 3: send the response
        responseObserver.onNext(response);
        // Block 4: complete the RPC call
        responseObserver.onCompleted();
    }
}
