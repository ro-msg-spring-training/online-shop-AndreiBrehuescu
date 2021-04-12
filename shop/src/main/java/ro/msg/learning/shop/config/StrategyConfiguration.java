package ro.msg.learning.shop.config;


import lombok.AllArgsConstructor;
import lombok.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.msg.learning.shop.repository.LocationRepository;
import ro.msg.learning.shop.repository.StockRepository;

@Configuration
@AllArgsConstructor
public class StrategyConfiguration {

    //private final StockRepository stockRepository;

   // private final LocationRepository locationRepository;

//    @Bean
//    public StrategyConfiguration(@Value{"strategy"} String strategy){
//        if(strategy.equals("single")){
//            //return new SingleLocationStrategy(stockRepository, locationRepository);
//        }else if(strategy.equals("mostAbundant")){
//           // return new MostAbundantStrategy(stockRepository, locationRepository);
//        }else{
//            //throw new Exception("Stategy not found!");
//        }
//    }
}
