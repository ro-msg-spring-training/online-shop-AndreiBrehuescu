package ro.msg.learning.shop.strategy;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import ro.msg.learning.shop.stategy.MultipleLocationStrategy;
import ro.msg.learning.shop.stategy.SingleLocationStrategy;
import ro.msg.learning.shop.stategy.interfaces.IStrategy;

import static org.junit.jupiter.api.Assertions.assertFalse;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application-integrationtest.properties")
public class StrategyTest {

    @Value("${strategy}")
    public String strategyString;

    @Qualifier("selectStrategy")
    @Autowired
    private IStrategy strategy;

    @Autowired
    private MockMvc mvc;

    @Test
    public void checkStrategy(){
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
        String s = this.strategyString;

        assert( s.equals("single"));
    }

    @Test
    public void checkFalseStrategy(){
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
        String s = this.strategyString;

        assertFalse( !s.equals("single"));
    }

    @Test
    public void checkStategyClass(){
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
        assert (strategy.getClass() == SingleLocationStrategy.class);
    }

    @Test
    public void checkStategyClassFalse(){
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
        assert (strategy.getClass() != MultipleLocationStrategy.class);
    }
}
