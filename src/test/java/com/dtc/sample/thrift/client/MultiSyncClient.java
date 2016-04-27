/**
 * 
 */
package com.dtc.sample.thrift.client;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TMultiplexedProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransportException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.dtc.sample.thrift.server.MultiplexAsyncServer;
import com.dtc.sample.thrift.service.Complex;
import com.dtc.sample.thrift.service.ComplexType;
import com.dtc.sample.thrift.service.Hello;
import com.dtc.sample.thrift.service.SimpleBean;

/**
 * 需要先启动{@link MultiplexAsyncServer}
 * @category 访问一个端口多个服务时的客户端实现
 * @author tim 2016年4月27日
 */
@Test
public class MultiSyncClient {
	TFramedTransport transport;
	Hello.Client helloClient;
	Complex.Client complexClient;

	@BeforeClass
	public void beforeClass() {
		//使用非阻塞传输层
		transport = new TFramedTransport(new TSocket("localhost", 7222));
		try {
			transport.open();//同步调用方式都需要先打开链接
		} catch (TTransportException e) {
			transport.close();
			throw new RuntimeException(e);
		}
		//创建二进制传输协议
		TProtocol protocol = new TBinaryProtocol(transport);

		//创建针对helloService服务的二进制传输协议
		TMultiplexedProtocol helloServiceProtocol = new TMultiplexedProtocol(protocol, "helloService");
		//创建针对helloService服务的二进制传输协议
		TMultiplexedProtocol complexServiceProtocol = new TMultiplexedProtocol(protocol, "complexService");

		//创建helloService的客户端
		helloClient = new Hello.Client(helloServiceProtocol);
		//创建complexService的客户端
		complexClient = new Complex.Client(complexServiceProtocol);
	}

	@Test
	public void testHelloService() {
		try {
			String helloString = helloClient.helloString("hello world");
			Assert.assertEquals(helloString, "hello world");
		} catch (TException e) {
			throw new RuntimeException(e);
		}
	}

	public void testComplexService() {
		try {
			ComplexType complexType = complexClient.getComplexType(ComplexType.Complex);
			Assert.assertEquals(complexType, ComplexType.Complex);

			SimpleBean bean = new SimpleBean();
			bean.complexType = ComplexType.Complex;
			bean.id = 1;
			bean.simpleBean = new SimpleBean();
			bean.simpleBean.complexType = ComplexType.Simple;
			bean.simpleBean.id = 2;
			bean.simpleBean.simpleBean = null;
			SimpleBean simpleBean = complexClient.getSimpleBean(bean);

			Assert.assertEquals(simpleBean.id, 1);
			Assert.assertEquals(simpleBean.complexType, ComplexType.Complex);
			Assert.assertEquals(simpleBean.simpleBean.id, 2);
			Assert.assertEquals(simpleBean.simpleBean.complexType, ComplexType.Simple);
		} catch (TException e) {
			throw new RuntimeException(e);
		}
	}

	@AfterClass
	public void afterClass() {
		transport.close();
	}
}
