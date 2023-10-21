package com.demo.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: user.proto")
public final class userGrpc {

  private userGrpc() {}

  public static final String SERVICE_NAME = "user";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.demo.grpc.User.RegisterNewUser,
      com.demo.grpc.User.APIRes> getRegisterUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "registerUser",
      requestType = com.demo.grpc.User.RegisterNewUser.class,
      responseType = com.demo.grpc.User.APIRes.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.demo.grpc.User.RegisterNewUser,
      com.demo.grpc.User.APIRes> getRegisterUserMethod() {
    io.grpc.MethodDescriptor<com.demo.grpc.User.RegisterNewUser, com.demo.grpc.User.APIRes> getRegisterUserMethod;
    if ((getRegisterUserMethod = userGrpc.getRegisterUserMethod) == null) {
      synchronized (userGrpc.class) {
        if ((getRegisterUserMethod = userGrpc.getRegisterUserMethod) == null) {
          userGrpc.getRegisterUserMethod = getRegisterUserMethod = 
              io.grpc.MethodDescriptor.<com.demo.grpc.User.RegisterNewUser, com.demo.grpc.User.APIRes>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "user", "registerUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.demo.grpc.User.RegisterNewUser.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.demo.grpc.User.APIRes.getDefaultInstance()))
                  .setSchemaDescriptor(new userMethodDescriptorSupplier("registerUser"))
                  .build();
          }
        }
     }
     return getRegisterUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.demo.grpc.User.LoginExistingUser,
      com.demo.grpc.User.APIRes> getLoginUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "loginUser",
      requestType = com.demo.grpc.User.LoginExistingUser.class,
      responseType = com.demo.grpc.User.APIRes.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.demo.grpc.User.LoginExistingUser,
      com.demo.grpc.User.APIRes> getLoginUserMethod() {
    io.grpc.MethodDescriptor<com.demo.grpc.User.LoginExistingUser, com.demo.grpc.User.APIRes> getLoginUserMethod;
    if ((getLoginUserMethod = userGrpc.getLoginUserMethod) == null) {
      synchronized (userGrpc.class) {
        if ((getLoginUserMethod = userGrpc.getLoginUserMethod) == null) {
          userGrpc.getLoginUserMethod = getLoginUserMethod = 
              io.grpc.MethodDescriptor.<com.demo.grpc.User.LoginExistingUser, com.demo.grpc.User.APIRes>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "user", "loginUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.demo.grpc.User.LoginExistingUser.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.demo.grpc.User.APIRes.getDefaultInstance()))
                  .setSchemaDescriptor(new userMethodDescriptorSupplier("loginUser"))
                  .build();
          }
        }
     }
     return getLoginUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.demo.grpc.User.SetProfileInfo,
      com.demo.grpc.User.APIRes> getSetProfileMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "setProfile",
      requestType = com.demo.grpc.User.SetProfileInfo.class,
      responseType = com.demo.grpc.User.APIRes.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.demo.grpc.User.SetProfileInfo,
      com.demo.grpc.User.APIRes> getSetProfileMethod() {
    io.grpc.MethodDescriptor<com.demo.grpc.User.SetProfileInfo, com.demo.grpc.User.APIRes> getSetProfileMethod;
    if ((getSetProfileMethod = userGrpc.getSetProfileMethod) == null) {
      synchronized (userGrpc.class) {
        if ((getSetProfileMethod = userGrpc.getSetProfileMethod) == null) {
          userGrpc.getSetProfileMethod = getSetProfileMethod = 
              io.grpc.MethodDescriptor.<com.demo.grpc.User.SetProfileInfo, com.demo.grpc.User.APIRes>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "user", "setProfile"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.demo.grpc.User.SetProfileInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.demo.grpc.User.APIRes.getDefaultInstance()))
                  .setSchemaDescriptor(new userMethodDescriptorSupplier("setProfile"))
                  .build();
          }
        }
     }
     return getSetProfileMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.demo.grpc.User.ProfileReq,
      com.demo.grpc.User.ProfileView> getUserProfileViewMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "userProfileView",
      requestType = com.demo.grpc.User.ProfileReq.class,
      responseType = com.demo.grpc.User.ProfileView.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.demo.grpc.User.ProfileReq,
      com.demo.grpc.User.ProfileView> getUserProfileViewMethod() {
    io.grpc.MethodDescriptor<com.demo.grpc.User.ProfileReq, com.demo.grpc.User.ProfileView> getUserProfileViewMethod;
    if ((getUserProfileViewMethod = userGrpc.getUserProfileViewMethod) == null) {
      synchronized (userGrpc.class) {
        if ((getUserProfileViewMethod = userGrpc.getUserProfileViewMethod) == null) {
          userGrpc.getUserProfileViewMethod = getUserProfileViewMethod = 
              io.grpc.MethodDescriptor.<com.demo.grpc.User.ProfileReq, com.demo.grpc.User.ProfileView>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "user", "userProfileView"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.demo.grpc.User.ProfileReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.demo.grpc.User.ProfileView.getDefaultInstance()))
                  .setSchemaDescriptor(new userMethodDescriptorSupplier("userProfileView"))
                  .build();
          }
        }
     }
     return getUserProfileViewMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.demo.grpc.User.UpdateProfileInfo,
      com.demo.grpc.User.APIRes> getUpdateProfileMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateProfile",
      requestType = com.demo.grpc.User.UpdateProfileInfo.class,
      responseType = com.demo.grpc.User.APIRes.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.demo.grpc.User.UpdateProfileInfo,
      com.demo.grpc.User.APIRes> getUpdateProfileMethod() {
    io.grpc.MethodDescriptor<com.demo.grpc.User.UpdateProfileInfo, com.demo.grpc.User.APIRes> getUpdateProfileMethod;
    if ((getUpdateProfileMethod = userGrpc.getUpdateProfileMethod) == null) {
      synchronized (userGrpc.class) {
        if ((getUpdateProfileMethod = userGrpc.getUpdateProfileMethod) == null) {
          userGrpc.getUpdateProfileMethod = getUpdateProfileMethod = 
              io.grpc.MethodDescriptor.<com.demo.grpc.User.UpdateProfileInfo, com.demo.grpc.User.APIRes>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "user", "updateProfile"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.demo.grpc.User.UpdateProfileInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.demo.grpc.User.APIRes.getDefaultInstance()))
                  .setSchemaDescriptor(new userMethodDescriptorSupplier("updateProfile"))
                  .build();
          }
        }
     }
     return getUpdateProfileMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static userStub newStub(io.grpc.Channel channel) {
    return new userStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static userBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new userBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static userFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new userFutureStub(channel);
  }

  /**
   */
  public static abstract class userImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * task 1. to register a new user
     * </pre>
     */
    public void registerUser(com.demo.grpc.User.RegisterNewUser request,
        io.grpc.stub.StreamObserver<com.demo.grpc.User.APIRes> responseObserver) {
      asyncUnimplementedUnaryCall(getRegisterUserMethod(), responseObserver);
    }

    /**
     * <pre>
     * task 2. to login an existing user
     * </pre>
     */
    public void loginUser(com.demo.grpc.User.LoginExistingUser request,
        io.grpc.stub.StreamObserver<com.demo.grpc.User.APIRes> responseObserver) {
      asyncUnimplementedUnaryCall(getLoginUserMethod(), responseObserver);
    }

    /**
     * <pre>
     * task 3. to set profile info
     * </pre>
     */
    public void setProfile(com.demo.grpc.User.SetProfileInfo request,
        io.grpc.stub.StreamObserver<com.demo.grpc.User.APIRes> responseObserver) {
      asyncUnimplementedUnaryCall(getSetProfileMethod(), responseObserver);
    }

    /**
     * <pre>
     * task 4. to view profile info
     * </pre>
     */
    public void userProfileView(com.demo.grpc.User.ProfileReq request,
        io.grpc.stub.StreamObserver<com.demo.grpc.User.ProfileView> responseObserver) {
      asyncUnimplementedUnaryCall(getUserProfileViewMethod(), responseObserver);
    }

    /**
     * <pre>
     * task 5. to update profile info
     * </pre>
     */
    public void updateProfile(com.demo.grpc.User.UpdateProfileInfo request,
        io.grpc.stub.StreamObserver<com.demo.grpc.User.APIRes> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateProfileMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getRegisterUserMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.demo.grpc.User.RegisterNewUser,
                com.demo.grpc.User.APIRes>(
                  this, METHODID_REGISTER_USER)))
          .addMethod(
            getLoginUserMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.demo.grpc.User.LoginExistingUser,
                com.demo.grpc.User.APIRes>(
                  this, METHODID_LOGIN_USER)))
          .addMethod(
            getSetProfileMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.demo.grpc.User.SetProfileInfo,
                com.demo.grpc.User.APIRes>(
                  this, METHODID_SET_PROFILE)))
          .addMethod(
            getUserProfileViewMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.demo.grpc.User.ProfileReq,
                com.demo.grpc.User.ProfileView>(
                  this, METHODID_USER_PROFILE_VIEW)))
          .addMethod(
            getUpdateProfileMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.demo.grpc.User.UpdateProfileInfo,
                com.demo.grpc.User.APIRes>(
                  this, METHODID_UPDATE_PROFILE)))
          .build();
    }
  }

  /**
   */
  public static final class userStub extends io.grpc.stub.AbstractStub<userStub> {
    private userStub(io.grpc.Channel channel) {
      super(channel);
    }

    private userStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected userStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new userStub(channel, callOptions);
    }

    /**
     * <pre>
     * task 1. to register a new user
     * </pre>
     */
    public void registerUser(com.demo.grpc.User.RegisterNewUser request,
        io.grpc.stub.StreamObserver<com.demo.grpc.User.APIRes> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRegisterUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * task 2. to login an existing user
     * </pre>
     */
    public void loginUser(com.demo.grpc.User.LoginExistingUser request,
        io.grpc.stub.StreamObserver<com.demo.grpc.User.APIRes> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLoginUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * task 3. to set profile info
     * </pre>
     */
    public void setProfile(com.demo.grpc.User.SetProfileInfo request,
        io.grpc.stub.StreamObserver<com.demo.grpc.User.APIRes> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSetProfileMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * task 4. to view profile info
     * </pre>
     */
    public void userProfileView(com.demo.grpc.User.ProfileReq request,
        io.grpc.stub.StreamObserver<com.demo.grpc.User.ProfileView> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUserProfileViewMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * task 5. to update profile info
     * </pre>
     */
    public void updateProfile(com.demo.grpc.User.UpdateProfileInfo request,
        io.grpc.stub.StreamObserver<com.demo.grpc.User.APIRes> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateProfileMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class userBlockingStub extends io.grpc.stub.AbstractStub<userBlockingStub> {
    private userBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private userBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected userBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new userBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * task 1. to register a new user
     * </pre>
     */
    public com.demo.grpc.User.APIRes registerUser(com.demo.grpc.User.RegisterNewUser request) {
      return blockingUnaryCall(
          getChannel(), getRegisterUserMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * task 2. to login an existing user
     * </pre>
     */
    public com.demo.grpc.User.APIRes loginUser(com.demo.grpc.User.LoginExistingUser request) {
      return blockingUnaryCall(
          getChannel(), getLoginUserMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * task 3. to set profile info
     * </pre>
     */
    public com.demo.grpc.User.APIRes setProfile(com.demo.grpc.User.SetProfileInfo request) {
      return blockingUnaryCall(
          getChannel(), getSetProfileMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * task 4. to view profile info
     * </pre>
     */
    public com.demo.grpc.User.ProfileView userProfileView(com.demo.grpc.User.ProfileReq request) {
      return blockingUnaryCall(
          getChannel(), getUserProfileViewMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * task 5. to update profile info
     * </pre>
     */
    public com.demo.grpc.User.APIRes updateProfile(com.demo.grpc.User.UpdateProfileInfo request) {
      return blockingUnaryCall(
          getChannel(), getUpdateProfileMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class userFutureStub extends io.grpc.stub.AbstractStub<userFutureStub> {
    private userFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private userFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected userFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new userFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * task 1. to register a new user
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.demo.grpc.User.APIRes> registerUser(
        com.demo.grpc.User.RegisterNewUser request) {
      return futureUnaryCall(
          getChannel().newCall(getRegisterUserMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * task 2. to login an existing user
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.demo.grpc.User.APIRes> loginUser(
        com.demo.grpc.User.LoginExistingUser request) {
      return futureUnaryCall(
          getChannel().newCall(getLoginUserMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * task 3. to set profile info
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.demo.grpc.User.APIRes> setProfile(
        com.demo.grpc.User.SetProfileInfo request) {
      return futureUnaryCall(
          getChannel().newCall(getSetProfileMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * task 4. to view profile info
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.demo.grpc.User.ProfileView> userProfileView(
        com.demo.grpc.User.ProfileReq request) {
      return futureUnaryCall(
          getChannel().newCall(getUserProfileViewMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * task 5. to update profile info
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.demo.grpc.User.APIRes> updateProfile(
        com.demo.grpc.User.UpdateProfileInfo request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateProfileMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_REGISTER_USER = 0;
  private static final int METHODID_LOGIN_USER = 1;
  private static final int METHODID_SET_PROFILE = 2;
  private static final int METHODID_USER_PROFILE_VIEW = 3;
  private static final int METHODID_UPDATE_PROFILE = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final userImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(userImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REGISTER_USER:
          serviceImpl.registerUser((com.demo.grpc.User.RegisterNewUser) request,
              (io.grpc.stub.StreamObserver<com.demo.grpc.User.APIRes>) responseObserver);
          break;
        case METHODID_LOGIN_USER:
          serviceImpl.loginUser((com.demo.grpc.User.LoginExistingUser) request,
              (io.grpc.stub.StreamObserver<com.demo.grpc.User.APIRes>) responseObserver);
          break;
        case METHODID_SET_PROFILE:
          serviceImpl.setProfile((com.demo.grpc.User.SetProfileInfo) request,
              (io.grpc.stub.StreamObserver<com.demo.grpc.User.APIRes>) responseObserver);
          break;
        case METHODID_USER_PROFILE_VIEW:
          serviceImpl.userProfileView((com.demo.grpc.User.ProfileReq) request,
              (io.grpc.stub.StreamObserver<com.demo.grpc.User.ProfileView>) responseObserver);
          break;
        case METHODID_UPDATE_PROFILE:
          serviceImpl.updateProfile((com.demo.grpc.User.UpdateProfileInfo) request,
              (io.grpc.stub.StreamObserver<com.demo.grpc.User.APIRes>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class userBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    userBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.demo.grpc.User.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("user");
    }
  }

  private static final class userFileDescriptorSupplier
      extends userBaseDescriptorSupplier {
    userFileDescriptorSupplier() {}
  }

  private static final class userMethodDescriptorSupplier
      extends userBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    userMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (userGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new userFileDescriptorSupplier())
              .addMethod(getRegisterUserMethod())
              .addMethod(getLoginUserMethod())
              .addMethod(getSetProfileMethod())
              .addMethod(getUserProfileViewMethod())
              .addMethod(getUpdateProfileMethod())
              .build();
        }
      }
    }
    return result;
  }
}
