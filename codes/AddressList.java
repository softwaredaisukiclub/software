class AddressList {
  private static final String list[][] = {
    {
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
    }, {
        "W63C001E",
        "W63C002E",
        "W63C004E",
        "W63C005E",
        "W63C006E",
        "W63C007E",
        "W63C008E",
        "W63C009E",
        "W63C010E",
        "W63C011E",
        "W63C012E",
        "W63C013E",
        "W63C014E",
        "W63C015E",
        "W63C016E",
        "W63C017E",
        "W63C018E",
        "W63C019E",
        "W63C020E",
        "W63C021E",
        "W63C022E",
        "W63C023E",
        "W63C024E",
        "W63C025E",
        "W63C026E",
        "W63C027E",
        "W63C028E",
        "W63C029E",
        "W63C030E",
        "W63C031E",
        "W63C032E",
        "W63C033E",
        "W63C034E",
        "W63C035E",
        "W63C036E",
        "W63C037E",
        "W63C038E",
        "W63C039E",
        "W63C040E",
        "W63C041E",
        "W63C042E",
        "W63C043E",
        "W63C044E",
        "W63C045E",
        "W63C046E",
        "W63C047E",
        "W63C048E",
        "localhost"
    }
};

public static String getList(int num) {
    String result = null;
    result = list[0][num-1];
    return result;
}
}