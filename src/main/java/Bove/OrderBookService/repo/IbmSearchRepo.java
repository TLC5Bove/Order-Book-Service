package Bove.OrderBookService.repo;

import Bove.OrderBookService.model.Ibm;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IbmSearchRepo extends ElasticsearchRepository<Ibm, String> {
}
