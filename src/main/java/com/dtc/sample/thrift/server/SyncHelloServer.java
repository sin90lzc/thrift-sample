/**
 * 
 */
package com.dtc.sample.thrift.server;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TBinaryProtocol.Factory;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.server.TThreadPoolServer.Args;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

import com.dtc.sample.thrift.service.Hello;
import com.dtc.sample.thrift.service.HelloServiceImpl;

/**
 * @category thrift服务端同步调用实现
 * @author tim
 * 
 *         2016年4月27日
 */
public class SyncHelloServer {

	public static void main(String[] args) {
		try {
			// 使用普通传输层，设置服务端口为 7911
			TServerSocket serverTransport = new TServerSocket(7911);
			// 设置协议工厂为 TBinaryProtocol.Factory，即二进制传输协议
			Factory proFactory = new TBinaryProtocol.Factory();
			// 服务器端的业务处理器，处理器需要关联 Hello服务的实现。处理器由thrift compiler生成。
			TProcessor processor = new Hello.Processor<Hello.Iface>(new HelloServiceImpl());
			Args serverArgs = new TThreadPoolServer.Args(serverTransport);// 服务器关联传输层
			serverArgs.protocolFactory(proFactory);// 服务器关联传输协议
			serverArgs.processor(processor);// 服务器关联业务处理器
			TServer server = new TThreadPoolServer(serverArgs);
			System.out.println("Start server on port 7911...");
			server.serve(); // 开始服务
		} catch (TTransportException e) {
			throw new RuntimeException(e);
		}
	}
}
