javac client/front/*.java
javac client/serverside/*.java
javac server/front/*.java
javac server/serverside/*.java
cd ..
rm -rf sjis_app
cp -r app sjis_app
nkf -s --overwrite sjis_app/server/front/*
nkf -s --overwrite sjis_app/server/serverside/*
nkf -s --overwrite sjis_app/client/front/*
nkf -s --overwrite sjis_app/client/serverside/*
cd sjis_app
jar cvfm client.jar CLIENT.MF client/front/*.class client/serverside/*.class
jar cvfm server.jar SERVER.MF server/front/*.class server/serverside/*.class