package Bove.OrderBookService.repo;

import Bove.OrderBookService.model.Tsla;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TslaSearchRepo extends ElasticsearchRepository<Tsla, String> {
}
