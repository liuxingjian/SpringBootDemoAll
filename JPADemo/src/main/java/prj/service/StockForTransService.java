package prj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import prj.model.Stock;
import prj.repo.StockRepo;



@Service
public class StockForTransService {
    @Autowired
    private StockRepo stockRepo;
    @Transactional(timeout=20,readOnly = false,isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    public void updateStockOK(){
        Stock stock=stockRepo.getReferenceById(10);
        stock.setNum(25);
        stockRepo.save(stock);
        Stock anotherStock= stockRepo.getReferenceById(1);
        anotherStock.setNum(15);
        stockRepo.save(anotherStock);
    }
    @Transactional(rollbackFor = Exception.class)
    public void updateStockError(){
        Stock stock=stockRepo.getReferenceById(10);
        stock.setNum(35);
        stockRepo.save(stock);
        String str=null;
        str.toString();
        Stock anotherStock=stockRepo.getReferenceById(1);
        anotherStock.setNum(25);
        stockRepo.save(anotherStock);
    }
}
