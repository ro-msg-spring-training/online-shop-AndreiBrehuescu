package ro.msg.learning.shop.service.implementation;

import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.models.Customer;
import ro.msg.learning.shop.repository.CustomerRepository;

@Service
@AllArgsConstructor
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Customer customer = customerRepository.findByUsername(s);
        if(customer == null){
            throw new RuntimeException("Username or password invalid!!");
        }else{
            return new User(customer.getUsername(), customer.getPassword(), AuthorityUtils.NO_AUTHORITIES);
        }
    }
}
