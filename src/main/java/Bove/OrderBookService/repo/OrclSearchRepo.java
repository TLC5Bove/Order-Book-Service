package Bove.OrderBookService.repo;

import Bove.OrderBookService.model.Orcl;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrclSearchRepo extends ElasticsearchRepository<Orcl, String> {
}
