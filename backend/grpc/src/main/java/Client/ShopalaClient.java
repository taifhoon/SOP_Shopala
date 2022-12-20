package Client;

import com.proto.shopala.Product;
import com.proto.shopala.ShopalaRequest;
import com.proto.shopala.ShopalaResponse;
import com.proto.shopala.ShopalaServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class ShopalaClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 50055)
                .usePlaintext()
                .build();
        // created a greet service client (blocking - synchronous)
        ShopalaServiceGrpc.ShopalaServiceBlockingStub shopalaClient;
        shopalaClient = ShopalaServiceGrpc.newBlockingStub(channel);
        // created a protocol buffer greeting message
        Product product = Product.newBuilder()
                .setPrice(99.99)
                .setQuantity(5)
                .build();
        // created a protocol buffer greetRequest message
        ShopalaRequest shopalaRequest = ShopalaRequest.newBuilder()
                .setProduct(product)
                .build();
        // call the RPC and get back a GreetResponse (Protocol Buffers)
        ShopalaResponse shopalaResponse = shopalaClient.shopala(shopalaRequest);
        // show the result in GreetResponse message
        System.out.println(shopalaResponse.getResult());

    }
}
