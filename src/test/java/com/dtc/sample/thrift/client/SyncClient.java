/**
 * 
 */
package com.dtc.sample.thrift.client;

import org.apache.thrift.TApplicationException;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.dtc.sample.thrift.service.Hello;

/**
 * 需要先启动服务com.dtc.thrift.server.SyncServer
 * 
 * @category 同步客户端单元测试
 * @author tim
 * 
 *         2016年4月27日
 */
@Test
public class SyncClient {

	private TTransport transport;

	private Hello.Client client;

	@BeforeClass
	public void beforeClass() {
		try {
			// 创建传输层为普通传输层，设置调用的服务地址为本地，端口为 7911
			transport = new TSocket("localhost", 7911);
			// 同步调用都需要先打开传输层，进行三次握手
			transport.open();
			// 使用二进制传输协议
			TProtocol protocol = new TBinaryProtocol(transport);
			// 生成客户端
			client = new Hello.Client(protocol);
		} catch (TTransportException e) {
			throw new RuntimeException(e);
		}
	}

	@Test
	public void testHelloString() {
		try {
			String hello = client.helloString("hello world");
			Assert.assertEquals(hello, "hello world");

		} catch (TException e) {
			throw new RuntimeException();
		}
	}

	@Test(expectedExceptions = { TApplicationException.class })
	public void testHelloNull() throws TException {
		// thrift接口返回null时都会返回TApplicationException,而且异常类型为TApplicationException.MISSING_RESULT
		String hello = null;
		try {
			hello = client.helloNull();
		} catch (TApplicationException ex) {
			Assert.assertEquals(ex.getType(), TApplicationException.MISSING_RESULT);
			hello = null;
			throw ex;
		} catch (TException e) {
			throw e;
		}
	}

	@Test
	public void testHelloInt() {
		try {
			int helloInt = client.helloInt(888);
			Assert.assertEquals(helloInt, 888);
		} catch (TException e) {
			throw new RuntimeException();
		}
	}

	@Test
	public void testHelloVoid() {
		try {
			client.helloVoid();
		} catch (TException e) {
			throw new RuntimeException();
		}
	}

	@Test
	public void testHelloBoolean() {
		boolean helloBoolean;
		try {
			helloBoolean = client.helloBoolean(true);
			Assert.assertTrue(helloBoolean);
		} catch (TException e) {
			throw new RuntimeException();
		}

	}

	@AfterClass
	public void afterClass() {
		transport.close();
	}

}
