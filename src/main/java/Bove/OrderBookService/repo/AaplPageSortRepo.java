package Bove.OrderBookService.repo;

import Bove.OrderBookService.model.Aapl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AaplPageSortRepo extends PagingAndSortingRepository<Aapl, String> {
    Page<Aapl> findAllBySide(String side, Pageable p);
}
