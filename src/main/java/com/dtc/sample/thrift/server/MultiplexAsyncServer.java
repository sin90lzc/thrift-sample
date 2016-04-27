/**
 * 
 */
package com.dtc.sample.thrift.server;

import org.apache.thrift.TMultiplexedProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TNonblockingServerTransport;
import org.apache.thrift.transport.TTransportException;

import com.dtc.sample.thrift.service.Complex;
import com.dtc.sample.thrift.service.ComplexServiceImpl;
import com.dtc.sample.thrift.service.Hello;
import com.dtc.sample.thrift.service.HelloServiceImpl;

/**
 * 
 * @category 一个端口绑定多个服务接口的服务器实现
 * @author tim 2016年4月27日
 */
public class MultiplexAsyncServer {

	public static void main(String[] args) {

		try {
			//使用非阻塞传输层
			TNonblockingServerTransport serverTransport = new TNonblockingServerSocket(7222);
			//创建二进制协议工厂
			TProtocolFactory protocolFactory=new TBinaryProtocol.Factory();
			//创建多路复用业务处理器
			TMultiplexedProcessor multiplexProcessor = new TMultiplexedProcessor();
			//注册helloService服务
			multiplexProcessor.registerProcessor("helloService",
					new Hello.Processor<Hello.Iface>(new HelloServiceImpl()));
			//注册complexService服务
			multiplexProcessor.registerProcessor("complexService",
					new Complex.Processor<Complex.Iface>(new ComplexServiceImpl()));
			TNonblockingServer.Args serverArgs=new TNonblockingServer.Args(serverTransport);//使用非阻塞传输层
			serverArgs.processor(multiplexProcessor);//服务器使用多路复用业务处理器
			serverArgs.protocolFactory(protocolFactory);//服务器使用二进制协议工厂
			TNonblockingServer server = new TNonblockingServer(serverArgs);
			System.out.println("start serve at port 7222");
			server.serve();//开始服务
		} catch (TTransportException e) {
			throw new RuntimeException(e);
		}

	}

}
