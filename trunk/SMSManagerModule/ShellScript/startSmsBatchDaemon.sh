#!/bin/bash
export LIB=$HOME/opt/apache-tomcat-6.0.14/webapps/sms/WEB-INF/lib
export CLASS=$HOME/opt/apache-tomcat-6.0.14/webapps/sms/WEB-INF/classes
export CLASSPATH=$LIB/sms.jar:$LIB/hibernate3.jar:$LIB/commons-httpclient-3.0.1.jar:$LIB/mysql-connector-java-5.0.5-bin.jar:$LIB/jta.jar
export CLASSPATH=$CLASSPATH:$LIB/commons-logging-1.0.4.jar:$LIB/dom4j-1.6.1.jar:$LIB/commons-collections-2.1.1.jar:$LIB/ehcache-1.2.jar:$LIB/commons-codec-1.3.jar
export CLASSPATH=$CLASSPATH:$CLASS
echo $CLASSPATH
java com.shenming.sms.deamon.SmsSenderDaemon
