Log4j
tracing API

核心类 为Logger  org.apache.log4j.Logger

Logger分级 org.apache.log4j.Level  
TRACE,DEBUG,INFO,WARN,ERROR,FATAL(致命）

只有大于logger的级别的日志才会被打印，比如logger的级别是INFO，则DEBUG级别的日志不会被打印
DEBUG < INFO < WARN < ERROR < FATAL

输出目的地被称为 appender，即在哪儿输出

配置文件 xml或者properties（ Java properties (key=value) format）文件均可
config/log4j.properties

等级为DEBUG的日志信息输出到stdout和R这两个目的地
log4j.rootLogger=DEBUG, stdout, R


stdout 

定义名为stdout的输出端是哪种类型

og4j.appender.stdout=org.apache.log4j.ConsoleAppender

org.apache.log4j.ConsoleAppender（控制台），

org.apache.log4j.FileAppender（文件），

org.apache.log4j.DailyRollingFileAppender（每天产生一个日志文件），

org.apache.log4j.RollingFileAppender（文件大小到达指定尺寸的时候产生一个新的文件）

org.apache.log4j.WriterAppender（将日志信息以流格式发送到任意指定的地方）

log4j.appender.stdout.layout=org.apache.log4j.PatternLayout

stdout的输出端的layout是哪种类型
org.apache.log4j.HTMLLayout（以HTML表格形式布局），

org.apache.log4j.PatternLayout（可以灵活地指定布局模式），

org.apache.log4j.SimpleLayout（包含日志信息的级别和信息字符串），

org.apache.log4j.TTCCLayout（包含日志产生的时间、线程、类别等等信息）

log4j.appender.stdout.layout.ConversionPattern= [QC] %-d{yyyy-MM-dd HH:mm:ss} %p [%t]  %C.%M (%F:%L) | %m%n
使用pattern布局(PatternLayout)就要指定的打印信息的具体格式ConversionPattern
 %m 输出代码中指定的消息

%-d{yyyy-MM-dd HH:mm:ss}输出当前时间，格式为2017-04-24 13:00:26

%p 输出优先级，即DEBUG，INFO，WARN，ERROR，FATAL

%r 输出自应用启动到输出该log信息耗费的毫秒数

%c 输出所属的类目，通常就是所在类的全名

%t 输出产生该日志事件的线程名

%n 输出一个回车换行符，Windows平台为“rn”，Unix平台为“n”

%d 输出日志时间点的日期或时间，默认格式为ISO8601，也可以在其后指定格式，比如：%d{yyyy MMM dd HH:mm:ss,SSS}，输出类似：2002年10月18日 22：10：28，921

%l 输出日志事件的发生位置，包括类目名、发生的线程，以及在代码中的行数。

[QC]是log信息的开头，可以为任意字符，一般为项目简称。


NDC处理大量并发


slf4j
slf4j就是接口，配置好其他的日志api后，就能直接在其基础上使用slf4j