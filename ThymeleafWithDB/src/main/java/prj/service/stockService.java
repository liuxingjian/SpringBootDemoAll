package prj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RestController;
import prj.model.Stock;
import prj.repo.StockRepo;

import java.util.List;

@RestController
public class stockService {
    @Autowired
    private StockRepo stockRepo;
    public List<Stock> getAllStock(){
        return stockRepo.findAll();
    }
    public Page<Stock> getStockListByPage(int pageNum, int pageSize){
        Sort sort= Sort.by(Sort.Direction.ASC, "ID");
        Pageable pageable= PageRequest.of(pageNum,pageSize,sort);
        return stockRepo.findAll(pageable);
    }
}
