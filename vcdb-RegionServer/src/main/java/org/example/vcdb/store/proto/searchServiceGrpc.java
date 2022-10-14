package org.example.vcdb.store.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * 对外提供的接口
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.39.0)",
    comments = "Source: Search.proto")
public final class searchServiceGrpc {

  private searchServiceGrpc() {}

  public static final String SERVICE_NAME = "Search.searchService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<org.example.vcdb.store.proto.Search.multiSearchRequest,
      org.example.vcdb.store.proto.Version.bytesReply> getMultiSearchMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "multiSearch",
      requestType = org.example.vcdb.store.proto.Search.multiSearchRequest.class,
      responseType = org.example.vcdb.store.proto.Version.bytesReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.example.vcdb.store.proto.Search.multiSearchRequest,
      org.example.vcdb.store.proto.Version.bytesReply> getMultiSearchMethod() {
    io.grpc.MethodDescriptor<org.example.vcdb.store.proto.Search.multiSearchRequest, org.example.vcdb.store.proto.Version.bytesReply> getMultiSearchMethod;
    if ((getMultiSearchMethod = searchServiceGrpc.getMultiSearchMethod) == null) {
      synchronized (searchServiceGrpc.class) {
        if ((getMultiSearchMethod = searchServiceGrpc.getMultiSearchMethod) == null) {
          searchServiceGrpc.getMultiSearchMethod = getMultiSearchMethod =
              io.grpc.MethodDescriptor.<org.example.vcdb.store.proto.Search.multiSearchRequest, org.example.vcdb.store.proto.Version.bytesReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "multiSearch"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.vcdb.store.proto.Search.multiSearchRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.vcdb.store.proto.Version.bytesReply.getDefaultInstance()))
              .setSchemaDescriptor(new searchServiceMethodDescriptorSupplier("multiSearch"))
              .build();
        }
      }
    }
    return getMultiSearchMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.example.vcdb.store.proto.Search.singleSearchRequest,
      org.example.vcdb.store.proto.Version.bytesReply> getSingleSearchMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "singleSearch",
      requestType = org.example.vcdb.store.proto.Search.singleSearchRequest.class,
      responseType = org.example.vcdb.store.proto.Version.bytesReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.example.vcdb.store.proto.Search.singleSearchRequest,
      org.example.vcdb.store.proto.Version.bytesReply> getSingleSearchMethod() {
    io.grpc.MethodDescriptor<org.example.vcdb.store.proto.Search.singleSearchRequest, org.example.vcdb.store.proto.Version.bytesReply> getSingleSearchMethod;
    if ((getSingleSearchMethod = searchServiceGrpc.getSingleSearchMethod) == null) {
      synchronized (searchServiceGrpc.class) {
        if ((getSingleSearchMethod = searchServiceGrpc.getSingleSearchMethod) == null) {
          searchServiceGrpc.getSingleSearchMethod = getSingleSearchMethod =
              io.grpc.MethodDescriptor.<org.example.vcdb.store.proto.Search.singleSearchRequest, org.example.vcdb.store.proto.Version.bytesReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "singleSearch"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.vcdb.store.proto.Search.singleSearchRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.vcdb.store.proto.Version.bytesReply.getDefaultInstance()))
              .setSchemaDescriptor(new searchServiceMethodDescriptorSupplier("singleSearch"))
              .build();
        }
      }
    }
    return getSingleSearchMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static searchServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<searchServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<searchServiceStub>() {
        @java.lang.Override
        public searchServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new searchServiceStub(channel, callOptions);
        }
      };
    return searchServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static searchServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<searchServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<searchServiceBlockingStub>() {
        @java.lang.Override
        public searchServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new searchServiceBlockingStub(channel, callOptions);
        }
      };
    return searchServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static searchServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<searchServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<searchServiceFutureStub>() {
        @java.lang.Override
        public searchServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new searchServiceFutureStub(channel, callOptions);
        }
      };
    return searchServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * 对外提供的接口
   * </pre>
   */
  public static abstract class searchServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * getRegionMeta 方法名，google.protobuf.Empt 传入参数为空， regionMeta  返回响应类
     * </pre>
     */
    public void multiSearch(org.example.vcdb.store.proto.Search.multiSearchRequest request,
        io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Version.bytesReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getMultiSearchMethod(), responseObserver);
    }

    /**
     */
    public void singleSearch(org.example.vcdb.store.proto.Search.singleSearchRequest request,
        io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Version.bytesReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSingleSearchMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getMultiSearchMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.example.vcdb.store.proto.Search.multiSearchRequest,
                org.example.vcdb.store.proto.Version.bytesReply>(
                  this, METHODID_MULTI_SEARCH)))
          .addMethod(
            getSingleSearchMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.example.vcdb.store.proto.Search.singleSearchRequest,
                org.example.vcdb.store.proto.Version.bytesReply>(
                  this, METHODID_SINGLE_SEARCH)))
          .build();
    }
  }

  /**
   * <pre>
   * 对外提供的接口
   * </pre>
   */
  public static final class searchServiceStub extends io.grpc.stub.AbstractAsyncStub<searchServiceStub> {
    private searchServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected searchServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new searchServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * getRegionMeta 方法名，google.protobuf.Empt 传入参数为空， regionMeta  返回响应类
     * </pre>
     */
    public void multiSearch(org.example.vcdb.store.proto.Search.multiSearchRequest request,
        io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Version.bytesReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getMultiSearchMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void singleSearch(org.example.vcdb.store.proto.Search.singleSearchRequest request,
        io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Version.bytesReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSingleSearchMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * 对外提供的接口
   * </pre>
   */
  public static final class searchServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<searchServiceBlockingStub> {
    private searchServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected searchServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new searchServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * getRegionMeta 方法名，google.protobuf.Empt 传入参数为空， regionMeta  返回响应类
     * </pre>
     */
    public org.example.vcdb.store.proto.Version.bytesReply multiSearch(org.example.vcdb.store.proto.Search.multiSearchRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getMultiSearchMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.example.vcdb.store.proto.Version.bytesReply singleSearch(org.example.vcdb.store.proto.Search.singleSearchRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSingleSearchMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * 对外提供的接口
   * </pre>
   */
  public static final class searchServiceFutureStub extends io.grpc.stub.AbstractFutureStub<searchServiceFutureStub> {
    private searchServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected searchServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new searchServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * getRegionMeta 方法名，google.protobuf.Empt 传入参数为空， regionMeta  返回响应类
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.example.vcdb.store.proto.Version.bytesReply> multiSearch(
        org.example.vcdb.store.proto.Search.multiSearchRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getMultiSearchMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.example.vcdb.store.proto.Version.bytesReply> singleSearch(
        org.example.vcdb.store.proto.Search.singleSearchRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSingleSearchMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_MULTI_SEARCH = 0;
  private static final int METHODID_SINGLE_SEARCH = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final searchServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(searchServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_MULTI_SEARCH:
          serviceImpl.multiSearch((org.example.vcdb.store.proto.Search.multiSearchRequest) request,
              (io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Version.bytesReply>) responseObserver);
          break;
        case METHODID_SINGLE_SEARCH:
          serviceImpl.singleSearch((org.example.vcdb.store.proto.Search.singleSearchRequest) request,
              (io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Version.bytesReply>) responseObserver);
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

  private static abstract class searchServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    searchServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.example.vcdb.store.proto.Search.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("searchService");
    }
  }

  private static final class searchServiceFileDescriptorSupplier
      extends searchServiceBaseDescriptorSupplier {
    searchServiceFileDescriptorSupplier() {}
  }

  private static final class searchServiceMethodDescriptorSupplier
      extends searchServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    searchServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (searchServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new searchServiceFileDescriptorSupplier())
              .addMethod(getMultiSearchMethod())
              .addMethod(getSingleSearchMethod())
              .build();
        }
      }
    }
    return result;
  }
}
