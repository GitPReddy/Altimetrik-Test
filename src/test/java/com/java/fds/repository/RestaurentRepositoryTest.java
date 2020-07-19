package com.java.fds.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.java.fds.model.Restaurent;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RestaurentRepositoryTest{
	
	@Autowired
    private TestEntityManager entityManager;
	
	@Autowired
	private RestaurentRepository restaurentRepository;
	
	@Test
	public void whenFindByName_thenReturnRestaurent() {
		
		Restaurent restaurent = new Restaurent("Paradise");
		
		entityManager.persist(restaurent);
	    entityManager.flush();
	    
	    Restaurent found = restaurentRepository.findByName(restaurent.getName());
	    
	    assertThat(found.getName())
	      .isEqualTo(restaurent.getName());
	}
	
}