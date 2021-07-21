package com.jumia.SQLite.springboot;

import com.jumia.SQLite.springboot.viewmodel.CustomerViewModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class SpringBootAndSqLiteApplicationTests {

	@Autowired
	private CustomerViewModel viewModel;

	@Test
	public void contextLoads() throws Exception {
		assertThat(viewModel).isNotNull();
	}

}
