package okonkwo.controller;

import okonkwo.job.BizonCrawler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private BizonCrawler bizonCrawler;

    @RequestMapping( "bizon-shares" )
    public void getBizon() {
        bizonCrawler.dismember();
    }
}
