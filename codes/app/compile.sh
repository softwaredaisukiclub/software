javac client/front/*.java
javac client/serverside/*.java
javac server/front/*.java
javac server/serverside/*.java
javac module/*.java
jar cvfm client.jar CLIENT.MF client/front/*.class client/serverside/*.class module/*.class
jar cvfm server.jar SERVER.MF server/front/*.class server/serverside/*.class module/*.class