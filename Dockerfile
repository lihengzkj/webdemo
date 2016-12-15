FROM tomcat
EXPOSE 8080
ADD target/*.war /usr/local/tomcat/webapps/webdemo.war
CMD ["catalina.sh", "run"]