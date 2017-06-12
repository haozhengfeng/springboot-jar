package com.solr;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.request.schema.SchemaRequest.DynamicField;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.stereotype.Component;

@Component
public class SolrBean {
    
    @Resource
    private SolrClient solrClient;
    
    
//    @Resource
//    private SolrProductRepository solrProductRepository;
    
    
    public void run() throws SolrServerException, IOException {        
//        Iterable<Product> productList = solrProductRepository.findAll();
//        while (productList.iterator().hasNext()) {
//            Product product = (Product) productList.iterator().next();
//            System.out.println("solr获取值：" + product.getId());
//        }
    }
    
    public void query() {
    	try {
        SolrQuery query = new SolrQuery();// 查询
        query.setQuery("name:solr");
        
        QueryResponse response = solrClient.query("test",query);
        SolrDocumentList solrDocumentList = response.getResults();
        for (SolrDocument sd : solrDocumentList) {
            System.out.println("solr获取值：" + sd.getFieldValue("id"));
            System.out.println("solr获取值：" + sd.getFieldValue("name"));
        }
        
    	} catch (SolrServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    
    public void highlight(){
    	try {
			SolrQuery query = new SolrQuery();// 查询
			query.setHighlight(true); 
			query.setQuery("name:solr");
	        query.addHighlightField("name");// 高亮字段 
	        query.setHighlightSimplePre("<font color='red'>");//标记，高亮关键字前缀  
	        query.setHighlightSimplePost("</font>");//后缀  
	        query.setHighlightSnippets(3);//结果分片数，默认为1  
	        query.setHighlightFragsize(1000);//每个分片的最大长度，默认为100 
			
			QueryResponse response = solrClient.query("test",query);
			Map<String,Map<String,List<String>>> tempMap = response.getHighlighting();
			for(Map.Entry<String, Map<String,List<String>>> entry : tempMap.entrySet()) {
				System.out.println(entry.getValue());
			}
			
		} catch (SolrServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
    
    public void addDoc() {
        //创建doc文档
        SolrInputDocument doc = new SolrInputDocument();
        doc.addField("id", 1);
        doc.addField("name", "solr is best");
        try {
            //添加一个doc文档
            UpdateResponse response = solrClient.add("test",doc);
            System.out.println(solrClient.commit("test"));//commit后才保存到索引库
            System.out.println(response);
            System.out.println("query time：" + response.getQTime());
            System.out.println("Elapsed Time：" + response.getElapsedTime());
            System.out.println("status：" + response.getStatus());
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void delete() {
        try {
			solrClient.deleteByQuery("test","*:*");
		} catch (SolrServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
