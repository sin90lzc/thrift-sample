<h1>该项目是thrift的使用示例</h1>

<h2>1. 在windows下thrift （java）环境的安装</h2>
<h3>1.1 在apache thrift官网下载thrift complier（编译器）</h3>
thrift complier用于解析thrift IDL(接口描述定义语言）文件，并生成thrift业务接口处理器processor，Iface业务接口，以及客户端代码。把下载的complier的exe程序设置到环境变量PATH下。complier下载地址：
http://www.apache.org/dyn/closer.cgi?path=/thrift/0.9.3/thrift-0.9.3.exe

<h3>1.2 在thrift项目中引用thrift的 java库</h3>
		<dependency>
			<groupId>org.apache.thrift</groupId>
			<artifactId>libthrift</artifactId>
			<version>0.9.3</version>
		</dependency>
<h2>2. 创建thrift IDL文件</h2>
thrift IDL文件的语法请看“百度云同步盘\my_doc\docs\java\thrift\thrift_idl_接口描述语言.pdf"或访问官网http://thrift.apache.org/docs/idl，有详细说明
在项目中也有thrift IDL文件的示例
thrift/Hello.thrift   --   简单的thrift IDL文件示例
thrift/Complex.thrift    --    包含复杂对象的thrift IDL文件示例


<h2>3.使用thrift complier编译</h2>
执行以下命令：
thrift -gen java -out ../src/main/java Complex.thrift
thrift -gen java -out ../src/main/java Hello.thrift

<h2>4.实现生成的Iface接口</h2>
Iface接口就是在thrift IDL中定义的接口的java版本
项目中也分别有Complex.thrift和Hello.thrift的接口实现参考示例：
Hello.thrift ： com.dtc.sample.thrift.service.HelloServiceImpl
Complex.thrift ： com.dtc.sample.thrift.service.ComplexServiceImpl

<h2>5. 编写服务端代码和客户端代码</h2>
编写服务端代码和客户端代码最重要一点就是了解整个数据交换的分层结构，比如说服务端的分层结构如下：
  +-------------------------------------------+
  | Server                                    |
  | (single-threaded, event-driven etc)       |
  +-------------------------------------------+
  | Processor                                 |
  | (compiler generated)                      |
  +-------------------------------------------+
  | Protocol                                  |
  | (JSON, compact etc)                       |
  +-------------------------------------------+
  | Transport                                 |
  | (raw TCP, HTTP etc)                       |
  +-------------------------------------------+

Server（服务器层）: 主要是实现线程模型，如单线程模型org.apache.thrift.server.TSimpleServer，线程池模型org.apache.thrift.server.TThreadPoolServer.TThreadPoolServer，reactor模型org.apache.thrift.transport.TNonblockingServerSocket.TNonblockingServerSocket等。该层由thrift类库提供。

Processor（业务处理器层）：该层代码由thrift compiler生成。同时业务处理器层需要关联业务服务接口Iface的实现类。该层主要负责业务逻辑的处理。

Protocol（协议层）：该层由thrift类库提供。主要负责数据序列化和反序列化。

Transport（传输层）：该层由thrift类库提供。主要负责数据传输和I/O。


客户端的分层结构与服务器端类似，只是Processor换成了Client层:
  +-------------------------------------------+
  | Client                                    |
  | (compiler generated)                      |
  +-------------------------------------------+
  | Protocol                                  |
  | (JSON, compact etc)                       |
  +-------------------------------------------+
  | Transport                                 |
  | (raw TCP, HTTP etc)                       |
  +-------------------------------------------+

Client（客户端层）：该层代码由thrift compiler生成。主要处理业务接口的处理。


<h3>5.1 阻塞式服务端+阻塞式客户端实现</h3>
这种方式的代码示例可以参考：

阻塞式服务端  ： com.dtc.sample.thrift.server.SyncHelloServer

阻塞式客户端  ： com.dtc.sample.thrift.client.SyncClient


<h3>5.2 非阻塞式服务端+非阻塞式客户端异步回调实现</h3>
这种方式的代码示例可以参考：
非阻塞式服务端 ： com.dtc.sample.thrift.server.AsyncHelloServer

非阻塞式客户端异步回调 ：com.dtc.sample.thrift.client.AsyncClient

<h3>5.3 非阻塞式服务端+非阻塞式客户端同步调用实现</h3>
这种方式的代码示例可以参考：
非阻塞式服务端 ： com.dtc.sample.thrift.server.AsyncHelloServer
非阻塞式客户端同步调用：com.dtc.sample.thrift.client.SyncClientWithAsyncServer

<h3>5.4 一端口多服务注册的服务端 + 对应客户端实现</h3>
这种方式的代码示例可以参考：
一端口多服务注册的服务端 ：com.dtc.sample.thrift.server.MultiplexAsyncServer
对应客户端 ： com.dtc.sample.thrift.client.MultiSyncClient


关于thrift的相关文献：
<a href="https://www.ibm.com/developerworks/cn/java/j-lo-apachethrift/">Apache Thrift - 可伸缩的跨语言服务开发框架 </a>

<a href="http://thrift.apache.org/">Apache Thrift官网 </a>