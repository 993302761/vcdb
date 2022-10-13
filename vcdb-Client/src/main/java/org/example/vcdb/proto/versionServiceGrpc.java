package org.example.vcdb.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.39.0)",
    comments = "Source: Version.proto")
public final class versionServiceGrpc {

  private versionServiceGrpc() {}

  public static final String SERVICE_NAME = "Version.versionService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<org.example.vcdb.proto.Version.deleteRequest,
      org.example.vcdb.proto.Version.intReply> getDeleteVersionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteVersion",
      requestType = org.example.vcdb.proto.Version.deleteRequest.class,
      responseType = org.example.vcdb.proto.Version.intReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.example.vcdb.proto.Version.deleteRequest,
      org.example.vcdb.proto.Version.intReply> getDeleteVersionMethod() {
    io.grpc.MethodDescriptor<org.example.vcdb.proto.Version.deleteRequest, org.example.vcdb.proto.Version.intReply> getDeleteVersionMethod;
    if ((getDeleteVersionMethod = versionServiceGrpc.getDeleteVersionMethod) == null) {
      synchronized (versionServiceGrpc.class) {
        if ((getDeleteVersionMethod = versionServiceGrpc.getDeleteVersionMethod) == null) {
          versionServiceGrpc.getDeleteVersionMethod = getDeleteVersionMethod =
              io.grpc.MethodDescriptor.<org.example.vcdb.proto.Version.deleteRequest, org.example.vcdb.proto.Version.intReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteVersion"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.vcdb.proto.Version.deleteRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.vcdb.proto.Version.intReply.getDefaultInstance()))
              .setSchemaDescriptor(new versionServiceMethodDescriptorSupplier("deleteVersion"))
              .build();
        }
      }
    }
    return getDeleteVersionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.example.vcdb.proto.Version.mergeRequest,
      org.example.vcdb.proto.Version.intReply> getMergeVersionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "mergeVersion",
      requestType = org.example.vcdb.proto.Version.mergeRequest.class,
      responseType = org.example.vcdb.proto.Version.intReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.example.vcdb.proto.Version.mergeRequest,
      org.example.vcdb.proto.Version.intReply> getMergeVersionMethod() {
    io.grpc.MethodDescriptor<org.example.vcdb.proto.Version.mergeRequest, org.example.vcdb.proto.Version.intReply> getMergeVersionMethod;
    if ((getMergeVersionMethod = versionServiceGrpc.getMergeVersionMethod) == null) {
      synchronized (versionServiceGrpc.class) {
        if ((getMergeVersionMethod = versionServiceGrpc.getMergeVersionMethod) == null) {
          versionServiceGrpc.getMergeVersionMethod = getMergeVersionMethod =
              io.grpc.MethodDescriptor.<org.example.vcdb.proto.Version.mergeRequest, org.example.vcdb.proto.Version.intReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "mergeVersion"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.vcdb.proto.Version.mergeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.vcdb.proto.Version.intReply.getDefaultInstance()))
              .setSchemaDescriptor(new versionServiceMethodDescriptorSupplier("mergeVersion"))
              .build();
        }
      }
    }
    return getMergeVersionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.example.vcdb.proto.Version.useRequest,
      org.example.vcdb.proto.Version.intReply> getUseVersionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "useVersion",
      requestType = org.example.vcdb.proto.Version.useRequest.class,
      responseType = org.example.vcdb.proto.Version.intReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.example.vcdb.proto.Version.useRequest,
      org.example.vcdb.proto.Version.intReply> getUseVersionMethod() {
    io.grpc.MethodDescriptor<org.example.vcdb.proto.Version.useRequest, org.example.vcdb.proto.Version.intReply> getUseVersionMethod;
    if ((getUseVersionMethod = versionServiceGrpc.getUseVersionMethod) == null) {
      synchronized (versionServiceGrpc.class) {
        if ((getUseVersionMethod = versionServiceGrpc.getUseVersionMethod) == null) {
          versionServiceGrpc.getUseVersionMethod = getUseVersionMethod =
              io.grpc.MethodDescriptor.<org.example.vcdb.proto.Version.useRequest, org.example.vcdb.proto.Version.intReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "useVersion"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.vcdb.proto.Version.useRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.vcdb.proto.Version.intReply.getDefaultInstance()))
              .setSchemaDescriptor(new versionServiceMethodDescriptorSupplier("useVersion"))
              .build();
        }
      }
    }
    return getUseVersionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.example.vcdb.proto.Version.showRequest,
      org.example.vcdb.proto.Version.bytesReply> getShowVersionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "showVersion",
      requestType = org.example.vcdb.proto.Version.showRequest.class,
      responseType = org.example.vcdb.proto.Version.bytesReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.example.vcdb.proto.Version.showRequest,
      org.example.vcdb.proto.Version.bytesReply> getShowVersionMethod() {
    io.grpc.MethodDescriptor<org.example.vcdb.proto.Version.showRequest, org.example.vcdb.proto.Version.bytesReply> getShowVersionMethod;
    if ((getShowVersionMethod = versionServiceGrpc.getShowVersionMethod) == null) {
      synchronized (versionServiceGrpc.class) {
        if ((getShowVersionMethod = versionServiceGrpc.getShowVersionMethod) == null) {
          versionServiceGrpc.getShowVersionMethod = getShowVersionMethod =
              io.grpc.MethodDescriptor.<org.example.vcdb.proto.Version.showRequest, org.example.vcdb.proto.Version.bytesReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "showVersion"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.vcdb.proto.Version.showRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.vcdb.proto.Version.bytesReply.getDefaultInstance()))
              .setSchemaDescriptor(new versionServiceMethodDescriptorSupplier("showVersion"))
              .build();
        }
      }
    }
    return getShowVersionMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static versionServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<versionServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<versionServiceStub>() {
        @java.lang.Override
        public versionServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new versionServiceStub(channel, callOptions);
        }
      };
    return versionServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static versionServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<versionServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<versionServiceBlockingStub>() {
        @java.lang.Override
        public versionServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new versionServiceBlockingStub(channel, callOptions);
        }
      };
    return versionServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static versionServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<versionServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<versionServiceFutureStub>() {
        @java.lang.Override
        public versionServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new versionServiceFutureStub(channel, callOptions);
        }
      };
    return versionServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class versionServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void deleteVersion(org.example.vcdb.proto.Version.deleteRequest request,
        io.grpc.stub.StreamObserver<org.example.vcdb.proto.Version.intReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteVersionMethod(), responseObserver);
    }

    /**
     */
    public void mergeVersion(org.example.vcdb.proto.Version.mergeRequest request,
        io.grpc.stub.StreamObserver<org.example.vcdb.proto.Version.intReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getMergeVersionMethod(), responseObserver);
    }

    /**
     */
    public void useVersion(org.example.vcdb.proto.Version.useRequest request,
        io.grpc.stub.StreamObserver<org.example.vcdb.proto.Version.intReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUseVersionMethod(), responseObserver);
    }

    /**
     */
    public void showVersion(org.example.vcdb.proto.Version.showRequest request,
        io.grpc.stub.StreamObserver<org.example.vcdb.proto.Version.bytesReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getShowVersionMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getDeleteVersionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.example.vcdb.proto.Version.deleteRequest,
                org.example.vcdb.proto.Version.intReply>(
                  this, METHODID_DELETE_VERSION)))
          .addMethod(
            getMergeVersionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.example.vcdb.proto.Version.mergeRequest,
                org.example.vcdb.proto.Version.intReply>(
                  this, METHODID_MERGE_VERSION)))
          .addMethod(
            getUseVersionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.example.vcdb.proto.Version.useRequest,
                org.example.vcdb.proto.Version.intReply>(
                  this, METHODID_USE_VERSION)))
          .addMethod(
            getShowVersionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.example.vcdb.proto.Version.showRequest,
                org.example.vcdb.proto.Version.bytesReply>(
                  this, METHODID_SHOW_VERSION)))
          .build();
    }
  }

  /**
   */
  public static final class versionServiceStub extends io.grpc.stub.AbstractAsyncStub<versionServiceStub> {
    private versionServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected versionServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new versionServiceStub(channel, callOptions);
    }

    /**
     */
    public void deleteVersion(org.example.vcdb.proto.Version.deleteRequest request,
        io.grpc.stub.StreamObserver<org.example.vcdb.proto.Version.intReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteVersionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void mergeVersion(org.example.vcdb.proto.Version.mergeRequest request,
        io.grpc.stub.StreamObserver<org.example.vcdb.proto.Version.intReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getMergeVersionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void useVersion(org.example.vcdb.proto.Version.useRequest request,
        io.grpc.stub.StreamObserver<org.example.vcdb.proto.Version.intReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUseVersionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void showVersion(org.example.vcdb.proto.Version.showRequest request,
        io.grpc.stub.StreamObserver<org.example.vcdb.proto.Version.bytesReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getShowVersionMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class versionServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<versionServiceBlockingStub> {
    private versionServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected versionServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new versionServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public org.example.vcdb.proto.Version.intReply deleteVersion(org.example.vcdb.proto.Version.deleteRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteVersionMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.example.vcdb.proto.Version.intReply mergeVersion(org.example.vcdb.proto.Version.mergeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getMergeVersionMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.example.vcdb.proto.Version.intReply useVersion(org.example.vcdb.proto.Version.useRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUseVersionMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.example.vcdb.proto.Version.bytesReply showVersion(org.example.vcdb.proto.Version.showRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getShowVersionMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class versionServiceFutureStub extends io.grpc.stub.AbstractFutureStub<versionServiceFutureStub> {
    private versionServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected versionServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new versionServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.example.vcdb.proto.Version.intReply> deleteVersion(
        org.example.vcdb.proto.Version.deleteRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteVersionMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.example.vcdb.proto.Version.intReply> mergeVersion(
        org.example.vcdb.proto.Version.mergeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getMergeVersionMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.example.vcdb.proto.Version.intReply> useVersion(
        org.example.vcdb.proto.Version.useRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUseVersionMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.example.vcdb.proto.Version.bytesReply> showVersion(
        org.example.vcdb.proto.Version.showRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getShowVersionMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_DELETE_VERSION = 0;
  private static final int METHODID_MERGE_VERSION = 1;
  private static final int METHODID_USE_VERSION = 2;
  private static final int METHODID_SHOW_VERSION = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final versionServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(versionServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_DELETE_VERSION:
          serviceImpl.deleteVersion((org.example.vcdb.proto.Version.deleteRequest) request,
              (io.grpc.stub.StreamObserver<org.example.vcdb.proto.Version.intReply>) responseObserver);
          break;
        case METHODID_MERGE_VERSION:
          serviceImpl.mergeVersion((org.example.vcdb.proto.Version.mergeRequest) request,
              (io.grpc.stub.StreamObserver<org.example.vcdb.proto.Version.intReply>) responseObserver);
          break;
        case METHODID_USE_VERSION:
          serviceImpl.useVersion((org.example.vcdb.proto.Version.useRequest) request,
              (io.grpc.stub.StreamObserver<org.example.vcdb.proto.Version.intReply>) responseObserver);
          break;
        case METHODID_SHOW_VERSION:
          serviceImpl.showVersion((org.example.vcdb.proto.Version.showRequest) request,
              (io.grpc.stub.StreamObserver<org.example.vcdb.proto.Version.bytesReply>) responseObserver);
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

  private static abstract class versionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    versionServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.example.vcdb.proto.Version.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("versionService");
    }
  }

  private static final class versionServiceFileDescriptorSupplier
      extends versionServiceBaseDescriptorSupplier {
    versionServiceFileDescriptorSupplier() {}
  }

  private static final class versionServiceMethodDescriptorSupplier
      extends versionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    versionServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (versionServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new versionServiceFileDescriptorSupplier())
              .addMethod(getDeleteVersionMethod())
              .addMethod(getMergeVersionMethod())
              .addMethod(getUseVersionMethod())
              .addMethod(getShowVersionMethod())
              .build();
        }
      }
    }
    return result;
  }
}
