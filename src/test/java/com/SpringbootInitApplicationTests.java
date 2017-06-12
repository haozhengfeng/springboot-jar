package com;


import java.io.IOException;

import org.apache.solr.client.solrj.SolrServerException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.solr.SolrBean;
import com.transactionManager.test.ButtonService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootInitApplicationTests {

	@Autowired
	ButtonService buttonService;
	
	@Autowired
	SolrBean solrBean;
	
	@Test
	public void button(){
		buttonService.addButton();
	}	
	
	@Test
	public void query(){
		solrBean.query();
	}
	
	@Test
	public void highlight(){
		solrBean.highlight();
	}
	
	@Test
	public void addDoc(){
		solrBean.addDoc();
	}

	@Test
	public void delete(){
		solrBean.delete();
	}

}
