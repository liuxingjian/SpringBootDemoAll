package prj.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import prj.model.OrderDetail;

@Repository
public interface OrderDetailRepo extends JpaRepository<OrderDetail, Integer> {

    public OrderDetail findOrderdetailById(int id);
}
