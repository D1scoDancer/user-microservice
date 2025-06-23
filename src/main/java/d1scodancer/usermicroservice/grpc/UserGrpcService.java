package d1scodancer.usermicroservice.grpc;

import d1scodancer.proto.user.UserRequest;
import d1scodancer.proto.user.UserResponse;
import d1scodancer.proto.user.UserServiceGrpc;
import d1scodancer.usermicroservice.model.User;
import d1scodancer.usermicroservice.service.UserService;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;

/**
 * @author Aleksey Shulikov
 */
@GrpcService
@RequiredArgsConstructor
public class UserGrpcService extends UserServiceGrpc.UserServiceImplBase {

    private final UserService userService;

    @Override
    public void getUser(UserRequest request, StreamObserver<UserResponse> responseObserver) {
        User user = userService.getUser(request.getId());

        responseObserver.onNext(UserResponse.newBuilder()
                .setId(user.getId())
                .setUsername(user.getUsername())
                .build());
        responseObserver.onCompleted();
    }
}
