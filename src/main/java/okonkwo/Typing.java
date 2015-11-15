package okonkwo;


import java.util.regex.Pattern;

public class Typing {
    private static final Pattern SHARES_ITEM_URL_PATTERN = Pattern.compile( "bizon\\.com\\.ua/share\\.php\\?id=\\d*" );

//    static public void main(String [] args) {
//        System.out.print( SHARES_ITEM_URL_PATTERN.matcher( "http://bizon.com.ua/share.php?id=23" ).find() );
//    }
}
