/**
 * 
 */
package com.dtc.sample.thrift.client;

import java.io.IOException;

import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.async.TAsyncClientManager;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.transport.TNonblockingSocket;
import org.apache.thrift.transport.TNonblockingTransport;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.dtc.sample.thrift.server.AsyncHelloServer;
import com.dtc.sample.thrift.service.Hello;
import com.dtc.sample.thrift.service.Hello.AsyncClient.helloString_call;

/**
 * 需要先启动异步服务器{@link AsyncHelloServer}
 * 
 * @category 异步客户端实现
 * 
 * @author tim
 * 
 *         2016年4月27日
 */
@Test
public class AsyncClient {

	private Hello.AsyncClient asyncClient;
	private TNonblockingTransport transport;

	/**
	 * 
	 * @category 客户端调用的异步回调。需要实现{@link AsyncMethodCallback}，
	 *           {@link AsyncMethodCallback}
	 *           需要指定泛型对象，该泛型对象类型的名称一般是{调用方法名}_call的形式
	 * @author tim 2016年4月27日
	 */
	private static class MethodCallback implements AsyncMethodCallback<helloString_call> {

		private String result;

		/**
		 * @category 调用成功时回调
		 * @param response 是调用方法的封装类，一般类型名称是{调用方法名}_call的形式
		 * @see org.apache.thrift.async.AsyncMethodCallback#onComplete(java.lang.Object)
		 */
		@Override
		public void onComplete(helloString_call response) {
			try {
				this.result = response.getResult();
			} catch (TException e) {
				throw new RuntimeException(e);
			}
		}

		/**
		 * @category 该方法在发生错误时回调
		 * @see org.apache.thrift.async.AsyncMethodCallback#onError(java.lang.Exception)
		 */
		@Override
		public void onError(Exception exception) {
			throw new RuntimeException(exception);
		}

		public String getResult() {
			return this.result;
		}

	}

	@BeforeClass
	public void beforeClass() {
		try {
			//创建异步客户端管理器
			TAsyncClientManager clientManager = new TAsyncClientManager();
			//创建并使用非阻塞传输层
			transport = new TNonblockingSocket("localhost", 7111);
			//创建二进制传输协议工厂
			TProtocolFactory protocol = new TBinaryProtocol.Factory();
			//异步客户端关联异步二进制传输协议工厂protocol，异步客户端管理器clientManager，非阻塞传输层transport
			asyncClient = new Hello.AsyncClient(protocol, clientManager, transport);
			System.out.println("Client calls .....");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Test
	public void testHelloString() {
		MethodCallback callBack = new MethodCallback();
		try {
			//在调用接口时，需要引用回调接口
			asyncClient.helloString("Hello World", callBack);
			String res = callBack.getResult();
			//这里使用while循环获取异步调用结果
			while (res == null) {
				res = callBack.getResult();
			}
			Assert.assertEquals(res, "Hello World");
		} catch (TException e) {
			throw new RuntimeException(e);
		}

	}

	@AfterClass
	public void afterClass() {
		transport.close();
	}

}
