Log4j
tracing API

������ ΪLogger  org.apache.log4j.Logger

Logger�ּ� org.apache.log4j.Level  
TRACE,DEBUG,INFO,WARN,ERROR,FATAL(������

ֻ�д���logger�ļ������־�Żᱻ��ӡ������logger�ļ�����INFO����DEBUG�������־���ᱻ��ӡ
DEBUG < INFO < WARN < ERROR < FATAL

���Ŀ�ĵر���Ϊ appender�������Ķ����

�����ļ� xml����properties�� Java properties (key=value) format���ļ�����
config/log4j.properties

�ȼ�ΪDEBUG����־��Ϣ�����stdout��R������Ŀ�ĵ�
log4j.rootLogger=DEBUG, stdout, R


stdout 

������Ϊstdout�����������������

og4j.appender.stdout=org.apache.log4j.ConsoleAppender

org.apache.log4j.ConsoleAppender������̨����

org.apache.log4j.FileAppender���ļ�����

org.apache.log4j.DailyRollingFileAppender��ÿ�����һ����־�ļ�����

org.apache.log4j.RollingFileAppender���ļ���С����ָ���ߴ��ʱ�����һ���µ��ļ���

org.apache.log4j.WriterAppender������־��Ϣ������ʽ���͵�����ָ���ĵط���

log4j.appender.stdout.layout=org.apache.log4j.PatternLayout

stdout������˵�layout����������
org.apache.log4j.HTMLLayout����HTML�����ʽ���֣���

org.apache.log4j.PatternLayout����������ָ������ģʽ����

org.apache.log4j.SimpleLayout��������־��Ϣ�ļ������Ϣ�ַ�������

org.apache.log4j.TTCCLayout��������־������ʱ�䡢�̡߳����ȵ���Ϣ��

log4j.appender.stdout.layout.ConversionPattern= [QC] %-d{yyyy-MM-dd HH:mm:ss} %p [%t]  %C.%M (%F:%L) | %m%n
ʹ��pattern����(PatternLayout)��Ҫָ���Ĵ�ӡ��Ϣ�ľ����ʽConversionPattern
 %m ���������ָ������Ϣ

%-d{yyyy-MM-dd HH:mm:ss}�����ǰʱ�䣬��ʽΪ2017-04-24 13:00:26

%p ������ȼ�����DEBUG��INFO��WARN��ERROR��FATAL

%r �����Ӧ�������������log��Ϣ�ķѵĺ�����

%c �����������Ŀ��ͨ�������������ȫ��

%t �����������־�¼����߳���

%n ���һ���س����з���Windowsƽ̨Ϊ��rn����Unixƽ̨Ϊ��n��

%d �����־ʱ�������ڻ�ʱ�䣬Ĭ�ϸ�ʽΪISO8601��Ҳ���������ָ����ʽ�����磺%d{yyyy MMM dd HH:mm:ss,SSS}��������ƣ�2002��10��18�� 22��10��28��921

%l �����־�¼��ķ���λ�ã�������Ŀ�����������̣߳��Լ��ڴ����е�������

[QC]��log��Ϣ�Ŀ�ͷ������Ϊ�����ַ���һ��Ϊ��Ŀ��ơ�


NDC�����������


slf4j
slf4j���ǽӿڣ����ú���������־api�󣬾���ֱ�����������ʹ��slf4j