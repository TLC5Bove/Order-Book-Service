package Bove.OrderBookService.repo;

import Bove.OrderBookService.model.Msft;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MsftSearchRepo extends ElasticsearchRepository<Msft, String> {
}
