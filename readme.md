####Technoloyg Used : 
	1.JSF 2.0(Java server face) 
	2.Oracle
####create java web app template/archetype <br/>
<b>mvn archetype:generate -DarchetypeArtifactId=maven-archetype-webapp </b><br/>
give project details : <br/>
<b>groupId=com.deltagroupbd </b>
<b>artifactId=ocms </b>
<b>pacakgeId=com.deltagroupbd.ocms </b>

####ManagedBean :  
Its name says, Managed Beans is a java bean managed by JSF framework that means it need not create object programatically.we just use it

####How to create ManageBean : 
There are two style to create managed bean<br/>

1.  before 2.0 style way(faces-config.xml)
2.  2.0 style(Annotation)
  1. @ManagedBean : register it is managed by JSF.
  2. Improve formatting
    * name param : you can specify bean name . defauls value class name
		 @ManagedBean(name = "myindex")
	* eager param : bean is created before any request come . defauls value false
		 @ManagedBean(eager = true)

Index.java
```java
package com.deltagroupbd.ocms.beans;

import javax.faces.bean.RequestScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "myindex" , eager = true)
@RequestScoped
public class Index {
   public Index() {
      System.out.println("it is printed when server loading since eager = true");
   }
	
   public String getMessage() {
      return "Welcome to delta group ocms";
   }
}
```
Access managed bean info : index.html

```html
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
   "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
   <title>JSF Tutorial!</title>
</head>

<body>
   #{index.getMessage()}
</body>
</html>
```
web.xml : 

```xml
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
   xmlns="http://java.sun.com/xml/ns/javaee" 
   xmlns:web="http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd"
   xsi:schemaLocation="http://java.sun.com/xml/ns/javaee 
   http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd"
   id="WebApp_ID" version="3.0">

  <display-name>Archetype Created Web Application</display-name>
  <welcome-file-list>
      <welcome-file>index.xhtml</welcome-file>
  </welcome-file-list>
  
   <!-- 
      FacesServlet is main servlet responsible to handle all request. 
      It acts as Front controller desing pattern.
      This servlet initializes the JSF components before the JSP is displayed.
   -->
   <servlet>
      <servlet-name>Faces Servlet</servlet-name>
      <servlet-class>javax.faces.webapp.FacesServlet</servlet-class>
      <load-on-startup>1</load-on-startup>
   </servlet>

   <servlet-mapping>
      <servlet-name>Faces Servlet</servlet-name>
      <url-pattern>*.xhtml</url-pattern>
   </servlet-mapping>
</web-app>
```


