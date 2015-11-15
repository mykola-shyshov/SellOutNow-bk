package okonkwo.job;


import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;
import edu.uci.ics.crawler4j.url.WebURL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class BizonCrawler {

    private final Logger logger = LoggerFactory.getLogger( BizonCrawler.class );
    private final String SELL_URL = "http://bizon.com.ua/shares.php";
    private static final int NUMBER_OF_CRAWLERS = 1;


    // http://bizon.com.ua/shares.php
    // http://bizon.com.ua/share.php?id=80
    // http://bizon.com.ua/product_info.php/products_id/404492


    public void dismember() {

        logger.info( "try to dismember bizon" );



        CrawlConfig config = new CrawlConfig();
        PageFetcher pageFetcher = new PageFetcher(config);
        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
        CrawlController controller;

        config.setCrawlStorageFolder("/Users/ecentric/crawler");
        try {
            controller = new CrawlController(config, pageFetcher, robotstxtServer);
        } catch ( Exception e ) {
            logger.error( "Error creation bizon crawler", e );
            return;
        }

        controller.addSeed( SELL_URL );

        logger.info( "crawling started" );

        controller.start( BizonCrawlerTask.class, NUMBER_OF_CRAWLERS );

        logger.info( "crawling finished" );
    }

}
