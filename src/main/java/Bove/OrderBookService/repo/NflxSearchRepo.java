package Bove.OrderBookService.repo;

import Bove.OrderBookService.model.Nflx;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NflxSearchRepo extends ElasticsearchRepository<Nflx, String> {
}
