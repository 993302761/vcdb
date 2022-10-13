package org.example.vcdb.store.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * 对外提供的接口
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.39.0)",
    comments = "Source: Table.proto")
public final class tableServiceGrpc {

  private tableServiceGrpc() {}

  public static final String SERVICE_NAME = "Table.tableService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<org.example.vcdb.store.proto.Table.createRequest,
      org.example.vcdb.store.proto.Version.intReply> getCreateTableMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "createTable",
      requestType = org.example.vcdb.store.proto.Table.createRequest.class,
      responseType = org.example.vcdb.store.proto.Version.intReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.example.vcdb.store.proto.Table.createRequest,
      org.example.vcdb.store.proto.Version.intReply> getCreateTableMethod() {
    io.grpc.MethodDescriptor<org.example.vcdb.store.proto.Table.createRequest, org.example.vcdb.store.proto.Version.intReply> getCreateTableMethod;
    if ((getCreateTableMethod = tableServiceGrpc.getCreateTableMethod) == null) {
      synchronized (tableServiceGrpc.class) {
        if ((getCreateTableMethod = tableServiceGrpc.getCreateTableMethod) == null) {
          tableServiceGrpc.getCreateTableMethod = getCreateTableMethod =
              io.grpc.MethodDescriptor.<org.example.vcdb.store.proto.Table.createRequest, org.example.vcdb.store.proto.Version.intReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "createTable"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.vcdb.store.proto.Table.createRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.vcdb.store.proto.Version.intReply.getDefaultInstance()))
              .setSchemaDescriptor(new tableServiceMethodDescriptorSupplier("createTable"))
              .build();
        }
      }
    }
    return getCreateTableMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.example.vcdb.store.proto.Table.alterRequest,
      org.example.vcdb.store.proto.Version.intReply> getAlterTableMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "alterTable",
      requestType = org.example.vcdb.store.proto.Table.alterRequest.class,
      responseType = org.example.vcdb.store.proto.Version.intReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.example.vcdb.store.proto.Table.alterRequest,
      org.example.vcdb.store.proto.Version.intReply> getAlterTableMethod() {
    io.grpc.MethodDescriptor<org.example.vcdb.store.proto.Table.alterRequest, org.example.vcdb.store.proto.Version.intReply> getAlterTableMethod;
    if ((getAlterTableMethod = tableServiceGrpc.getAlterTableMethod) == null) {
      synchronized (tableServiceGrpc.class) {
        if ((getAlterTableMethod = tableServiceGrpc.getAlterTableMethod) == null) {
          tableServiceGrpc.getAlterTableMethod = getAlterTableMethod =
              io.grpc.MethodDescriptor.<org.example.vcdb.store.proto.Table.alterRequest, org.example.vcdb.store.proto.Version.intReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "alterTable"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.vcdb.store.proto.Table.alterRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.vcdb.store.proto.Version.intReply.getDefaultInstance()))
              .setSchemaDescriptor(new tableServiceMethodDescriptorSupplier("alterTable"))
              .build();
        }
      }
    }
    return getAlterTableMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.example.vcdb.store.proto.Table.deleteRequest,
      org.example.vcdb.store.proto.Version.intReply> getDeleteTableMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteTable",
      requestType = org.example.vcdb.store.proto.Table.deleteRequest.class,
      responseType = org.example.vcdb.store.proto.Version.intReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.example.vcdb.store.proto.Table.deleteRequest,
      org.example.vcdb.store.proto.Version.intReply> getDeleteTableMethod() {
    io.grpc.MethodDescriptor<org.example.vcdb.store.proto.Table.deleteRequest, org.example.vcdb.store.proto.Version.intReply> getDeleteTableMethod;
    if ((getDeleteTableMethod = tableServiceGrpc.getDeleteTableMethod) == null) {
      synchronized (tableServiceGrpc.class) {
        if ((getDeleteTableMethod = tableServiceGrpc.getDeleteTableMethod) == null) {
          tableServiceGrpc.getDeleteTableMethod = getDeleteTableMethod =
              io.grpc.MethodDescriptor.<org.example.vcdb.store.proto.Table.deleteRequest, org.example.vcdb.store.proto.Version.intReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteTable"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.vcdb.store.proto.Table.deleteRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.vcdb.store.proto.Version.intReply.getDefaultInstance()))
              .setSchemaDescriptor(new tableServiceMethodDescriptorSupplier("deleteTable"))
              .build();
        }
      }
    }
    return getDeleteTableMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static tableServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<tableServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<tableServiceStub>() {
        @java.lang.Override
        public tableServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new tableServiceStub(channel, callOptions);
        }
      };
    return tableServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static tableServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<tableServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<tableServiceBlockingStub>() {
        @java.lang.Override
        public tableServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new tableServiceBlockingStub(channel, callOptions);
        }
      };
    return tableServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static tableServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<tableServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<tableServiceFutureStub>() {
        @java.lang.Override
        public tableServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new tableServiceFutureStub(channel, callOptions);
        }
      };
    return tableServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * 对外提供的接口
   * </pre>
   */
  public static abstract class tableServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * getRegionMeta 方法名，google.protobuf.Empt 传入参数为空， regionMeta  返回响应类
     * </pre>
     */
    public void createTable(org.example.vcdb.store.proto.Table.createRequest request,
        io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Version.intReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateTableMethod(), responseObserver);
    }

    /**
     */
    public void alterTable(org.example.vcdb.store.proto.Table.alterRequest request,
        io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Version.intReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAlterTableMethod(), responseObserver);
    }

    /**
     */
    public void deleteTable(org.example.vcdb.store.proto.Table.deleteRequest request,
        io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Version.intReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteTableMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateTableMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.example.vcdb.store.proto.Table.createRequest,
                org.example.vcdb.store.proto.Version.intReply>(
                  this, METHODID_CREATE_TABLE)))
          .addMethod(
            getAlterTableMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.example.vcdb.store.proto.Table.alterRequest,
                org.example.vcdb.store.proto.Version.intReply>(
                  this, METHODID_ALTER_TABLE)))
          .addMethod(
            getDeleteTableMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.example.vcdb.store.proto.Table.deleteRequest,
                org.example.vcdb.store.proto.Version.intReply>(
                  this, METHODID_DELETE_TABLE)))
          .build();
    }
  }

  /**
   * <pre>
   * 对外提供的接口
   * </pre>
   */
  public static final class tableServiceStub extends io.grpc.stub.AbstractAsyncStub<tableServiceStub> {
    private tableServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected tableServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new tableServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * getRegionMeta 方法名，google.protobuf.Empt 传入参数为空， regionMeta  返回响应类
     * </pre>
     */
    public void createTable(org.example.vcdb.store.proto.Table.createRequest request,
        io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Version.intReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateTableMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void alterTable(org.example.vcdb.store.proto.Table.alterRequest request,
        io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Version.intReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAlterTableMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteTable(org.example.vcdb.store.proto.Table.deleteRequest request,
        io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Version.intReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteTableMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * 对外提供的接口
   * </pre>
   */
  public static final class tableServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<tableServiceBlockingStub> {
    private tableServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected tableServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new tableServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * getRegionMeta 方法名，google.protobuf.Empt 传入参数为空， regionMeta  返回响应类
     * </pre>
     */
    public org.example.vcdb.store.proto.Version.intReply createTable(org.example.vcdb.store.proto.Table.createRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateTableMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.example.vcdb.store.proto.Version.intReply alterTable(org.example.vcdb.store.proto.Table.alterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAlterTableMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.example.vcdb.store.proto.Version.intReply deleteTable(org.example.vcdb.store.proto.Table.deleteRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteTableMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * 对外提供的接口
   * </pre>
   */
  public static final class tableServiceFutureStub extends io.grpc.stub.AbstractFutureStub<tableServiceFutureStub> {
    private tableServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected tableServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new tableServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * getRegionMeta 方法名，google.protobuf.Empt 传入参数为空， regionMeta  返回响应类
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.example.vcdb.store.proto.Version.intReply> createTable(
        org.example.vcdb.store.proto.Table.createRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateTableMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.example.vcdb.store.proto.Version.intReply> alterTable(
        org.example.vcdb.store.proto.Table.alterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAlterTableMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.example.vcdb.store.proto.Version.intReply> deleteTable(
        org.example.vcdb.store.proto.Table.deleteRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteTableMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_TABLE = 0;
  private static final int METHODID_ALTER_TABLE = 1;
  private static final int METHODID_DELETE_TABLE = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final tableServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(tableServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_TABLE:
          serviceImpl.createTable((org.example.vcdb.store.proto.Table.createRequest) request,
              (io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Version.intReply>) responseObserver);
          break;
        case METHODID_ALTER_TABLE:
          serviceImpl.alterTable((org.example.vcdb.store.proto.Table.alterRequest) request,
              (io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Version.intReply>) responseObserver);
          break;
        case METHODID_DELETE_TABLE:
          serviceImpl.deleteTable((org.example.vcdb.store.proto.Table.deleteRequest) request,
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

  private static abstract class tableServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    tableServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.example.vcdb.store.proto.Table.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("tableService");
    }
  }

  private static final class tableServiceFileDescriptorSupplier
      extends tableServiceBaseDescriptorSupplier {
    tableServiceFileDescriptorSupplier() {}
  }

  private static final class tableServiceMethodDescriptorSupplier
      extends tableServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    tableServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (tableServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new tableServiceFileDescriptorSupplier())
              .addMethod(getCreateTableMethod())
              .addMethod(getAlterTableMethod())
              .addMethod(getDeleteTableMethod())
              .build();
        }
      }
    }
    return result;
  }
}
