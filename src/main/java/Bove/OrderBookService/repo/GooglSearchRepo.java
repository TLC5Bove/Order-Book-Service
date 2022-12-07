package Bove.OrderBookService.repo;

import Bove.OrderBookService.model.Googl;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GooglSearchRepo extends ElasticsearchRepository<Googl, String> {
}
