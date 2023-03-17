package prj.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import prj.service.StockService;

@RestController
public class Controller {

    @Autowired
    StockService stockService;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping("/demoGetStock/{id}")
    public String demoGetStock(@PathVariable int id){

        if(id>100){
            logger.error("demoGetStock param error");
            return "error";
        }
        logger.warn("demo warn.");
        logger.debug("demoGetStock,id is: " + id  );
        return stockService.demoGetStock(id) ;
    }

    @RequestMapping("/demoInsertStock")
    public String demoInsertStock(){
        logger.debug("demoInsertStock");
        return stockService.demoInsertStock();
    }

}