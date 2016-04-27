/**
 * 
 */
package com.dtc.sample.thrift.service;

import org.apache.thrift.TException;

/**
 * @category 
 * @author tim
 * 2016年4月27日
 */
public class ComplexServiceImpl implements Complex.Iface {

	/** 
	 * @see com.dtc.sample.thrift.service.Complex.Iface#getComplexType(com.dtc.sample.thrift.service.ComplexType)
	 */
	@Override
	public ComplexType getComplexType(ComplexType complexType) throws TException {
		return complexType;
	}

	/** 
	 * @see com.dtc.sample.thrift.service.Complex.Iface#getSimpleBean(com.dtc.sample.thrift.service.SimpleBean)
	 */
	@Override
	public SimpleBean getSimpleBean(SimpleBean simpleBean) throws TException {
		return simpleBean;
	}

}
