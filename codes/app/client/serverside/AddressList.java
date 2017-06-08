package client.serverside;
import java.util.*;
public class AddressList {
  private static int host = 49;
  private static ArrayList<String> servers = new ArrayList<String>();
  private static final String list[] = {
    "W63C001D",
    "W63C002D",
    "W63C003D",
    "W63C004D",
    "W63C005D",
    "W63C006D",
    "W63C007D",
    "W63C008D",
    "W63C009D",
    "W63C010D",
    "W63C011D",
    "W63C012D",
    "W63C013D",
    "W63C014D",
    "W63C015D",
    "W63C016D",
    "W63C017D",
    "W63C018D",
    "W63C019D",
    "W63C020D",
    "W63C021D",
    "W63C022D",
    "W63C023D",
    "W63C024D",
    "W63C025D",
    "W63C026D",
    "W63C027D",
    "W63C028D",
    "W63C029D",
    "W63C030D",
    "W63C031D",
    "W63C032D",
    "W63C033D",
    "W63C034D",
    "W63C035D",
    "W63C036D",
    "W63C037D",
    "W63C038D",
    "W63C039D",
    "W63C040D",
    "W63C041D",
    "W63C042D",
    "W63C043D",
    "W63C044D",
    "W63C045D",
    "W63C046D",
    "W63C047D",
    "W63C048D",
    "localhost"

};

public static String getList(int num) {
  return list[num-1];
}

public static void setupServerList() {
  NetworkServer s = new NetworkServer(getHost(),getServerList());
  for(String hostname : list) {
      s.sendString("test",hostname,0);
  }
  for(String name : getServerList()){
      System.out.println(name);
  }
  Client.setSize(getServerList().length);
}

public static void addServerList(String name) {
  servers.add(name);
}

public static String[] getServerList() {
  return (String[])servers.toArray(new String[0]);
}

public static String getHost() {
  return getList(host);
}

public static void setHost(int num) {
  host = num;
}

}