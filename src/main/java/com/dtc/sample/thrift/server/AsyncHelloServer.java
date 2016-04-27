/**
 * 
 */
package com.dtc.sample.thrift.server;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TNonblockingServer.Args;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TNonblockingServerTransport;
import org.apache.thrift.transport.TTransportException;

import com.dtc.sample.thrift.client.SyncClientWithAsyncServer;
import com.dtc.sample.thrift.service.Hello;
import com.dtc.sample.thrift.service.HelloServiceImpl;

/**
 * @category 异步thrift服务器端，同时也可以作为同步客户端的服务器{@link SyncClientWithAsyncServer}
 * @author tim
 * 
 *         2016年4月27日
 */
public class AsyncHelloServer {

	public static void main(String[] args) {
		TNonblockingServerTransport serverTransport;
		try {
			// 使用非阻塞传输层NIO，绑定端口号7111
			serverTransport = new TNonblockingServerSocket(7111);
			// 使用二进制传输协议
			TProtocolFactory protocolFactory = new TBinaryProtocol.Factory();
			// 创建业务处理器，业务处理器需要关联服务接口实现类
			Hello.Processor<Hello.Iface> processor = new Hello.Processor<Hello.Iface>(new HelloServiceImpl());
			Args serverArgs = new TNonblockingServer.Args(serverTransport);// 服务器使用非阻塞传输层
			serverArgs.processor(processor);// 服务器关联业务处理器
			serverArgs.protocolFactory(protocolFactory);// 服务器关联二进制传输协议工厂
			TServer server = new TNonblockingServer(serverArgs);
			System.out.println("Start server on port 7111 ...");
			server.serve();// 启动服务
		} catch (TTransportException e) {
			throw new RuntimeException(e);
		}
	}

}
