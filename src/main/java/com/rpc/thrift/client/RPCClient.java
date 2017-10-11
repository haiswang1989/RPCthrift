package com.rpc.thrift.client;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

import com.rpc.thrift.idl.Calculator;
import com.rpc.thrift.idl.Calculator.Client;

public class RPCClient {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        TTransport transport = new TFramedTransport(new TSocket("127.0.0.1", 8888));
        //协议要和服务端保持一致
        TProtocol protocol = new TBinaryProtocol(transport);
        Client client = new Calculator.Client(protocol);
        try {
            transport.open();
            int result = client.add(1, 2);
            System.out.println(result);
            transport.close();
        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        }
    }
}
