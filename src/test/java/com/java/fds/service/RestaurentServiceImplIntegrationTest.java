package com.java.fds.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.java.fds.model.Restaurent;
import com.java.fds.repository.RestaurentRepository;

@RunWith(SpringRunner.class)
public class RestaurentServiceImplIntegrationTest{
	
	@TestConfiguration
    static class RestaurentServiceImplTestContextConfiguration {
  
        @Bean
        public RestaurentService restaurentService() {
            return new RestaurentServiceImpl();
        }
    }
 
    @Autowired
    private RestaurentService restaurentService;
 
    @MockBean
    private RestaurentRepository restaurentRepository;
    
    @Before
    public void setUp() {
    	Restaurent restaurent = new Restaurent("Paradise");
     
        Mockito.when(restaurentRepository.findByName(restaurent.getName()))
          .thenReturn(restaurent);
    }
    
    @Test
    public void whenValidName_thenRestaurentShouldBeFound() {
        String name = "Paradise";
        Restaurent found = restaurentService.getRestaurentByName(name);
      
         assertThat(found.getName())
          .isEqualTo(name);
     }
}