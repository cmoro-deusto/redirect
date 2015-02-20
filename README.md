# redirect
A simple example on managing redirect response using apache commons httpclient

## Usage
Clone the repo
```
git clone https://github.com/cmoro-deusto/redirect.git redirect
```

Generate fat jar

```
$ cd redirect
$ ./gradlew fatJar
```

Execution
```
$ java -jar build/libs/redirect-1.0.jar
```

Example output
```
/usr/lib/jvm/java-8-oracle/bin/java -Didea.launcher.port=7563 -Didea.launcher.bin.path=/opt/idea-IU-140.2285.5/bin -Dfile.encoding=UTF-8 -classpath /usr/lib/jvm/java-8-oracle/jre/lib/rt.jar:/usr/lib/jvm/java-8-oracle/jre/lib/jfxswt.jar:/usr/lib/jvm/java-8-oracle/jre/lib/deploy.jar:/usr/lib/jvm/java-8-oracle/jre/lib/plugin.jar:/usr/lib/jvm/java-8-oracle/jre/lib/javaws.jar:/usr/lib/jvm/java-8-oracle/jre/lib/jfr.jar:/usr/lib/jvm/java-8-oracle/jre/lib/management-agent.jar:/usr/lib/jvm/java-8-oracle/jre/lib/jsse.jar:/usr/lib/jvm/java-8-oracle/jre/lib/charsets.jar:/usr/lib/jvm/java-8-oracle/jre/lib/resources.jar:/usr/lib/jvm/java-8-oracle/jre/lib/jce.jar:/usr/lib/jvm/java-8-oracle/jre/lib/ext/sunec.jar:/usr/lib/jvm/java-8-oracle/jre/lib/ext/sunjce_provider.jar:/usr/lib/jvm/java-8-oracle/jre/lib/ext/nashorn.jar:/usr/lib/jvm/java-8-oracle/jre/lib/ext/zipfs.jar:/usr/lib/jvm/java-8-oracle/jre/lib/ext/localedata.jar:/usr/lib/jvm/java-8-oracle/jre/lib/ext/sunpkcs11.jar:/usr/lib/jvm/java-8-oracle/jre/lib/ext/cldrdata.jar:/usr/lib/jvm/java-8-oracle/jre/lib/ext/jfxrt.jar:/usr/lib/jvm/java-8-oracle/jre/lib/ext/dnsns.jar:/home/carlos/Code/sla/redirect/build/classes/main:/home/carlos/Code/sla/redirect/build/resources/main:/home/carlos/.gradle/caches/modules-2/files-2.1/ch.qos.logback/logback-classic/1.1.2/b316e9737eea25e9ddd6d88eaeee76878045c6b2/logback-classic-1.1.2.jar:/home/carlos/.gradle/caches/modules-2/files-2.1/ch.qos.logback/logback-core/1.1.2/2d23694879c2c12f125dac5076bdfd5d771cc4cb/logback-core-1.1.2.jar:/home/carlos/.gradle/caches/modules-2/files-2.1/org.slf4j/slf4j-api/1.7.6/562424e36df3d2327e8e9301a76027fca17d54ea/slf4j-api-1.7.6.jar:/home/carlos/.gradle/caches/modules-2/files-2.1/org.apache.httpcomponents/httpclient/4.4/6d220441ca681dddc55a189eae81a437309128b8/httpclient-4.4.jar:/home/carlos/.gradle/caches/modules-2/files-2.1/org.apache.httpcomponents/httpcore/4.4/e9b3863fd9c8a273ceed4a7fae10f40bb10a2328/httpcore-4.4.jar:/home/carlos/.gradle/caches/modules-2/files-2.1/commons-codec/commons-codec/1.9/9ce04e34240f674bc72680f8b843b1457383161a/commons-codec-1.9.jar:/home/carlos/.gradle/caches/modules-2/files-2.1/commons-logging/commons-logging/1.2/4bfc12adfe4842bf07b657f0369c4cb522955686/commons-logging-1.2.jar:/opt/idea-IU-140.2285.5/lib/idea_rt.jar com.intellij.rt.execution.application.AppMain com.sla.redirect.Application
13:34:56.904 [main] INFO  com.sla.redirect.Application - Redirect example

13:34:56.914 [main] INFO  com.sla.redirect.Application - Preparing Request to http://sisinfo.preventiva.com/PrincipalWebPre/login/ExternalLogin
13:34:57.417 [main] INFO  com.sla.redirect.Application - Calling http://sisinfo.preventiva.com/PrincipalWebPre/login/ExternalLogin

13:34:58.578 [main] INFO  com.sla.redirect.Application - Response received
13:34:58.578 [main] INFO  com.sla.redirect.Application - HTTP Error Code: HTTP/1.1 301 Moved Permanently
13:34:58.578 [main] INFO  com.sla.redirect.Application - Date: Fri, 20 Feb 2015 12:34:58 GMT
13:34:58.578 [main] INFO  com.sla.redirect.Application - Server: Apache/2.2.16 (Debian)
13:34:58.578 [main] INFO  com.sla.redirect.Application - Location: http://www.preventiva.com/PrincipalWebPre/login/ExternalLogin
13:34:58.578 [main] INFO  com.sla.redirect.Application - Vary: Accept-Encoding
13:34:58.578 [main] INFO  com.sla.redirect.Application - Keep-Alive: timeout=15, max=100
13:34:58.578 [main] INFO  com.sla.redirect.Application - Connection: Keep-Alive
13:34:58.578 [main] INFO  com.sla.redirect.Application - Content-Type: text/html; charset=iso-8859-1
13:34:58.583 [main] INFO  com.sla.redirect.Application - Body: 

<!DOCTYPE HTML PUBLIC "-//IETF//DTD HTML 2.0//EN">
<html><head>
<title>301 Moved Permanently</title>
</head><body>
<h1>Moved Permanently</h1>
<p>The document has moved <a href="http://www.preventiva.com/PrincipalWebPre/login/ExternalLogin">here</a>.</p>
<hr>
<address>Apache/2.2.16 (Debian) Server at sisinfo.preventiva.com Port 80</address>
</body></html>

13:34:58.584 [main] ERROR com.sla.redirect.Application - Bad Login Received
13:34:58.584 [main] INFO  com.sla.redirect.Application - Redirect to: Location: http://www.preventiva.com/PrincipalWebPre/login/ExternalLogin
```

