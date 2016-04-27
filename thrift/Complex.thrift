namespace java com.dtc.sample.thrift.service

enum ComplexType {
	Simple,Complex
}

struct SimpleBean {
	1:ComplexType complexType,
	2:i32 id,
	3:SimpleBean simpleBean
}

service Complex {
	ComplexType getComplexType(1:ComplexType complexType),
	SimpleBean getSimpleBean(1:SimpleBean simpleBean)
}