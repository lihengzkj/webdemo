FROM tomcat
EXPOSE 8080
#this locate the war
ADD target/*.war /usr/local/tomcat/webapps/webdemo.war
CMD ["catalina.sh", "run"]
