package prj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import prj.model.Stock;
import prj.repo.StockRepo;

import java.util.List;

@RestController
public class stockService {
    @Autowired
    private StockRepo stockRepo;
    public List<Stock> findByName(String name){
        return stockRepo.findByName(name);
    }
    public List<Stock> getAllStock(){
        return stockRepo.findAll();
    }
    public void delete(){
        Stock delStock=stockRepo.getOne(10);
        stockRepo.delete(delStock);
    }
    public void deleteStockByID(int id){
        stockRepo.deleteById(id);
    }
    public Stock insertStock(){
        Stock stock=new Stock();
        stock.setID(10);
        stock.setName("machine");
        stock.setNum(5);
        stock.setDescription("good");
        return stockRepo.save(stock);
    }
    public Stock updateStock(){
        Stock stock = stockRepo.getReferenceById(10);
        stock.setNum(50);
        return stockRepo.save(stock);
    }
    public List<Stock> getStockByDesc(String desc){
        return stockRepo.getStockByDesc(desc);
    }

}
