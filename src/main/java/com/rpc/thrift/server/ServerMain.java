package com.rpc.thrift.server;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TBinaryProtocol.Factory;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;
import org.apache.thrift.transport.TTransportFactory;

import com.rpc.thrift.idl.Calculator;
import com.rpc.thrift.idl.CalculatorImpl;

public class ServerMain {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("Start thrift server...");
        TProcessor tProcessor = new Calculator.Processor<>(new CalculatorImpl());
        try {
            TServerSocket serverTransport = new TServerSocket(8888);
            TTransportFactory transportFactory = new TFramedTransport.Factory();
            Factory factory = new TBinaryProtocol.Factory();
            
            TServer.Args tArgs = new TServer.Args(serverTransport);
            tArgs.protocolFactory(factory);
            tArgs.transportFactory(transportFactory);
            tArgs.processor(tProcessor);
            
            TServer server = new TSimpleServer(tArgs);
            server.serve();
            
        } catch (TTransportException e) {
            e.printStackTrace();
            System.out.println("Start thrift server ERROR!!!");
        }
    }

}
