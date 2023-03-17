package prj.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class StockService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public String demoGetStock(int id){
        logger.info("demoGetStock,id is: " + id  );
        return "demoGetStock";
    }

    public String demoInsertStock(){
        logger.info("demoInsertStock");
        return "demoInsertStock";
    }
}


