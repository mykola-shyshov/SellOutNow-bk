package okonkwo.job;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.util.regex.Pattern;


public class BizonCrawlerTask extends WebCrawler {

    private final Pattern SHARES_ITEM_URL_PATTERN = Pattern.compile( "bizon\\.com\\.ua/share\\.php\\?id=\\d*" );

    private boolean isSharesProductUrl( String url ) {
        return SHARES_ITEM_URL_PATTERN.matcher( url ).find();
    }

    @Override
    public boolean shouldVisit( Page page, WebURL url ) {
        String href = url.getURL().toLowerCase();
        return isSharesProductUrl( href ) || href.contains( "bizon.com.ua/shares.php" );
    }

    @Override
    public void visit( Page page ) {
        if ( !isSharesProductUrl( page.getWebURL().getURL().toLowerCase() ) ) {
            return;
        }

        if (page.getParseData() instanceof HtmlParseData) {
            HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
            logger.info( htmlParseData.getHtml() );
        }
    }

    private void parse() {
        try{
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
//            builder.parse(  )
        } catch ( ParserConfigurationException e ) {
            logger.warn( "Parser configuration failure" );
        }

    }

}
