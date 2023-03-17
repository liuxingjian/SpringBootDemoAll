package prj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import prj.model.Stock;
import prj.service.StockForTransService;
import prj.service.StockPagingAndService;
import prj.service.stockService;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    stockService stockService;
    @RequestMapping("showList")
    public ModelAndView showList(){
        ModelAndView modelAndView=new ModelAndView("list");
        modelAndView.addObject("stocks",stockService.getAllStock());
        return modelAndView;
    }
    @RequestMapping("/listByPage")
    public ModelAndView listByPage(@RequestParam(value = "pageNum",defaultValue = "0") int pageNum,@RequestParam(value = "pageSize",defaultValue = "3") int pageSize){
        Page<Stock> stocks=stockService.getStockListByPage(pageNum,pageSize);
        System.out.println(stocks.getTotalPages()+"/"+pageNum);
        ModelAndView modelAndView=new ModelAndView("listByPage");
        modelAndView.addObject("stocks",stocks);
        return modelAndView;
    }
}
