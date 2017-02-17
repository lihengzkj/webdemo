FROM tomcat
EXPOSE 8080
#this locate the war
ADD target/*.war /usr/local/tomcat/webapps/webdemo.war
ENV dirver=com.mysql.jdbc.Driver
ENV url=jdbc:mysql://172.17.0.12:3306/webdbdemo?characterEncoding=UTF-8&amp;characterSetResults=UTF-8
ENV user=kejing
ENV password=kejing123
CMD ["catalina.sh", "run"]
