package org.example.vcdb.store.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * 对外提供的接口
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.39.0)",
    comments = "Source: RegionServerApi.proto")
public final class RegionServerGrpc {

  private RegionServerGrpc() {}

  public static final String SERVICE_NAME = "Region.RegionServer";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<org.example.vcdb.store.proto.Region.dbNameRequest,
      org.example.vcdb.store.proto.Region.boolReply> getCreateDBMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "createDB",
      requestType = org.example.vcdb.store.proto.Region.dbNameRequest.class,
      responseType = org.example.vcdb.store.proto.Region.boolReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.example.vcdb.store.proto.Region.dbNameRequest,
      org.example.vcdb.store.proto.Region.boolReply> getCreateDBMethod() {
    io.grpc.MethodDescriptor<org.example.vcdb.store.proto.Region.dbNameRequest, org.example.vcdb.store.proto.Region.boolReply> getCreateDBMethod;
    if ((getCreateDBMethod = RegionServerGrpc.getCreateDBMethod) == null) {
      synchronized (RegionServerGrpc.class) {
        if ((getCreateDBMethod = RegionServerGrpc.getCreateDBMethod) == null) {
          RegionServerGrpc.getCreateDBMethod = getCreateDBMethod =
              io.grpc.MethodDescriptor.<org.example.vcdb.store.proto.Region.dbNameRequest, org.example.vcdb.store.proto.Region.boolReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "createDB"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.vcdb.store.proto.Region.dbNameRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.vcdb.store.proto.Region.boolReply.getDefaultInstance()))
              .setSchemaDescriptor(new RegionServerMethodDescriptorSupplier("createDB"))
              .build();
        }
      }
    }
    return getCreateDBMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.example.vcdb.store.proto.Region.dbNameRequest,
      org.example.vcdb.store.proto.Region.boolReply> getDeleteDBMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteDB",
      requestType = org.example.vcdb.store.proto.Region.dbNameRequest.class,
      responseType = org.example.vcdb.store.proto.Region.boolReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.example.vcdb.store.proto.Region.dbNameRequest,
      org.example.vcdb.store.proto.Region.boolReply> getDeleteDBMethod() {
    io.grpc.MethodDescriptor<org.example.vcdb.store.proto.Region.dbNameRequest, org.example.vcdb.store.proto.Region.boolReply> getDeleteDBMethod;
    if ((getDeleteDBMethod = RegionServerGrpc.getDeleteDBMethod) == null) {
      synchronized (RegionServerGrpc.class) {
        if ((getDeleteDBMethod = RegionServerGrpc.getDeleteDBMethod) == null) {
          RegionServerGrpc.getDeleteDBMethod = getDeleteDBMethod =
              io.grpc.MethodDescriptor.<org.example.vcdb.store.proto.Region.dbNameRequest, org.example.vcdb.store.proto.Region.boolReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteDB"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.vcdb.store.proto.Region.dbNameRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.vcdb.store.proto.Region.boolReply.getDefaultInstance()))
              .setSchemaDescriptor(new RegionServerMethodDescriptorSupplier("deleteDB"))
              .build();
        }
      }
    }
    return getDeleteDBMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      org.example.vcdb.store.proto.Region.bytesReply> getShowDataBasesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "showDataBases",
      requestType = com.google.protobuf.Empty.class,
      responseType = org.example.vcdb.store.proto.Region.bytesReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      org.example.vcdb.store.proto.Region.bytesReply> getShowDataBasesMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, org.example.vcdb.store.proto.Region.bytesReply> getShowDataBasesMethod;
    if ((getShowDataBasesMethod = RegionServerGrpc.getShowDataBasesMethod) == null) {
      synchronized (RegionServerGrpc.class) {
        if ((getShowDataBasesMethod = RegionServerGrpc.getShowDataBasesMethod) == null) {
          RegionServerGrpc.getShowDataBasesMethod = getShowDataBasesMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, org.example.vcdb.store.proto.Region.bytesReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "showDataBases"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.vcdb.store.proto.Region.bytesReply.getDefaultInstance()))
              .setSchemaDescriptor(new RegionServerMethodDescriptorSupplier("showDataBases"))
              .build();
        }
      }
    }
    return getShowDataBasesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.example.vcdb.store.proto.Region.putCellsRequest,
      org.example.vcdb.store.proto.Region.intReply> getPutCellsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "putCells",
      requestType = org.example.vcdb.store.proto.Region.putCellsRequest.class,
      responseType = org.example.vcdb.store.proto.Region.intReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.example.vcdb.store.proto.Region.putCellsRequest,
      org.example.vcdb.store.proto.Region.intReply> getPutCellsMethod() {
    io.grpc.MethodDescriptor<org.example.vcdb.store.proto.Region.putCellsRequest, org.example.vcdb.store.proto.Region.intReply> getPutCellsMethod;
    if ((getPutCellsMethod = RegionServerGrpc.getPutCellsMethod) == null) {
      synchronized (RegionServerGrpc.class) {
        if ((getPutCellsMethod = RegionServerGrpc.getPutCellsMethod) == null) {
          RegionServerGrpc.getPutCellsMethod = getPutCellsMethod =
              io.grpc.MethodDescriptor.<org.example.vcdb.store.proto.Region.putCellsRequest, org.example.vcdb.store.proto.Region.intReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "putCells"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.vcdb.store.proto.Region.putCellsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.vcdb.store.proto.Region.intReply.getDefaultInstance()))
              .setSchemaDescriptor(new RegionServerMethodDescriptorSupplier("putCells"))
              .build();
        }
      }
    }
    return getPutCellsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.example.vcdb.store.proto.Region.deleteCellsRequest,
      org.example.vcdb.store.proto.Region.intReply> getDeleteCellsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteCells",
      requestType = org.example.vcdb.store.proto.Region.deleteCellsRequest.class,
      responseType = org.example.vcdb.store.proto.Region.intReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.example.vcdb.store.proto.Region.deleteCellsRequest,
      org.example.vcdb.store.proto.Region.intReply> getDeleteCellsMethod() {
    io.grpc.MethodDescriptor<org.example.vcdb.store.proto.Region.deleteCellsRequest, org.example.vcdb.store.proto.Region.intReply> getDeleteCellsMethod;
    if ((getDeleteCellsMethod = RegionServerGrpc.getDeleteCellsMethod) == null) {
      synchronized (RegionServerGrpc.class) {
        if ((getDeleteCellsMethod = RegionServerGrpc.getDeleteCellsMethod) == null) {
          RegionServerGrpc.getDeleteCellsMethod = getDeleteCellsMethod =
              io.grpc.MethodDescriptor.<org.example.vcdb.store.proto.Region.deleteCellsRequest, org.example.vcdb.store.proto.Region.intReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteCells"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.vcdb.store.proto.Region.deleteCellsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.vcdb.store.proto.Region.intReply.getDefaultInstance()))
              .setSchemaDescriptor(new RegionServerMethodDescriptorSupplier("deleteCells"))
              .build();
        }
      }
    }
    return getDeleteCellsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.example.vcdb.store.proto.Region.updateCellsRequest,
      org.example.vcdb.store.proto.Region.intReply> getUpdateCellsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateCells",
      requestType = org.example.vcdb.store.proto.Region.updateCellsRequest.class,
      responseType = org.example.vcdb.store.proto.Region.intReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.example.vcdb.store.proto.Region.updateCellsRequest,
      org.example.vcdb.store.proto.Region.intReply> getUpdateCellsMethod() {
    io.grpc.MethodDescriptor<org.example.vcdb.store.proto.Region.updateCellsRequest, org.example.vcdb.store.proto.Region.intReply> getUpdateCellsMethod;
    if ((getUpdateCellsMethod = RegionServerGrpc.getUpdateCellsMethod) == null) {
      synchronized (RegionServerGrpc.class) {
        if ((getUpdateCellsMethod = RegionServerGrpc.getUpdateCellsMethod) == null) {
          RegionServerGrpc.getUpdateCellsMethod = getUpdateCellsMethod =
              io.grpc.MethodDescriptor.<org.example.vcdb.store.proto.Region.updateCellsRequest, org.example.vcdb.store.proto.Region.intReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "updateCells"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.vcdb.store.proto.Region.updateCellsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.vcdb.store.proto.Region.intReply.getDefaultInstance()))
              .setSchemaDescriptor(new RegionServerMethodDescriptorSupplier("updateCells"))
              .build();
        }
      }
    }
    return getUpdateCellsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.example.vcdb.store.proto.Region.multiSearchRequest,
      org.example.vcdb.store.proto.Region.bytesReply> getMultiSearchMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "multiSearch",
      requestType = org.example.vcdb.store.proto.Region.multiSearchRequest.class,
      responseType = org.example.vcdb.store.proto.Region.bytesReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.example.vcdb.store.proto.Region.multiSearchRequest,
      org.example.vcdb.store.proto.Region.bytesReply> getMultiSearchMethod() {
    io.grpc.MethodDescriptor<org.example.vcdb.store.proto.Region.multiSearchRequest, org.example.vcdb.store.proto.Region.bytesReply> getMultiSearchMethod;
    if ((getMultiSearchMethod = RegionServerGrpc.getMultiSearchMethod) == null) {
      synchronized (RegionServerGrpc.class) {
        if ((getMultiSearchMethod = RegionServerGrpc.getMultiSearchMethod) == null) {
          RegionServerGrpc.getMultiSearchMethod = getMultiSearchMethod =
              io.grpc.MethodDescriptor.<org.example.vcdb.store.proto.Region.multiSearchRequest, org.example.vcdb.store.proto.Region.bytesReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "multiSearch"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.vcdb.store.proto.Region.multiSearchRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.vcdb.store.proto.Region.bytesReply.getDefaultInstance()))
              .setSchemaDescriptor(new RegionServerMethodDescriptorSupplier("multiSearch"))
              .build();
        }
      }
    }
    return getMultiSearchMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.example.vcdb.store.proto.Region.singleSearchRequest,
      org.example.vcdb.store.proto.Region.bytesReply> getSingleSearchMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "singleSearch",
      requestType = org.example.vcdb.store.proto.Region.singleSearchRequest.class,
      responseType = org.example.vcdb.store.proto.Region.bytesReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.example.vcdb.store.proto.Region.singleSearchRequest,
      org.example.vcdb.store.proto.Region.bytesReply> getSingleSearchMethod() {
    io.grpc.MethodDescriptor<org.example.vcdb.store.proto.Region.singleSearchRequest, org.example.vcdb.store.proto.Region.bytesReply> getSingleSearchMethod;
    if ((getSingleSearchMethod = RegionServerGrpc.getSingleSearchMethod) == null) {
      synchronized (RegionServerGrpc.class) {
        if ((getSingleSearchMethod = RegionServerGrpc.getSingleSearchMethod) == null) {
          RegionServerGrpc.getSingleSearchMethod = getSingleSearchMethod =
              io.grpc.MethodDescriptor.<org.example.vcdb.store.proto.Region.singleSearchRequest, org.example.vcdb.store.proto.Region.bytesReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "singleSearch"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.vcdb.store.proto.Region.singleSearchRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.vcdb.store.proto.Region.bytesReply.getDefaultInstance()))
              .setSchemaDescriptor(new RegionServerMethodDescriptorSupplier("singleSearch"))
              .build();
        }
      }
    }
    return getSingleSearchMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.example.vcdb.store.proto.Region.tableRequest,
      org.example.vcdb.store.proto.Region.boolReply> getCreateTableMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "createTable",
      requestType = org.example.vcdb.store.proto.Region.tableRequest.class,
      responseType = org.example.vcdb.store.proto.Region.boolReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.example.vcdb.store.proto.Region.tableRequest,
      org.example.vcdb.store.proto.Region.boolReply> getCreateTableMethod() {
    io.grpc.MethodDescriptor<org.example.vcdb.store.proto.Region.tableRequest, org.example.vcdb.store.proto.Region.boolReply> getCreateTableMethod;
    if ((getCreateTableMethod = RegionServerGrpc.getCreateTableMethod) == null) {
      synchronized (RegionServerGrpc.class) {
        if ((getCreateTableMethod = RegionServerGrpc.getCreateTableMethod) == null) {
          RegionServerGrpc.getCreateTableMethod = getCreateTableMethod =
              io.grpc.MethodDescriptor.<org.example.vcdb.store.proto.Region.tableRequest, org.example.vcdb.store.proto.Region.boolReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "createTable"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.vcdb.store.proto.Region.tableRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.vcdb.store.proto.Region.boolReply.getDefaultInstance()))
              .setSchemaDescriptor(new RegionServerMethodDescriptorSupplier("createTable"))
              .build();
        }
      }
    }
    return getCreateTableMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.example.vcdb.store.proto.Region.tableRequest,
      org.example.vcdb.store.proto.Region.boolReply> getAlterTableMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "alterTable",
      requestType = org.example.vcdb.store.proto.Region.tableRequest.class,
      responseType = org.example.vcdb.store.proto.Region.boolReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.example.vcdb.store.proto.Region.tableRequest,
      org.example.vcdb.store.proto.Region.boolReply> getAlterTableMethod() {
    io.grpc.MethodDescriptor<org.example.vcdb.store.proto.Region.tableRequest, org.example.vcdb.store.proto.Region.boolReply> getAlterTableMethod;
    if ((getAlterTableMethod = RegionServerGrpc.getAlterTableMethod) == null) {
      synchronized (RegionServerGrpc.class) {
        if ((getAlterTableMethod = RegionServerGrpc.getAlterTableMethod) == null) {
          RegionServerGrpc.getAlterTableMethod = getAlterTableMethod =
              io.grpc.MethodDescriptor.<org.example.vcdb.store.proto.Region.tableRequest, org.example.vcdb.store.proto.Region.boolReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "alterTable"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.vcdb.store.proto.Region.tableRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.vcdb.store.proto.Region.boolReply.getDefaultInstance()))
              .setSchemaDescriptor(new RegionServerMethodDescriptorSupplier("alterTable"))
              .build();
        }
      }
    }
    return getAlterTableMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.example.vcdb.store.proto.Region.tableNameRequest,
      org.example.vcdb.store.proto.Region.boolReply> getDeleteTableMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteTable",
      requestType = org.example.vcdb.store.proto.Region.tableNameRequest.class,
      responseType = org.example.vcdb.store.proto.Region.boolReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.example.vcdb.store.proto.Region.tableNameRequest,
      org.example.vcdb.store.proto.Region.boolReply> getDeleteTableMethod() {
    io.grpc.MethodDescriptor<org.example.vcdb.store.proto.Region.tableNameRequest, org.example.vcdb.store.proto.Region.boolReply> getDeleteTableMethod;
    if ((getDeleteTableMethod = RegionServerGrpc.getDeleteTableMethod) == null) {
      synchronized (RegionServerGrpc.class) {
        if ((getDeleteTableMethod = RegionServerGrpc.getDeleteTableMethod) == null) {
          RegionServerGrpc.getDeleteTableMethod = getDeleteTableMethod =
              io.grpc.MethodDescriptor.<org.example.vcdb.store.proto.Region.tableNameRequest, org.example.vcdb.store.proto.Region.boolReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteTable"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.vcdb.store.proto.Region.tableNameRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.vcdb.store.proto.Region.boolReply.getDefaultInstance()))
              .setSchemaDescriptor(new RegionServerMethodDescriptorSupplier("deleteTable"))
              .build();
        }
      }
    }
    return getDeleteTableMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.example.vcdb.store.proto.Region.dbNameRequest,
      org.example.vcdb.store.proto.Region.bytesReply> getShowTablesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "showTables",
      requestType = org.example.vcdb.store.proto.Region.dbNameRequest.class,
      responseType = org.example.vcdb.store.proto.Region.bytesReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.example.vcdb.store.proto.Region.dbNameRequest,
      org.example.vcdb.store.proto.Region.bytesReply> getShowTablesMethod() {
    io.grpc.MethodDescriptor<org.example.vcdb.store.proto.Region.dbNameRequest, org.example.vcdb.store.proto.Region.bytesReply> getShowTablesMethod;
    if ((getShowTablesMethod = RegionServerGrpc.getShowTablesMethod) == null) {
      synchronized (RegionServerGrpc.class) {
        if ((getShowTablesMethod = RegionServerGrpc.getShowTablesMethod) == null) {
          RegionServerGrpc.getShowTablesMethod = getShowTablesMethod =
              io.grpc.MethodDescriptor.<org.example.vcdb.store.proto.Region.dbNameRequest, org.example.vcdb.store.proto.Region.bytesReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "showTables"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.vcdb.store.proto.Region.dbNameRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.vcdb.store.proto.Region.bytesReply.getDefaultInstance()))
              .setSchemaDescriptor(new RegionServerMethodDescriptorSupplier("showTables"))
              .build();
        }
      }
    }
    return getShowTablesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.example.vcdb.store.proto.Region.tableRequest,
      org.example.vcdb.store.proto.Region.boolReply> getForCreateTableMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "forCreateTable",
      requestType = org.example.vcdb.store.proto.Region.tableRequest.class,
      responseType = org.example.vcdb.store.proto.Region.boolReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.example.vcdb.store.proto.Region.tableRequest,
      org.example.vcdb.store.proto.Region.boolReply> getForCreateTableMethod() {
    io.grpc.MethodDescriptor<org.example.vcdb.store.proto.Region.tableRequest, org.example.vcdb.store.proto.Region.boolReply> getForCreateTableMethod;
    if ((getForCreateTableMethod = RegionServerGrpc.getForCreateTableMethod) == null) {
      synchronized (RegionServerGrpc.class) {
        if ((getForCreateTableMethod = RegionServerGrpc.getForCreateTableMethod) == null) {
          RegionServerGrpc.getForCreateTableMethod = getForCreateTableMethod =
              io.grpc.MethodDescriptor.<org.example.vcdb.store.proto.Region.tableRequest, org.example.vcdb.store.proto.Region.boolReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "forCreateTable"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.vcdb.store.proto.Region.tableRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.vcdb.store.proto.Region.boolReply.getDefaultInstance()))
              .setSchemaDescriptor(new RegionServerMethodDescriptorSupplier("forCreateTable"))
              .build();
        }
      }
    }
    return getForCreateTableMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.example.vcdb.store.proto.Region.transactionRequest,
      org.example.vcdb.store.proto.Region.boolReply> getOpenTransactionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "openTransaction",
      requestType = org.example.vcdb.store.proto.Region.transactionRequest.class,
      responseType = org.example.vcdb.store.proto.Region.boolReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.example.vcdb.store.proto.Region.transactionRequest,
      org.example.vcdb.store.proto.Region.boolReply> getOpenTransactionMethod() {
    io.grpc.MethodDescriptor<org.example.vcdb.store.proto.Region.transactionRequest, org.example.vcdb.store.proto.Region.boolReply> getOpenTransactionMethod;
    if ((getOpenTransactionMethod = RegionServerGrpc.getOpenTransactionMethod) == null) {
      synchronized (RegionServerGrpc.class) {
        if ((getOpenTransactionMethod = RegionServerGrpc.getOpenTransactionMethod) == null) {
          RegionServerGrpc.getOpenTransactionMethod = getOpenTransactionMethod =
              io.grpc.MethodDescriptor.<org.example.vcdb.store.proto.Region.transactionRequest, org.example.vcdb.store.proto.Region.boolReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "openTransaction"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.vcdb.store.proto.Region.transactionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.vcdb.store.proto.Region.boolReply.getDefaultInstance()))
              .setSchemaDescriptor(new RegionServerMethodDescriptorSupplier("openTransaction"))
              .build();
        }
      }
    }
    return getOpenTransactionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.example.vcdb.store.proto.Region.transactionRequest,
      org.example.vcdb.store.proto.Region.boolReply> getCloseTransactionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "closeTransaction",
      requestType = org.example.vcdb.store.proto.Region.transactionRequest.class,
      responseType = org.example.vcdb.store.proto.Region.boolReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.example.vcdb.store.proto.Region.transactionRequest,
      org.example.vcdb.store.proto.Region.boolReply> getCloseTransactionMethod() {
    io.grpc.MethodDescriptor<org.example.vcdb.store.proto.Region.transactionRequest, org.example.vcdb.store.proto.Region.boolReply> getCloseTransactionMethod;
    if ((getCloseTransactionMethod = RegionServerGrpc.getCloseTransactionMethod) == null) {
      synchronized (RegionServerGrpc.class) {
        if ((getCloseTransactionMethod = RegionServerGrpc.getCloseTransactionMethod) == null) {
          RegionServerGrpc.getCloseTransactionMethod = getCloseTransactionMethod =
              io.grpc.MethodDescriptor.<org.example.vcdb.store.proto.Region.transactionRequest, org.example.vcdb.store.proto.Region.boolReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "closeTransaction"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.vcdb.store.proto.Region.transactionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.vcdb.store.proto.Region.boolReply.getDefaultInstance()))
              .setSchemaDescriptor(new RegionServerMethodDescriptorSupplier("closeTransaction"))
              .build();
        }
      }
    }
    return getCloseTransactionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      org.example.vcdb.store.proto.Region.bytesReply> getShowTransactionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "showTransaction",
      requestType = com.google.protobuf.Empty.class,
      responseType = org.example.vcdb.store.proto.Region.bytesReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      org.example.vcdb.store.proto.Region.bytesReply> getShowTransactionMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, org.example.vcdb.store.proto.Region.bytesReply> getShowTransactionMethod;
    if ((getShowTransactionMethod = RegionServerGrpc.getShowTransactionMethod) == null) {
      synchronized (RegionServerGrpc.class) {
        if ((getShowTransactionMethod = RegionServerGrpc.getShowTransactionMethod) == null) {
          RegionServerGrpc.getShowTransactionMethod = getShowTransactionMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, org.example.vcdb.store.proto.Region.bytesReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "showTransaction"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.vcdb.store.proto.Region.bytesReply.getDefaultInstance()))
              .setSchemaDescriptor(new RegionServerMethodDescriptorSupplier("showTransaction"))
              .build();
        }
      }
    }
    return getShowTransactionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.example.vcdb.store.proto.Region.transactionRequest,
      org.example.vcdb.store.proto.Region.boolReply> getDeleteTransactionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteTransaction",
      requestType = org.example.vcdb.store.proto.Region.transactionRequest.class,
      responseType = org.example.vcdb.store.proto.Region.boolReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.example.vcdb.store.proto.Region.transactionRequest,
      org.example.vcdb.store.proto.Region.boolReply> getDeleteTransactionMethod() {
    io.grpc.MethodDescriptor<org.example.vcdb.store.proto.Region.transactionRequest, org.example.vcdb.store.proto.Region.boolReply> getDeleteTransactionMethod;
    if ((getDeleteTransactionMethod = RegionServerGrpc.getDeleteTransactionMethod) == null) {
      synchronized (RegionServerGrpc.class) {
        if ((getDeleteTransactionMethod = RegionServerGrpc.getDeleteTransactionMethod) == null) {
          RegionServerGrpc.getDeleteTransactionMethod = getDeleteTransactionMethod =
              io.grpc.MethodDescriptor.<org.example.vcdb.store.proto.Region.transactionRequest, org.example.vcdb.store.proto.Region.boolReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteTransaction"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.vcdb.store.proto.Region.transactionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.vcdb.store.proto.Region.boolReply.getDefaultInstance()))
              .setSchemaDescriptor(new RegionServerMethodDescriptorSupplier("deleteTransaction"))
              .build();
        }
      }
    }
    return getDeleteTransactionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.example.vcdb.store.proto.Region.useTransactionRequest,
      org.example.vcdb.store.proto.Region.boolReply> getUseTransactionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "useTransaction",
      requestType = org.example.vcdb.store.proto.Region.useTransactionRequest.class,
      responseType = org.example.vcdb.store.proto.Region.boolReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.example.vcdb.store.proto.Region.useTransactionRequest,
      org.example.vcdb.store.proto.Region.boolReply> getUseTransactionMethod() {
    io.grpc.MethodDescriptor<org.example.vcdb.store.proto.Region.useTransactionRequest, org.example.vcdb.store.proto.Region.boolReply> getUseTransactionMethod;
    if ((getUseTransactionMethod = RegionServerGrpc.getUseTransactionMethod) == null) {
      synchronized (RegionServerGrpc.class) {
        if ((getUseTransactionMethod = RegionServerGrpc.getUseTransactionMethod) == null) {
          RegionServerGrpc.getUseTransactionMethod = getUseTransactionMethod =
              io.grpc.MethodDescriptor.<org.example.vcdb.store.proto.Region.useTransactionRequest, org.example.vcdb.store.proto.Region.boolReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "useTransaction"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.vcdb.store.proto.Region.useTransactionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.vcdb.store.proto.Region.boolReply.getDefaultInstance()))
              .setSchemaDescriptor(new RegionServerMethodDescriptorSupplier("useTransaction"))
              .build();
        }
      }
    }
    return getUseTransactionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.example.vcdb.store.proto.Region.versionRequest,
      org.example.vcdb.store.proto.Region.boolReply> getDeleteVersionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteVersion",
      requestType = org.example.vcdb.store.proto.Region.versionRequest.class,
      responseType = org.example.vcdb.store.proto.Region.boolReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.example.vcdb.store.proto.Region.versionRequest,
      org.example.vcdb.store.proto.Region.boolReply> getDeleteVersionMethod() {
    io.grpc.MethodDescriptor<org.example.vcdb.store.proto.Region.versionRequest, org.example.vcdb.store.proto.Region.boolReply> getDeleteVersionMethod;
    if ((getDeleteVersionMethod = RegionServerGrpc.getDeleteVersionMethod) == null) {
      synchronized (RegionServerGrpc.class) {
        if ((getDeleteVersionMethod = RegionServerGrpc.getDeleteVersionMethod) == null) {
          RegionServerGrpc.getDeleteVersionMethod = getDeleteVersionMethod =
              io.grpc.MethodDescriptor.<org.example.vcdb.store.proto.Region.versionRequest, org.example.vcdb.store.proto.Region.boolReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteVersion"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.vcdb.store.proto.Region.versionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.vcdb.store.proto.Region.boolReply.getDefaultInstance()))
              .setSchemaDescriptor(new RegionServerMethodDescriptorSupplier("deleteVersion"))
              .build();
        }
      }
    }
    return getDeleteVersionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.example.vcdb.store.proto.Region.mergeVersionRequest,
      org.example.vcdb.store.proto.Region.intReply> getMergeVersionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "mergeVersion",
      requestType = org.example.vcdb.store.proto.Region.mergeVersionRequest.class,
      responseType = org.example.vcdb.store.proto.Region.intReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.example.vcdb.store.proto.Region.mergeVersionRequest,
      org.example.vcdb.store.proto.Region.intReply> getMergeVersionMethod() {
    io.grpc.MethodDescriptor<org.example.vcdb.store.proto.Region.mergeVersionRequest, org.example.vcdb.store.proto.Region.intReply> getMergeVersionMethod;
    if ((getMergeVersionMethod = RegionServerGrpc.getMergeVersionMethod) == null) {
      synchronized (RegionServerGrpc.class) {
        if ((getMergeVersionMethod = RegionServerGrpc.getMergeVersionMethod) == null) {
          RegionServerGrpc.getMergeVersionMethod = getMergeVersionMethod =
              io.grpc.MethodDescriptor.<org.example.vcdb.store.proto.Region.mergeVersionRequest, org.example.vcdb.store.proto.Region.intReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "mergeVersion"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.vcdb.store.proto.Region.mergeVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.vcdb.store.proto.Region.intReply.getDefaultInstance()))
              .setSchemaDescriptor(new RegionServerMethodDescriptorSupplier("mergeVersion"))
              .build();
        }
      }
    }
    return getMergeVersionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.example.vcdb.store.proto.Region.versionRequest,
      org.example.vcdb.store.proto.Region.boolReply> getUseVersionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "useVersion",
      requestType = org.example.vcdb.store.proto.Region.versionRequest.class,
      responseType = org.example.vcdb.store.proto.Region.boolReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.example.vcdb.store.proto.Region.versionRequest,
      org.example.vcdb.store.proto.Region.boolReply> getUseVersionMethod() {
    io.grpc.MethodDescriptor<org.example.vcdb.store.proto.Region.versionRequest, org.example.vcdb.store.proto.Region.boolReply> getUseVersionMethod;
    if ((getUseVersionMethod = RegionServerGrpc.getUseVersionMethod) == null) {
      synchronized (RegionServerGrpc.class) {
        if ((getUseVersionMethod = RegionServerGrpc.getUseVersionMethod) == null) {
          RegionServerGrpc.getUseVersionMethod = getUseVersionMethod =
              io.grpc.MethodDescriptor.<org.example.vcdb.store.proto.Region.versionRequest, org.example.vcdb.store.proto.Region.boolReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "useVersion"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.vcdb.store.proto.Region.versionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.vcdb.store.proto.Region.boolReply.getDefaultInstance()))
              .setSchemaDescriptor(new RegionServerMethodDescriptorSupplier("useVersion"))
              .build();
        }
      }
    }
    return getUseVersionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.example.vcdb.store.proto.Region.showVersionRequest,
      org.example.vcdb.store.proto.Region.bytesReply> getShowVersionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "showVersion",
      requestType = org.example.vcdb.store.proto.Region.showVersionRequest.class,
      responseType = org.example.vcdb.store.proto.Region.bytesReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.example.vcdb.store.proto.Region.showVersionRequest,
      org.example.vcdb.store.proto.Region.bytesReply> getShowVersionMethod() {
    io.grpc.MethodDescriptor<org.example.vcdb.store.proto.Region.showVersionRequest, org.example.vcdb.store.proto.Region.bytesReply> getShowVersionMethod;
    if ((getShowVersionMethod = RegionServerGrpc.getShowVersionMethod) == null) {
      synchronized (RegionServerGrpc.class) {
        if ((getShowVersionMethod = RegionServerGrpc.getShowVersionMethod) == null) {
          RegionServerGrpc.getShowVersionMethod = getShowVersionMethod =
              io.grpc.MethodDescriptor.<org.example.vcdb.store.proto.Region.showVersionRequest, org.example.vcdb.store.proto.Region.bytesReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "showVersion"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.vcdb.store.proto.Region.showVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.vcdb.store.proto.Region.bytesReply.getDefaultInstance()))
              .setSchemaDescriptor(new RegionServerMethodDescriptorSupplier("showVersion"))
              .build();
        }
      }
    }
    return getShowVersionMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RegionServerStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RegionServerStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RegionServerStub>() {
        @java.lang.Override
        public RegionServerStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RegionServerStub(channel, callOptions);
        }
      };
    return RegionServerStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RegionServerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RegionServerBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RegionServerBlockingStub>() {
        @java.lang.Override
        public RegionServerBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RegionServerBlockingStub(channel, callOptions);
        }
      };
    return RegionServerBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RegionServerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RegionServerFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RegionServerFutureStub>() {
        @java.lang.Override
        public RegionServerFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RegionServerFutureStub(channel, callOptions);
        }
      };
    return RegionServerFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * 对外提供的接口
   * </pre>
   */
  public static abstract class RegionServerImplBase implements io.grpc.BindableService {

    /**
     */
    public void createDB(org.example.vcdb.store.proto.Region.dbNameRequest request,
        io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Region.boolReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateDBMethod(), responseObserver);
    }

    /**
     */
    public void deleteDB(org.example.vcdb.store.proto.Region.dbNameRequest request,
        io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Region.boolReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteDBMethod(), responseObserver);
    }

    /**
     */
    public void showDataBases(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Region.bytesReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getShowDataBasesMethod(), responseObserver);
    }

    /**
     */
    public void putCells(org.example.vcdb.store.proto.Region.putCellsRequest request,
        io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Region.intReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPutCellsMethod(), responseObserver);
    }

    /**
     */
    public void deleteCells(org.example.vcdb.store.proto.Region.deleteCellsRequest request,
        io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Region.intReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteCellsMethod(), responseObserver);
    }

    /**
     */
    public void updateCells(org.example.vcdb.store.proto.Region.updateCellsRequest request,
        io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Region.intReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateCellsMethod(), responseObserver);
    }

    /**
     */
    public void multiSearch(org.example.vcdb.store.proto.Region.multiSearchRequest request,
        io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Region.bytesReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getMultiSearchMethod(), responseObserver);
    }

    /**
     */
    public void singleSearch(org.example.vcdb.store.proto.Region.singleSearchRequest request,
        io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Region.bytesReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSingleSearchMethod(), responseObserver);
    }

    /**
     */
    public void createTable(org.example.vcdb.store.proto.Region.tableRequest request,
        io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Region.boolReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateTableMethod(), responseObserver);
    }

    /**
     */
    public void alterTable(org.example.vcdb.store.proto.Region.tableRequest request,
        io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Region.boolReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAlterTableMethod(), responseObserver);
    }

    /**
     */
    public void deleteTable(org.example.vcdb.store.proto.Region.tableNameRequest request,
        io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Region.boolReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteTableMethod(), responseObserver);
    }

    /**
     */
    public void showTables(org.example.vcdb.store.proto.Region.dbNameRequest request,
        io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Region.bytesReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getShowTablesMethod(), responseObserver);
    }

    /**
     */
    public void forCreateTable(org.example.vcdb.store.proto.Region.tableRequest request,
        io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Region.boolReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getForCreateTableMethod(), responseObserver);
    }

    /**
     */
    public void openTransaction(org.example.vcdb.store.proto.Region.transactionRequest request,
        io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Region.boolReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getOpenTransactionMethod(), responseObserver);
    }

    /**
     */
    public void closeTransaction(org.example.vcdb.store.proto.Region.transactionRequest request,
        io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Region.boolReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCloseTransactionMethod(), responseObserver);
    }

    /**
     */
    public void showTransaction(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Region.bytesReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getShowTransactionMethod(), responseObserver);
    }

    /**
     */
    public void deleteTransaction(org.example.vcdb.store.proto.Region.transactionRequest request,
        io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Region.boolReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteTransactionMethod(), responseObserver);
    }

    /**
     */
    public void useTransaction(org.example.vcdb.store.proto.Region.useTransactionRequest request,
        io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Region.boolReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUseTransactionMethod(), responseObserver);
    }

    /**
     */
    public void deleteVersion(org.example.vcdb.store.proto.Region.versionRequest request,
        io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Region.boolReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteVersionMethod(), responseObserver);
    }

    /**
     */
    public void mergeVersion(org.example.vcdb.store.proto.Region.mergeVersionRequest request,
        io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Region.intReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getMergeVersionMethod(), responseObserver);
    }

    /**
     */
    public void useVersion(org.example.vcdb.store.proto.Region.versionRequest request,
        io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Region.boolReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUseVersionMethod(), responseObserver);
    }

    /**
     */
    public void showVersion(org.example.vcdb.store.proto.Region.showVersionRequest request,
        io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Region.bytesReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getShowVersionMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateDBMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.example.vcdb.store.proto.Region.dbNameRequest,
                org.example.vcdb.store.proto.Region.boolReply>(
                  this, METHODID_CREATE_DB)))
          .addMethod(
            getDeleteDBMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.example.vcdb.store.proto.Region.dbNameRequest,
                org.example.vcdb.store.proto.Region.boolReply>(
                  this, METHODID_DELETE_DB)))
          .addMethod(
            getShowDataBasesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                org.example.vcdb.store.proto.Region.bytesReply>(
                  this, METHODID_SHOW_DATA_BASES)))
          .addMethod(
            getPutCellsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.example.vcdb.store.proto.Region.putCellsRequest,
                org.example.vcdb.store.proto.Region.intReply>(
                  this, METHODID_PUT_CELLS)))
          .addMethod(
            getDeleteCellsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.example.vcdb.store.proto.Region.deleteCellsRequest,
                org.example.vcdb.store.proto.Region.intReply>(
                  this, METHODID_DELETE_CELLS)))
          .addMethod(
            getUpdateCellsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.example.vcdb.store.proto.Region.updateCellsRequest,
                org.example.vcdb.store.proto.Region.intReply>(
                  this, METHODID_UPDATE_CELLS)))
          .addMethod(
            getMultiSearchMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.example.vcdb.store.proto.Region.multiSearchRequest,
                org.example.vcdb.store.proto.Region.bytesReply>(
                  this, METHODID_MULTI_SEARCH)))
          .addMethod(
            getSingleSearchMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.example.vcdb.store.proto.Region.singleSearchRequest,
                org.example.vcdb.store.proto.Region.bytesReply>(
                  this, METHODID_SINGLE_SEARCH)))
          .addMethod(
            getCreateTableMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.example.vcdb.store.proto.Region.tableRequest,
                org.example.vcdb.store.proto.Region.boolReply>(
                  this, METHODID_CREATE_TABLE)))
          .addMethod(
            getAlterTableMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.example.vcdb.store.proto.Region.tableRequest,
                org.example.vcdb.store.proto.Region.boolReply>(
                  this, METHODID_ALTER_TABLE)))
          .addMethod(
            getDeleteTableMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.example.vcdb.store.proto.Region.tableNameRequest,
                org.example.vcdb.store.proto.Region.boolReply>(
                  this, METHODID_DELETE_TABLE)))
          .addMethod(
            getShowTablesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.example.vcdb.store.proto.Region.dbNameRequest,
                org.example.vcdb.store.proto.Region.bytesReply>(
                  this, METHODID_SHOW_TABLES)))
          .addMethod(
            getForCreateTableMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.example.vcdb.store.proto.Region.tableRequest,
                org.example.vcdb.store.proto.Region.boolReply>(
                  this, METHODID_FOR_CREATE_TABLE)))
          .addMethod(
            getOpenTransactionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.example.vcdb.store.proto.Region.transactionRequest,
                org.example.vcdb.store.proto.Region.boolReply>(
                  this, METHODID_OPEN_TRANSACTION)))
          .addMethod(
            getCloseTransactionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.example.vcdb.store.proto.Region.transactionRequest,
                org.example.vcdb.store.proto.Region.boolReply>(
                  this, METHODID_CLOSE_TRANSACTION)))
          .addMethod(
            getShowTransactionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                org.example.vcdb.store.proto.Region.bytesReply>(
                  this, METHODID_SHOW_TRANSACTION)))
          .addMethod(
            getDeleteTransactionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.example.vcdb.store.proto.Region.transactionRequest,
                org.example.vcdb.store.proto.Region.boolReply>(
                  this, METHODID_DELETE_TRANSACTION)))
          .addMethod(
            getUseTransactionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.example.vcdb.store.proto.Region.useTransactionRequest,
                org.example.vcdb.store.proto.Region.boolReply>(
                  this, METHODID_USE_TRANSACTION)))
          .addMethod(
            getDeleteVersionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.example.vcdb.store.proto.Region.versionRequest,
                org.example.vcdb.store.proto.Region.boolReply>(
                  this, METHODID_DELETE_VERSION)))
          .addMethod(
            getMergeVersionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.example.vcdb.store.proto.Region.mergeVersionRequest,
                org.example.vcdb.store.proto.Region.intReply>(
                  this, METHODID_MERGE_VERSION)))
          .addMethod(
            getUseVersionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.example.vcdb.store.proto.Region.versionRequest,
                org.example.vcdb.store.proto.Region.boolReply>(
                  this, METHODID_USE_VERSION)))
          .addMethod(
            getShowVersionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.example.vcdb.store.proto.Region.showVersionRequest,
                org.example.vcdb.store.proto.Region.bytesReply>(
                  this, METHODID_SHOW_VERSION)))
          .build();
    }
  }

  /**
   * <pre>
   * 对外提供的接口
   * </pre>
   */
  public static final class RegionServerStub extends io.grpc.stub.AbstractAsyncStub<RegionServerStub> {
    private RegionServerStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RegionServerStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RegionServerStub(channel, callOptions);
    }

    /**
     */
    public void createDB(org.example.vcdb.store.proto.Region.dbNameRequest request,
        io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Region.boolReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateDBMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteDB(org.example.vcdb.store.proto.Region.dbNameRequest request,
        io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Region.boolReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteDBMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void showDataBases(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Region.bytesReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getShowDataBasesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void putCells(org.example.vcdb.store.proto.Region.putCellsRequest request,
        io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Region.intReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPutCellsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteCells(org.example.vcdb.store.proto.Region.deleteCellsRequest request,
        io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Region.intReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteCellsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateCells(org.example.vcdb.store.proto.Region.updateCellsRequest request,
        io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Region.intReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateCellsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void multiSearch(org.example.vcdb.store.proto.Region.multiSearchRequest request,
        io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Region.bytesReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getMultiSearchMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void singleSearch(org.example.vcdb.store.proto.Region.singleSearchRequest request,
        io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Region.bytesReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSingleSearchMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void createTable(org.example.vcdb.store.proto.Region.tableRequest request,
        io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Region.boolReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateTableMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void alterTable(org.example.vcdb.store.proto.Region.tableRequest request,
        io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Region.boolReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAlterTableMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteTable(org.example.vcdb.store.proto.Region.tableNameRequest request,
        io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Region.boolReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteTableMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void showTables(org.example.vcdb.store.proto.Region.dbNameRequest request,
        io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Region.bytesReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getShowTablesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void forCreateTable(org.example.vcdb.store.proto.Region.tableRequest request,
        io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Region.boolReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getForCreateTableMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void openTransaction(org.example.vcdb.store.proto.Region.transactionRequest request,
        io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Region.boolReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getOpenTransactionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void closeTransaction(org.example.vcdb.store.proto.Region.transactionRequest request,
        io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Region.boolReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCloseTransactionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void showTransaction(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Region.bytesReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getShowTransactionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteTransaction(org.example.vcdb.store.proto.Region.transactionRequest request,
        io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Region.boolReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteTransactionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void useTransaction(org.example.vcdb.store.proto.Region.useTransactionRequest request,
        io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Region.boolReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUseTransactionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteVersion(org.example.vcdb.store.proto.Region.versionRequest request,
        io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Region.boolReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteVersionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void mergeVersion(org.example.vcdb.store.proto.Region.mergeVersionRequest request,
        io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Region.intReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getMergeVersionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void useVersion(org.example.vcdb.store.proto.Region.versionRequest request,
        io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Region.boolReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUseVersionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void showVersion(org.example.vcdb.store.proto.Region.showVersionRequest request,
        io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Region.bytesReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getShowVersionMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * 对外提供的接口
   * </pre>
   */
  public static final class RegionServerBlockingStub extends io.grpc.stub.AbstractBlockingStub<RegionServerBlockingStub> {
    private RegionServerBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RegionServerBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RegionServerBlockingStub(channel, callOptions);
    }

    /**
     */
    public org.example.vcdb.store.proto.Region.boolReply createDB(org.example.vcdb.store.proto.Region.dbNameRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateDBMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.example.vcdb.store.proto.Region.boolReply deleteDB(org.example.vcdb.store.proto.Region.dbNameRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteDBMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.example.vcdb.store.proto.Region.bytesReply showDataBases(com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getShowDataBasesMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.example.vcdb.store.proto.Region.intReply putCells(org.example.vcdb.store.proto.Region.putCellsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPutCellsMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.example.vcdb.store.proto.Region.intReply deleteCells(org.example.vcdb.store.proto.Region.deleteCellsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteCellsMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.example.vcdb.store.proto.Region.intReply updateCells(org.example.vcdb.store.proto.Region.updateCellsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateCellsMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.example.vcdb.store.proto.Region.bytesReply multiSearch(org.example.vcdb.store.proto.Region.multiSearchRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getMultiSearchMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.example.vcdb.store.proto.Region.bytesReply singleSearch(org.example.vcdb.store.proto.Region.singleSearchRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSingleSearchMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.example.vcdb.store.proto.Region.boolReply createTable(org.example.vcdb.store.proto.Region.tableRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateTableMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.example.vcdb.store.proto.Region.boolReply alterTable(org.example.vcdb.store.proto.Region.tableRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAlterTableMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.example.vcdb.store.proto.Region.boolReply deleteTable(org.example.vcdb.store.proto.Region.tableNameRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteTableMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.example.vcdb.store.proto.Region.bytesReply showTables(org.example.vcdb.store.proto.Region.dbNameRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getShowTablesMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.example.vcdb.store.proto.Region.boolReply forCreateTable(org.example.vcdb.store.proto.Region.tableRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getForCreateTableMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.example.vcdb.store.proto.Region.boolReply openTransaction(org.example.vcdb.store.proto.Region.transactionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOpenTransactionMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.example.vcdb.store.proto.Region.boolReply closeTransaction(org.example.vcdb.store.proto.Region.transactionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCloseTransactionMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.example.vcdb.store.proto.Region.bytesReply showTransaction(com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getShowTransactionMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.example.vcdb.store.proto.Region.boolReply deleteTransaction(org.example.vcdb.store.proto.Region.transactionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteTransactionMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.example.vcdb.store.proto.Region.boolReply useTransaction(org.example.vcdb.store.proto.Region.useTransactionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUseTransactionMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.example.vcdb.store.proto.Region.boolReply deleteVersion(org.example.vcdb.store.proto.Region.versionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteVersionMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.example.vcdb.store.proto.Region.intReply mergeVersion(org.example.vcdb.store.proto.Region.mergeVersionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getMergeVersionMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.example.vcdb.store.proto.Region.boolReply useVersion(org.example.vcdb.store.proto.Region.versionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUseVersionMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.example.vcdb.store.proto.Region.bytesReply showVersion(org.example.vcdb.store.proto.Region.showVersionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getShowVersionMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * 对外提供的接口
   * </pre>
   */
  public static final class RegionServerFutureStub extends io.grpc.stub.AbstractFutureStub<RegionServerFutureStub> {
    private RegionServerFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RegionServerFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RegionServerFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.example.vcdb.store.proto.Region.boolReply> createDB(
        org.example.vcdb.store.proto.Region.dbNameRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateDBMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.example.vcdb.store.proto.Region.boolReply> deleteDB(
        org.example.vcdb.store.proto.Region.dbNameRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteDBMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.example.vcdb.store.proto.Region.bytesReply> showDataBases(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getShowDataBasesMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.example.vcdb.store.proto.Region.intReply> putCells(
        org.example.vcdb.store.proto.Region.putCellsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPutCellsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.example.vcdb.store.proto.Region.intReply> deleteCells(
        org.example.vcdb.store.proto.Region.deleteCellsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteCellsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.example.vcdb.store.proto.Region.intReply> updateCells(
        org.example.vcdb.store.proto.Region.updateCellsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateCellsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.example.vcdb.store.proto.Region.bytesReply> multiSearch(
        org.example.vcdb.store.proto.Region.multiSearchRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getMultiSearchMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.example.vcdb.store.proto.Region.bytesReply> singleSearch(
        org.example.vcdb.store.proto.Region.singleSearchRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSingleSearchMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.example.vcdb.store.proto.Region.boolReply> createTable(
        org.example.vcdb.store.proto.Region.tableRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateTableMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.example.vcdb.store.proto.Region.boolReply> alterTable(
        org.example.vcdb.store.proto.Region.tableRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAlterTableMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.example.vcdb.store.proto.Region.boolReply> deleteTable(
        org.example.vcdb.store.proto.Region.tableNameRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteTableMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.example.vcdb.store.proto.Region.bytesReply> showTables(
        org.example.vcdb.store.proto.Region.dbNameRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getShowTablesMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.example.vcdb.store.proto.Region.boolReply> forCreateTable(
        org.example.vcdb.store.proto.Region.tableRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getForCreateTableMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.example.vcdb.store.proto.Region.boolReply> openTransaction(
        org.example.vcdb.store.proto.Region.transactionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getOpenTransactionMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.example.vcdb.store.proto.Region.boolReply> closeTransaction(
        org.example.vcdb.store.proto.Region.transactionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCloseTransactionMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.example.vcdb.store.proto.Region.bytesReply> showTransaction(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getShowTransactionMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.example.vcdb.store.proto.Region.boolReply> deleteTransaction(
        org.example.vcdb.store.proto.Region.transactionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteTransactionMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.example.vcdb.store.proto.Region.boolReply> useTransaction(
        org.example.vcdb.store.proto.Region.useTransactionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUseTransactionMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.example.vcdb.store.proto.Region.boolReply> deleteVersion(
        org.example.vcdb.store.proto.Region.versionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteVersionMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.example.vcdb.store.proto.Region.intReply> mergeVersion(
        org.example.vcdb.store.proto.Region.mergeVersionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getMergeVersionMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.example.vcdb.store.proto.Region.boolReply> useVersion(
        org.example.vcdb.store.proto.Region.versionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUseVersionMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.example.vcdb.store.proto.Region.bytesReply> showVersion(
        org.example.vcdb.store.proto.Region.showVersionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getShowVersionMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_DB = 0;
  private static final int METHODID_DELETE_DB = 1;
  private static final int METHODID_SHOW_DATA_BASES = 2;
  private static final int METHODID_PUT_CELLS = 3;
  private static final int METHODID_DELETE_CELLS = 4;
  private static final int METHODID_UPDATE_CELLS = 5;
  private static final int METHODID_MULTI_SEARCH = 6;
  private static final int METHODID_SINGLE_SEARCH = 7;
  private static final int METHODID_CREATE_TABLE = 8;
  private static final int METHODID_ALTER_TABLE = 9;
  private static final int METHODID_DELETE_TABLE = 10;
  private static final int METHODID_SHOW_TABLES = 11;
  private static final int METHODID_FOR_CREATE_TABLE = 12;
  private static final int METHODID_OPEN_TRANSACTION = 13;
  private static final int METHODID_CLOSE_TRANSACTION = 14;
  private static final int METHODID_SHOW_TRANSACTION = 15;
  private static final int METHODID_DELETE_TRANSACTION = 16;
  private static final int METHODID_USE_TRANSACTION = 17;
  private static final int METHODID_DELETE_VERSION = 18;
  private static final int METHODID_MERGE_VERSION = 19;
  private static final int METHODID_USE_VERSION = 20;
  private static final int METHODID_SHOW_VERSION = 21;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RegionServerImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RegionServerImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_DB:
          serviceImpl.createDB((org.example.vcdb.store.proto.Region.dbNameRequest) request,
              (io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Region.boolReply>) responseObserver);
          break;
        case METHODID_DELETE_DB:
          serviceImpl.deleteDB((org.example.vcdb.store.proto.Region.dbNameRequest) request,
              (io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Region.boolReply>) responseObserver);
          break;
        case METHODID_SHOW_DATA_BASES:
          serviceImpl.showDataBases((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Region.bytesReply>) responseObserver);
          break;
        case METHODID_PUT_CELLS:
          serviceImpl.putCells((org.example.vcdb.store.proto.Region.putCellsRequest) request,
              (io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Region.intReply>) responseObserver);
          break;
        case METHODID_DELETE_CELLS:
          serviceImpl.deleteCells((org.example.vcdb.store.proto.Region.deleteCellsRequest) request,
              (io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Region.intReply>) responseObserver);
          break;
        case METHODID_UPDATE_CELLS:
          serviceImpl.updateCells((org.example.vcdb.store.proto.Region.updateCellsRequest) request,
              (io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Region.intReply>) responseObserver);
          break;
        case METHODID_MULTI_SEARCH:
          serviceImpl.multiSearch((org.example.vcdb.store.proto.Region.multiSearchRequest) request,
              (io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Region.bytesReply>) responseObserver);
          break;
        case METHODID_SINGLE_SEARCH:
          serviceImpl.singleSearch((org.example.vcdb.store.proto.Region.singleSearchRequest) request,
              (io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Region.bytesReply>) responseObserver);
          break;
        case METHODID_CREATE_TABLE:
          serviceImpl.createTable((org.example.vcdb.store.proto.Region.tableRequest) request,
              (io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Region.boolReply>) responseObserver);
          break;
        case METHODID_ALTER_TABLE:
          serviceImpl.alterTable((org.example.vcdb.store.proto.Region.tableRequest) request,
              (io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Region.boolReply>) responseObserver);
          break;
        case METHODID_DELETE_TABLE:
          serviceImpl.deleteTable((org.example.vcdb.store.proto.Region.tableNameRequest) request,
              (io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Region.boolReply>) responseObserver);
          break;
        case METHODID_SHOW_TABLES:
          serviceImpl.showTables((org.example.vcdb.store.proto.Region.dbNameRequest) request,
              (io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Region.bytesReply>) responseObserver);
          break;
        case METHODID_FOR_CREATE_TABLE:
          serviceImpl.forCreateTable((org.example.vcdb.store.proto.Region.tableRequest) request,
              (io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Region.boolReply>) responseObserver);
          break;
        case METHODID_OPEN_TRANSACTION:
          serviceImpl.openTransaction((org.example.vcdb.store.proto.Region.transactionRequest) request,
              (io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Region.boolReply>) responseObserver);
          break;
        case METHODID_CLOSE_TRANSACTION:
          serviceImpl.closeTransaction((org.example.vcdb.store.proto.Region.transactionRequest) request,
              (io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Region.boolReply>) responseObserver);
          break;
        case METHODID_SHOW_TRANSACTION:
          serviceImpl.showTransaction((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Region.bytesReply>) responseObserver);
          break;
        case METHODID_DELETE_TRANSACTION:
          serviceImpl.deleteTransaction((org.example.vcdb.store.proto.Region.transactionRequest) request,
              (io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Region.boolReply>) responseObserver);
          break;
        case METHODID_USE_TRANSACTION:
          serviceImpl.useTransaction((org.example.vcdb.store.proto.Region.useTransactionRequest) request,
              (io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Region.boolReply>) responseObserver);
          break;
        case METHODID_DELETE_VERSION:
          serviceImpl.deleteVersion((org.example.vcdb.store.proto.Region.versionRequest) request,
              (io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Region.boolReply>) responseObserver);
          break;
        case METHODID_MERGE_VERSION:
          serviceImpl.mergeVersion((org.example.vcdb.store.proto.Region.mergeVersionRequest) request,
              (io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Region.intReply>) responseObserver);
          break;
        case METHODID_USE_VERSION:
          serviceImpl.useVersion((org.example.vcdb.store.proto.Region.versionRequest) request,
              (io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Region.boolReply>) responseObserver);
          break;
        case METHODID_SHOW_VERSION:
          serviceImpl.showVersion((org.example.vcdb.store.proto.Region.showVersionRequest) request,
              (io.grpc.stub.StreamObserver<org.example.vcdb.store.proto.Region.bytesReply>) responseObserver);
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

  private static abstract class RegionServerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RegionServerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.example.vcdb.store.proto.Region.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RegionServer");
    }
  }

  private static final class RegionServerFileDescriptorSupplier
      extends RegionServerBaseDescriptorSupplier {
    RegionServerFileDescriptorSupplier() {}
  }

  private static final class RegionServerMethodDescriptorSupplier
      extends RegionServerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RegionServerMethodDescriptorSupplier(String methodName) {
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
      synchronized (RegionServerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RegionServerFileDescriptorSupplier())
              .addMethod(getCreateDBMethod())
              .addMethod(getDeleteDBMethod())
              .addMethod(getShowDataBasesMethod())
              .addMethod(getPutCellsMethod())
              .addMethod(getDeleteCellsMethod())
              .addMethod(getUpdateCellsMethod())
              .addMethod(getMultiSearchMethod())
              .addMethod(getSingleSearchMethod())
              .addMethod(getCreateTableMethod())
              .addMethod(getAlterTableMethod())
              .addMethod(getDeleteTableMethod())
              .addMethod(getShowTablesMethod())
              .addMethod(getForCreateTableMethod())
              .addMethod(getOpenTransactionMethod())
              .addMethod(getCloseTransactionMethod())
              .addMethod(getShowTransactionMethod())
              .addMethod(getDeleteTransactionMethod())
              .addMethod(getUseTransactionMethod())
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
