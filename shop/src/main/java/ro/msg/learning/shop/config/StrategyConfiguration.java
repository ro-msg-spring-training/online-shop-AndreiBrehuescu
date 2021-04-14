package ro.msg.learning.shop.config;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.msg.learning.shop.repository.LocationRepository;
import ro.msg.learning.shop.repository.StockRepository;
import ro.msg.learning.shop.stategy.MultipleLocationStrategy;
import ro.msg.learning.shop.stategy.SingleLocationStrategy;
import ro.msg.learning.shop.stategy.interfaces.IStrategy;

@Configuration
@AllArgsConstructor
public class StrategyConfiguration {

    private final StockRepository stockRepository;
    private final LocationRepository locationRepository;

    @Bean
    public IStrategy selectStrategy(@Value("${strategy}") String strategy){
        if(strategy.equals("single")){
            return new SingleLocationStrategy(stockRepository, locationRepository);
        }else if(strategy.equals("abundant")){
            return new MultipleLocationStrategy(stockRepository);
        }else
            throw new RuntimeException("Invalid strategy selected!!");
    }
}
