package org.example.vcdb.store.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * 对外提供的接口
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.39.0)",
    comments = "Source: DB.proto")
public final class dbServiceGrpc {

  private dbServiceGrpc() {}

  public static final String SERVICE_NAME = "DB.dbService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<org.example.vcdb.store.proto.DB.createRequest,
      org.example.vcdb.store.proto.Version.intReply> getCreateDBMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "createDB",
      requestType = org.example.vcdb.store.proto.DB.createRequest.class,
      responseType = org.example.vcdb.store.proto.Version.intReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.example.vcdb.store.proto.DB.createRequest,
      org.example.vcdb.store.proto.Version.intReply> getCreateDBMethod() {
    io.grpc.MethodDescriptor<org.example.vcdb.store.proto.DB.createRequest, org.example.vcdb.store.proto.Version.intReply> getCreateDBMethod;
    if ((getCreateDBMethod = dbServiceGrpc.getCreateDBMethod) == null) {
      synchronized (dbServiceGrpc.class) {
        if ((getCreateDBMethod = dbServiceGrpc.getCreateDBMethod) == null) {
          dbServiceGrpc.getCreateDBMethod = getCreateDBMethod =
              io.grpc.MethodDescriptor.<org.example.vcdb.store.proto.DB.createRequest, org.example.vcdb.store.proto.Version.intReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "createDB"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.vcdb.store.proto.DB.createRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.vcdb.store.proto.Version.intReply.getDefaultInstance()))
              .setSchemaDescriptor(new dbServiceMethodDescriptorSupplier("createDB"))
              .build();
        }
      }
    }
    return getCreateDBMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.example.vcdb.store.proto.DB.deleteRequest,
      org.example.vcdb.store.proto.Version.intReply> getDeleteDBMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteDB",
      requestType = org.example.vcdb.store.proto.DB.deleteRequest.class,
      responseType = org.example.vcdb.store.proto.Version.intReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.example.vcdb.store.proto.DB.deleteRequest,
      org.example.vcdb.store.proto.Version.intReply> getDeleteDBMethod() {
    io.grpc.MethodDescriptor<org.example.vcdb.store.proto.DB.deleteRequest, org.example.vcdb.store.proto.Version.intReply> getDeleteDBMethod;
    if ((getDeleteDBMethod = dbServiceGrpc.getDeleteDBMethod) == null) {
      synchronized (dbServiceGrpc.class) {
        if ((getDeleteDBMethod = dbServiceGrpc.getDeleteDBMethod) == null) {
          dbServiceGrpc.getDeleteDBMethod = getDeleteDBMethod =
              io.grpc.MethodDescriptor.<org.example.vcdb.store.proto.DB.deleteRequest, org.example.vcdb.store.proto.Version.intReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteDB"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.vcdb.store.proto.DB.deleteRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.vcdb.store.proto.Version.intReply.getDefaultInstance()))
              .setSchemaDescriptor(new dbServiceMethodDescriptorSupplier("deleteDB"))
              .build();
        }
      }
    }
    return getDeleteDBMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static dbServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<dbServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<dbServiceStub>() {
        @java.lang.Override
        public dbServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new dbServiceStub(channel, callOptions);
        }
      };
    return dbServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static dbServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<dbServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<dbServiceBlockingStub>() {
        @java.lang.Override
        public dbServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new dbServiceBlockingStub(channel, callOptions);
        }
      };
    return dbServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static dbServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<dbServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<dbServiceFutureStub>() {
        @java.lang.Override
        public dbServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new dbServiceFutureStub(channel, callOptions);
        }
      };
    return dbServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * 对外提供的接口
   * </pre>
   */
  public static abstract class dbServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * getRegionMeta 方法名，google.protobuf.Empt 传入参数为空， regionMeta  返回响应类
     * </pre>
     */
    public void createDB(org.example.vcdb.store.proto.DB.createRequest request,
        io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Version.intReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateDBMethod(), responseObserver);
    }

    /**
     */
    public void deleteDB(org.example.vcdb.store.proto.DB.deleteRequest request,
        io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Version.intReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteDBMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateDBMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.example.vcdb.store.proto.DB.createRequest,
                org.example.vcdb.store.proto.Version.intReply>(
                  this, METHODID_CREATE_DB)))
          .addMethod(
            getDeleteDBMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.example.vcdb.store.proto.DB.deleteRequest,
                org.example.vcdb.store.proto.Version.intReply>(
                  this, METHODID_DELETE_DB)))
          .build();
    }
  }

  /**
   * <pre>
   * 对外提供的接口
   * </pre>
   */
  public static final class dbServiceStub extends io.grpc.stub.AbstractAsyncStub<dbServiceStub> {
    private dbServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected dbServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new dbServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * getRegionMeta 方法名，google.protobuf.Empt 传入参数为空， regionMeta  返回响应类
     * </pre>
     */
    public void createDB(org.example.vcdb.store.proto.DB.createRequest request,
        io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Version.intReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateDBMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteDB(org.example.vcdb.store.proto.DB.deleteRequest request,
        io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Version.intReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteDBMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * 对外提供的接口
   * </pre>
   */
  public static final class dbServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<dbServiceBlockingStub> {
    private dbServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected dbServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new dbServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * getRegionMeta 方法名，google.protobuf.Empt 传入参数为空， regionMeta  返回响应类
     * </pre>
     */
    public org.example.vcdb.store.proto.Version.intReply createDB(org.example.vcdb.store.proto.DB.createRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateDBMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.example.vcdb.store.proto.Version.intReply deleteDB(org.example.vcdb.store.proto.DB.deleteRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteDBMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * 对外提供的接口
   * </pre>
   */
  public static final class dbServiceFutureStub extends io.grpc.stub.AbstractFutureStub<dbServiceFutureStub> {
    private dbServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected dbServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new dbServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * getRegionMeta 方法名，google.protobuf.Empt 传入参数为空， regionMeta  返回响应类
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.example.vcdb.store.proto.Version.intReply> createDB(
        org.example.vcdb.store.proto.DB.createRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateDBMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.example.vcdb.store.proto.Version.intReply> deleteDB(
        org.example.vcdb.store.proto.DB.deleteRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteDBMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_DB = 0;
  private static final int METHODID_DELETE_DB = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final dbServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(dbServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_DB:
          serviceImpl.createDB((org.example.vcdb.store.proto.DB.createRequest) request,
              (io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Version.intReply>) responseObserver);
          break;
        case METHODID_DELETE_DB:
          serviceImpl.deleteDB((org.example.vcdb.store.proto.DB.deleteRequest) request,
              (io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Version.intReply>) responseObserver);
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

  private static abstract class dbServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    dbServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.example.vcdb.store.proto.DB.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("dbService");
    }
  }

  private static final class dbServiceFileDescriptorSupplier
      extends dbServiceBaseDescriptorSupplier {
    dbServiceFileDescriptorSupplier() {}
  }

  private static final class dbServiceMethodDescriptorSupplier
      extends dbServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    dbServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (dbServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new dbServiceFileDescriptorSupplier())
              .addMethod(getCreateDBMethod())
              .addMethod(getDeleteDBMethod())
              .build();
        }
      }
    }
    return result;
  }
}
