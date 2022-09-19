package org.example.vcdb.PDServer.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * 对外提供的接口
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.39.0)",
    comments = "Source: test.proto")
public final class getRegionMetaGrpc {

  private getRegionMetaGrpc() {}

  public static final String SERVICE_NAME = "getRegionMeta";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      org.example.vcdb.PDServer.proto.Meta.regionMeta> getGetRegionMetaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getRegionMeta",
      requestType = com.google.protobuf.Empty.class,
      responseType = org.example.vcdb.PDServer.proto.Meta.regionMeta.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      org.example.vcdb.PDServer.proto.Meta.regionMeta> getGetRegionMetaMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, org.example.vcdb.PDServer.proto.Meta.regionMeta> getGetRegionMetaMethod;
    if ((getGetRegionMetaMethod = getRegionMetaGrpc.getGetRegionMetaMethod) == null) {
      synchronized (getRegionMetaGrpc.class) {
        if ((getGetRegionMetaMethod = getRegionMetaGrpc.getGetRegionMetaMethod) == null) {
          getRegionMetaGrpc.getGetRegionMetaMethod = getGetRegionMetaMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, org.example.vcdb.PDServer.proto.Meta.regionMeta>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getRegionMeta"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.vcdb.PDServer.proto.Meta.regionMeta.getDefaultInstance()))
              .setSchemaDescriptor(new getRegionMetaMethodDescriptorSupplier("getRegionMeta"))
              .build();
        }
      }
    }
    return getGetRegionMetaMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static getRegionMetaStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<getRegionMetaStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<getRegionMetaStub>() {
        @Override
        public getRegionMetaStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new getRegionMetaStub(channel, callOptions);
        }
      };
    return getRegionMetaStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static getRegionMetaBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<getRegionMetaBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<getRegionMetaBlockingStub>() {
        @Override
        public getRegionMetaBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new getRegionMetaBlockingStub(channel, callOptions);
        }
      };
    return getRegionMetaBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static getRegionMetaFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<getRegionMetaFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<getRegionMetaFutureStub>() {
        @Override
        public getRegionMetaFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new getRegionMetaFutureStub(channel, callOptions);
        }
      };
    return getRegionMetaFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * 对外提供的接口
   * </pre>
   */
  public static abstract class getRegionMetaImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * getRegionMeta 方法名，google.protobuf.Empt 传入参数为空， regionMeta  返回响应类
     * </pre>
     */
    public void getRegionMeta(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<org.example.vcdb.PDServer.proto.Meta.regionMeta> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetRegionMetaMethod(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetRegionMetaMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                org.example.vcdb.PDServer.proto.Meta.regionMeta>(
                  this, METHODID_GET_REGION_META)))
          .build();
    }
  }

  /**
   * <pre>
   * 对外提供的接口
   * </pre>
   */
  public static final class getRegionMetaStub extends io.grpc.stub.AbstractAsyncStub<getRegionMetaStub> {
    private getRegionMetaStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected getRegionMetaStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new getRegionMetaStub(channel, callOptions);
    }

    /**
     * <pre>
     * getRegionMeta 方法名，google.protobuf.Empt 传入参数为空， regionMeta  返回响应类
     * </pre>
     */
    public void getRegionMeta(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<org.example.vcdb.PDServer.proto.Meta.regionMeta> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetRegionMetaMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * 对外提供的接口
   * </pre>
   */
  public static final class getRegionMetaBlockingStub extends io.grpc.stub.AbstractBlockingStub<getRegionMetaBlockingStub> {
    private getRegionMetaBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected getRegionMetaBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new getRegionMetaBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * getRegionMeta 方法名，google.protobuf.Empt 传入参数为空， regionMeta  返回响应类
     * </pre>
     */
    public org.example.vcdb.PDServer.proto.Meta.regionMeta getRegionMeta(com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetRegionMetaMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * 对外提供的接口
   * </pre>
   */
  public static final class getRegionMetaFutureStub extends io.grpc.stub.AbstractFutureStub<getRegionMetaFutureStub> {
    private getRegionMetaFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected getRegionMetaFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new getRegionMetaFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * getRegionMeta 方法名，google.protobuf.Empt 传入参数为空， regionMeta  返回响应类
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.example.vcdb.PDServer.proto.Meta.regionMeta> getRegionMeta(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetRegionMetaMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_REGION_META = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final getRegionMetaImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(getRegionMetaImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_REGION_META:
          serviceImpl.getRegionMeta((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<org.example.vcdb.PDServer.proto.Meta.regionMeta>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @Override
    @SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class getRegionMetaBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    getRegionMetaBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.example.vcdb.PDServer.proto.Meta.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("getRegionMeta");
    }
  }

  private static final class getRegionMetaFileDescriptorSupplier
      extends getRegionMetaBaseDescriptorSupplier {
    getRegionMetaFileDescriptorSupplier() {}
  }

  private static final class getRegionMetaMethodDescriptorSupplier
      extends getRegionMetaBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    getRegionMetaMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (getRegionMetaGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new getRegionMetaFileDescriptorSupplier())
              .addMethod(getGetRegionMetaMethod())
              .build();
        }
      }
    }
    return result;
  }
}
