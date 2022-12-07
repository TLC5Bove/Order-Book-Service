package Bove.OrderBookService.repo;

import Bove.OrderBookService.model.Aapl;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AaplSearchRepo extends ElasticsearchRepository<Aapl, String> {
}
