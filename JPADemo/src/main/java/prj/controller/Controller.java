package prj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import prj.model.Stock;
import prj.service.StockForTransService;
import prj.service.StockPagingAndService;
import prj.service.stockService;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    stockService stockService;
    @Autowired
    private StockPagingAndService stockPagingAndService;
    @Autowired
    private StockForTransService stockForTransService;
    @RequestMapping("/getStockByName/{name}")
    public List<Stock> getStockByName(@PathVariable String name){
        return stockService.findByName(name);
    }
    @RequestMapping("/getAllStocks")
    public List<Stock> getAllStocks(){
        return stockService.getAllStock();
    }
    @RequestMapping("/deleteStock")
    public void deleteStock(){
        stockService.delete();
    }
    @RequestMapping("/deleteStockByID/{ID}")
    public void deleteStockByID(@PathVariable String ID){
        stockService.deleteStockByID(Integer.parseInt(ID));
    }
    @RequestMapping("/insertStock")
    public Stock insertStock(){
        return stockService.insertStock();
    }
    @RequestMapping("/updateStock")
    public Stock updateStock(){
        return stockService.updateStock();
    }
    @RequestMapping("/sortByName")
    List<Stock> sortByName(){
        return stockPagingAndService.sortByName();
    }
    @RequestMapping("/splitPage")
    List<Stock> splitPage(){
        return stockPagingAndService.splitPage();
    }
    @RequestMapping("/getStockByDesc/{desc}")
    List<Stock> getStockByDesc(@PathVariable String desc){
        return stockService.getStockByDesc(desc);
    }
    @RequestMapping("/transOK")
    void transOK(){
        stockForTransService.updateStockOK();
    }
    @RequestMapping("/transError")
    void transError(){
        stockForTransService.updateStockError();
    }
}
