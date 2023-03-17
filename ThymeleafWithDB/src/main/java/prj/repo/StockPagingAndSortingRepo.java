package prj.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import prj.model.Stock;

public interface StockPagingAndSortingRepo extends PagingAndSortingRepository<Stock,Integer> {
}
