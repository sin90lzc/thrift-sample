/**
 * 
 */
package com.dtc.sample.thrift.client;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransportException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.dtc.sample.thrift.server.AsyncHelloServer;
import com.dtc.sample.thrift.service.Hello;
import com.dtc.sample.thrift.service.Hello.Client;

/**
 * 这里服务器端必须使用的是非阻塞服务器{@link AsyncHelloServer}
 * ，而客户端用的也是非阻塞方式，但用的是同步调用方式。执行该单元测试之前需要先启动 {@link AsyncHelloServer}
 * 
 * @category 异步服务端，而客户端使用同步的方式
 * @author tim 2016年4月27日
 */
@Test
public class SyncClientWithAsyncServer {

	private TFramedTransport transport;

	private Client client;

	@BeforeClass
	public void beforeClass() {
		try {
			// 创建非阻塞传输层，该传输层用于同步调用
			transport = new TFramedTransport(new TSocket("localhost", 7111));
			transport.open();// 同步调用必须先打开链接，做三次握手
			// 创建二进制传输协议，并且使用非阻塞传输层TFramedTransport
			TBinaryProtocol protocol = new TBinaryProtocol(transport);
			// 创建客户端，并使用二进制传输协议
			client = new Hello.Client(protocol);
		} catch (TTransportException e) {
			throw new RuntimeException(e);
		}
	}

	public void testHello() {
		try {
			String resp = client.helloString("hello world");
			Assert.assertEquals(resp, "hello world");
		} catch (TException e) {
			throw new RuntimeException(e);
		}
	}

	@AfterClass
	public void afterClass() {
		transport.close();
	}
}
