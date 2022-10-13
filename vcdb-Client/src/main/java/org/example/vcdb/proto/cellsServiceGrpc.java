package org.example.vcdb.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.39.0)",
    comments = "Source: Cells.proto")
public final class cellsServiceGrpc {

  private cellsServiceGrpc() {}

  public static final String SERVICE_NAME = "Cells.cellsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<org.example.vcdb.proto.Cells.putCellsRequest,
      org.example.vcdb.proto.Version.intReply> getPutCellsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "putCells",
      requestType = org.example.vcdb.proto.Cells.putCellsRequest.class,
      responseType = org.example.vcdb.proto.Version.intReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.example.vcdb.proto.Cells.putCellsRequest,
      org.example.vcdb.proto.Version.intReply> getPutCellsMethod() {
    io.grpc.MethodDescriptor<org.example.vcdb.proto.Cells.putCellsRequest, org.example.vcdb.proto.Version.intReply> getPutCellsMethod;
    if ((getPutCellsMethod = cellsServiceGrpc.getPutCellsMethod) == null) {
      synchronized (cellsServiceGrpc.class) {
        if ((getPutCellsMethod = cellsServiceGrpc.getPutCellsMethod) == null) {
          cellsServiceGrpc.getPutCellsMethod = getPutCellsMethod =
              io.grpc.MethodDescriptor.<org.example.vcdb.proto.Cells.putCellsRequest, org.example.vcdb.proto.Version.intReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "putCells"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.vcdb.proto.Cells.putCellsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.vcdb.proto.Version.intReply.getDefaultInstance()))
              .setSchemaDescriptor(new cellsServiceMethodDescriptorSupplier("putCells"))
              .build();
        }
      }
    }
    return getPutCellsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.example.vcdb.proto.Cells.deleteCellsRequest,
      org.example.vcdb.proto.Version.intReply> getDeleteCellsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteCells",
      requestType = org.example.vcdb.proto.Cells.deleteCellsRequest.class,
      responseType = org.example.vcdb.proto.Version.intReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.example.vcdb.proto.Cells.deleteCellsRequest,
      org.example.vcdb.proto.Version.intReply> getDeleteCellsMethod() {
    io.grpc.MethodDescriptor<org.example.vcdb.proto.Cells.deleteCellsRequest, org.example.vcdb.proto.Version.intReply> getDeleteCellsMethod;
    if ((getDeleteCellsMethod = cellsServiceGrpc.getDeleteCellsMethod) == null) {
      synchronized (cellsServiceGrpc.class) {
        if ((getDeleteCellsMethod = cellsServiceGrpc.getDeleteCellsMethod) == null) {
          cellsServiceGrpc.getDeleteCellsMethod = getDeleteCellsMethod =
              io.grpc.MethodDescriptor.<org.example.vcdb.proto.Cells.deleteCellsRequest, org.example.vcdb.proto.Version.intReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteCells"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.vcdb.proto.Cells.deleteCellsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.vcdb.proto.Version.intReply.getDefaultInstance()))
              .setSchemaDescriptor(new cellsServiceMethodDescriptorSupplier("deleteCells"))
              .build();
        }
      }
    }
    return getDeleteCellsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.example.vcdb.proto.Cells.updateCellsRequest,
      org.example.vcdb.proto.Version.intReply> getUpdateCellsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateCells",
      requestType = org.example.vcdb.proto.Cells.updateCellsRequest.class,
      responseType = org.example.vcdb.proto.Version.intReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.example.vcdb.proto.Cells.updateCellsRequest,
      org.example.vcdb.proto.Version.intReply> getUpdateCellsMethod() {
    io.grpc.MethodDescriptor<org.example.vcdb.proto.Cells.updateCellsRequest, org.example.vcdb.proto.Version.intReply> getUpdateCellsMethod;
    if ((getUpdateCellsMethod = cellsServiceGrpc.getUpdateCellsMethod) == null) {
      synchronized (cellsServiceGrpc.class) {
        if ((getUpdateCellsMethod = cellsServiceGrpc.getUpdateCellsMethod) == null) {
          cellsServiceGrpc.getUpdateCellsMethod = getUpdateCellsMethod =
              io.grpc.MethodDescriptor.<org.example.vcdb.proto.Cells.updateCellsRequest, org.example.vcdb.proto.Version.intReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "updateCells"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.vcdb.proto.Cells.updateCellsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.vcdb.proto.Version.intReply.getDefaultInstance()))
              .setSchemaDescriptor(new cellsServiceMethodDescriptorSupplier("updateCells"))
              .build();
        }
      }
    }
    return getUpdateCellsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static cellsServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<cellsServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<cellsServiceStub>() {
        @java.lang.Override
        public cellsServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new cellsServiceStub(channel, callOptions);
        }
      };
    return cellsServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static cellsServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<cellsServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<cellsServiceBlockingStub>() {
        @java.lang.Override
        public cellsServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new cellsServiceBlockingStub(channel, callOptions);
        }
      };
    return cellsServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static cellsServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<cellsServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<cellsServiceFutureStub>() {
        @java.lang.Override
        public cellsServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new cellsServiceFutureStub(channel, callOptions);
        }
      };
    return cellsServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class cellsServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void putCells(org.example.vcdb.proto.Cells.putCellsRequest request,
        io.grpc.stub.StreamObserver<org.example.vcdb.proto.Version.intReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPutCellsMethod(), responseObserver);
    }

    /**
     */
    public void deleteCells(org.example.vcdb.proto.Cells.deleteCellsRequest request,
        io.grpc.stub.StreamObserver<org.example.vcdb.proto.Version.intReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteCellsMethod(), responseObserver);
    }

    /**
     */
    public void updateCells(org.example.vcdb.proto.Cells.updateCellsRequest request,
        io.grpc.stub.StreamObserver<org.example.vcdb.proto.Version.intReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateCellsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getPutCellsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.example.vcdb.proto.Cells.putCellsRequest,
                org.example.vcdb.proto.Version.intReply>(
                  this, METHODID_PUT_CELLS)))
          .addMethod(
            getDeleteCellsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.example.vcdb.proto.Cells.deleteCellsRequest,
                org.example.vcdb.proto.Version.intReply>(
                  this, METHODID_DELETE_CELLS)))
          .addMethod(
            getUpdateCellsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.example.vcdb.proto.Cells.updateCellsRequest,
                org.example.vcdb.proto.Version.intReply>(
                  this, METHODID_UPDATE_CELLS)))
          .build();
    }
  }

  /**
   */
  public static final class cellsServiceStub extends io.grpc.stub.AbstractAsyncStub<cellsServiceStub> {
    private cellsServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected cellsServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new cellsServiceStub(channel, callOptions);
    }

    /**
     */
    public void putCells(org.example.vcdb.proto.Cells.putCellsRequest request,
        io.grpc.stub.StreamObserver<org.example.vcdb.proto.Version.intReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPutCellsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteCells(org.example.vcdb.proto.Cells.deleteCellsRequest request,
        io.grpc.stub.StreamObserver<org.example.vcdb.proto.Version.intReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteCellsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateCells(org.example.vcdb.proto.Cells.updateCellsRequest request,
        io.grpc.stub.StreamObserver<org.example.vcdb.proto.Version.intReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateCellsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class cellsServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<cellsServiceBlockingStub> {
    private cellsServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected cellsServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new cellsServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public org.example.vcdb.proto.Version.intReply putCells(org.example.vcdb.proto.Cells.putCellsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPutCellsMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.example.vcdb.proto.Version.intReply deleteCells(org.example.vcdb.proto.Cells.deleteCellsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteCellsMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.example.vcdb.proto.Version.intReply updateCells(org.example.vcdb.proto.Cells.updateCellsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateCellsMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class cellsServiceFutureStub extends io.grpc.stub.AbstractFutureStub<cellsServiceFutureStub> {
    private cellsServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected cellsServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new cellsServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.example.vcdb.proto.Version.intReply> putCells(
        org.example.vcdb.proto.Cells.putCellsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPutCellsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.example.vcdb.proto.Version.intReply> deleteCells(
        org.example.vcdb.proto.Cells.deleteCellsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteCellsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.example.vcdb.proto.Version.intReply> updateCells(
        org.example.vcdb.proto.Cells.updateCellsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateCellsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_PUT_CELLS = 0;
  private static final int METHODID_DELETE_CELLS = 1;
  private static final int METHODID_UPDATE_CELLS = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final cellsServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(cellsServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PUT_CELLS:
          serviceImpl.putCells((org.example.vcdb.proto.Cells.putCellsRequest) request,
              (io.grpc.stub.StreamObserver<org.example.vcdb.proto.Version.intReply>) responseObserver);
          break;
        case METHODID_DELETE_CELLS:
          serviceImpl.deleteCells((org.example.vcdb.proto.Cells.deleteCellsRequest) request,
              (io.grpc.stub.StreamObserver<org.example.vcdb.proto.Version.intReply>) responseObserver);
          break;
        case METHODID_UPDATE_CELLS:
          serviceImpl.updateCells((org.example.vcdb.proto.Cells.updateCellsRequest) request,
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

  private static abstract class cellsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    cellsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.example.vcdb.proto.Cells.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("cellsService");
    }
  }

  private static final class cellsServiceFileDescriptorSupplier
      extends cellsServiceBaseDescriptorSupplier {
    cellsServiceFileDescriptorSupplier() {}
  }

  private static final class cellsServiceMethodDescriptorSupplier
      extends cellsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    cellsServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (cellsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new cellsServiceFileDescriptorSupplier())
              .addMethod(getPutCellsMethod())
              .addMethod(getDeleteCellsMethod())
              .addMethod(getUpdateCellsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
