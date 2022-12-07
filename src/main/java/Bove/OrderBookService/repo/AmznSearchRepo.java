package Bove.OrderBookService.repo;

import Bove.OrderBookService.model.Amzn;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AmznSearchRepo extends ElasticsearchRepository<Amzn, String> {
}
