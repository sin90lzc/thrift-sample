/**
 * 
 */
package com.dtc.sample.thrift.service;

import org.apache.thrift.TException;

/**
 * @category 实现由thrift IDL定义的简单接口
 * @author tim
 * 2016年4月27日
 */
public class HelloServiceImpl implements Hello.Iface {

	/** 
	 * @see com.dtc.sample.thrift.service.Hello.Iface#helloString(java.lang.String)
	 */
	@Override
	public String helloString(String para) throws TException {
		return para;
	}

	/** 
	 * @see com.dtc.sample.thrift.service.Hello.Iface#helloInt(int)
	 */
	@Override
	public int helloInt(int para) throws TException {
		return para;
	}

	/** 
	 * @see com.dtc.sample.thrift.service.Hello.Iface#helloBoolean(boolean)
	 */
	@Override
	public boolean helloBoolean(boolean para) throws TException {
		return para;
	}

	/** 
	 * @see com.dtc.sample.thrift.service.Hello.Iface#helloVoid()
	 */
	@Override
	public void helloVoid() throws TException {
		System.out.println("hello world!");
	}

	/** 
	 * @see com.dtc.sample.thrift.service.Hello.Iface#helloNull()
	 */
	@Override
	public String helloNull() throws TException {
		return null;
	}

}
