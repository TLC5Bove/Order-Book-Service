package Bove.OrderBookService.repo;

import Bove.OrderBookService.model.Ibm;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IbmSearchRepo extends ElasticsearchRepository<Ibm, String> {
//    List<Ibm> findBySideAndTypeOrderByPriceAscIgnoreCase(String side, String type);
}
