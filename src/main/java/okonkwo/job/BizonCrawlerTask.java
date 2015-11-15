package okonkwo.job;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.url.WebURL;

import java.util.regex.Pattern;


public class BizonCrawlerTask extends WebCrawler {
//\?id=
    private final Pattern SHARES_ITEM_URL_PATTERN = Pattern.compile( "bizon\\.com\\.ua/share\\.php\\?id=\\d*" );

    private boolean isSharesItem( String url ) {
        logger.info( "pattern - " + SHARES_ITEM_URL_PATTERN.pattern() );
        return SHARES_ITEM_URL_PATTERN.matcher( url ).find();
    }

    @Override
    public boolean shouldVisit( Page page, WebURL url ) {
        String href = url.getURL().toLowerCase();
        return isSharesItem( href ) || href.contains( "bizon.com.ua/shares.php" );
    }

    @Override
    public void visit( Page page ) {
        logger.info( page.getContentData().toString() );
    }

}
