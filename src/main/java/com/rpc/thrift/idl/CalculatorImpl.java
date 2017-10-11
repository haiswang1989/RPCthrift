package com.rpc.thrift.idl;

import org.apache.thrift.TException;

public class CalculatorImpl implements Calculator.Iface {
    
    @Override
    public int add(int num1, int num2) throws TException {
        // TODO Auto-generated method stub
        return num1 + num2;
    }
}
