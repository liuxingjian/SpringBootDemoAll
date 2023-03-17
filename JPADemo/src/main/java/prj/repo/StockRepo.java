package prj.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import prj.model.Stock;

import java.util.List;

@Component
public interface StockRepo extends JpaRepository<Stock, Integer> {
    public List<Stock> findByName(String name);
    @Override
    public void delete(Stock stock);
    @Override
    public void deleteById(Integer id);
    @Override
    public Stock save(Stock stock);
//    @Query("select s from Stock s where s.description like ?1%")
    @Query(value = "select * from Stock where description like ?1%",nativeQuery = true)//原生sql
    public List<Stock> getStockByDesc(String desc);

}
