package Bove.OrderBookService.repo;

import Bove.OrderBookService.model.Ibm;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IbmPageSortRepo extends PagingAndSortingRepository<Ibm, String> {
}
