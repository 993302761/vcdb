package org.example.vcdb.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * 对外提供的接口
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.39.0)",
    comments = "Source: Transaction.proto")
public final class transactionServiceGrpc {

  private transactionServiceGrpc() {}

  public static final String SERVICE_NAME = "Transaction.transactionService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<org.example.vcdb.proto.Transaction.openTransactionRequest,
      org.example.vcdb.proto.Version.intReply> getOpenTransactionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "openTransaction",
      requestType = org.example.vcdb.proto.Transaction.openTransactionRequest.class,
      responseType = org.example.vcdb.proto.Version.intReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.example.vcdb.proto.Transaction.openTransactionRequest,
      org.example.vcdb.proto.Version.intReply> getOpenTransactionMethod() {
    io.grpc.MethodDescriptor<org.example.vcdb.proto.Transaction.openTransactionRequest, org.example.vcdb.proto.Version.intReply> getOpenTransactionMethod;
    if ((getOpenTransactionMethod = transactionServiceGrpc.getOpenTransactionMethod) == null) {
      synchronized (transactionServiceGrpc.class) {
        if ((getOpenTransactionMethod = transactionServiceGrpc.getOpenTransactionMethod) == null) {
          transactionServiceGrpc.getOpenTransactionMethod = getOpenTransactionMethod =
              io.grpc.MethodDescriptor.<org.example.vcdb.proto.Transaction.openTransactionRequest, org.example.vcdb.proto.Version.intReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "openTransaction"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.vcdb.proto.Transaction.openTransactionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.vcdb.proto.Version.intReply.getDefaultInstance()))
              .setSchemaDescriptor(new transactionServiceMethodDescriptorSupplier("openTransaction"))
              .build();
        }
      }
    }
    return getOpenTransactionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      org.example.vcdb.proto.Version.intReply> getCloseTransactionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "closeTransaction",
      requestType = com.google.protobuf.Empty.class,
      responseType = org.example.vcdb.proto.Version.intReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      org.example.vcdb.proto.Version.intReply> getCloseTransactionMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, org.example.vcdb.proto.Version.intReply> getCloseTransactionMethod;
    if ((getCloseTransactionMethod = transactionServiceGrpc.getCloseTransactionMethod) == null) {
      synchronized (transactionServiceGrpc.class) {
        if ((getCloseTransactionMethod = transactionServiceGrpc.getCloseTransactionMethod) == null) {
          transactionServiceGrpc.getCloseTransactionMethod = getCloseTransactionMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, org.example.vcdb.proto.Version.intReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "closeTransaction"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.vcdb.proto.Version.intReply.getDefaultInstance()))
              .setSchemaDescriptor(new transactionServiceMethodDescriptorSupplier("closeTransaction"))
              .build();
        }
      }
    }
    return getCloseTransactionMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static transactionServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<transactionServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<transactionServiceStub>() {
        @java.lang.Override
        public transactionServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new transactionServiceStub(channel, callOptions);
        }
      };
    return transactionServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static transactionServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<transactionServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<transactionServiceBlockingStub>() {
        @java.lang.Override
        public transactionServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new transactionServiceBlockingStub(channel, callOptions);
        }
      };
    return transactionServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static transactionServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<transactionServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<transactionServiceFutureStub>() {
        @java.lang.Override
        public transactionServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new transactionServiceFutureStub(channel, callOptions);
        }
      };
    return transactionServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * 对外提供的接口
   * </pre>
   */
  public static abstract class transactionServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * getRegionMeta 方法名，google.protobuf.Empt 传入参数为空， regionMeta  返回响应类
     * </pre>
     */
    public void openTransaction(org.example.vcdb.proto.Transaction.openTransactionRequest request,
        io.grpc.stub.StreamObserver<org.example.vcdb.proto.Version.intReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getOpenTransactionMethod(), responseObserver);
    }

    /**
     */
    public void closeTransaction(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<org.example.vcdb.proto.Version.intReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCloseTransactionMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getOpenTransactionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.example.vcdb.proto.Transaction.openTransactionRequest,
                org.example.vcdb.proto.Version.intReply>(
                  this, METHODID_OPEN_TRANSACTION)))
          .addMethod(
            getCloseTransactionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                org.example.vcdb.proto.Version.intReply>(
                  this, METHODID_CLOSE_TRANSACTION)))
          .build();
    }
  }

  /**
   * <pre>
   * 对外提供的接口
   * </pre>
   */
  public static final class transactionServiceStub extends io.grpc.stub.AbstractAsyncStub<transactionServiceStub> {
    private transactionServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected transactionServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new transactionServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * getRegionMeta 方法名，google.protobuf.Empt 传入参数为空， regionMeta  返回响应类
     * </pre>
     */
    public void openTransaction(org.example.vcdb.proto.Transaction.openTransactionRequest request,
        io.grpc.stub.StreamObserver<org.example.vcdb.proto.Version.intReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getOpenTransactionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void closeTransaction(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<org.example.vcdb.proto.Version.intReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCloseTransactionMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * 对外提供的接口
   * </pre>
   */
  public static final class transactionServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<transactionServiceBlockingStub> {
    private transactionServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected transactionServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new transactionServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * getRegionMeta 方法名，google.protobuf.Empt 传入参数为空， regionMeta  返回响应类
     * </pre>
     */
    public org.example.vcdb.proto.Version.intReply openTransaction(org.example.vcdb.proto.Transaction.openTransactionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOpenTransactionMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.example.vcdb.proto.Version.intReply closeTransaction(com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCloseTransactionMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * 对外提供的接口
   * </pre>
   */
  public static final class transactionServiceFutureStub extends io.grpc.stub.AbstractFutureStub<transactionServiceFutureStub> {
    private transactionServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected transactionServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new transactionServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * getRegionMeta 方法名，google.protobuf.Empt 传入参数为空， regionMeta  返回响应类
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.example.vcdb.proto.Version.intReply> openTransaction(
        org.example.vcdb.proto.Transaction.openTransactionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getOpenTransactionMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.example.vcdb.proto.Version.intReply> closeTransaction(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCloseTransactionMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_OPEN_TRANSACTION = 0;
  private static final int METHODID_CLOSE_TRANSACTION = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final transactionServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(transactionServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_OPEN_TRANSACTION:
          serviceImpl.openTransaction((org.example.vcdb.proto.Transaction.openTransactionRequest) request,
              (io.grpc.stub.StreamObserver<org.example.vcdb.proto.Version.intReply>) responseObserver);
          break;
        case METHODID_CLOSE_TRANSACTION:
          serviceImpl.closeTransaction((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<org.example.vcdb.proto.Version.intReply>) responseObserver);
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

  private static abstract class transactionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    transactionServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.example.vcdb.proto.Transaction.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("transactionService");
    }
  }

  private static final class transactionServiceFileDescriptorSupplier
      extends transactionServiceBaseDescriptorSupplier {
    transactionServiceFileDescriptorSupplier() {}
  }

  private static final class transactionServiceMethodDescriptorSupplier
      extends transactionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    transactionServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (transactionServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new transactionServiceFileDescriptorSupplier())
              .addMethod(getOpenTransactionMethod())
              .addMethod(getCloseTransactionMethod())
              .build();
        }
      }
    }
    return result;
  }
}
