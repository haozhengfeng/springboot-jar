package com;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mybatis.mapper.ButtonMapper;
import com.mybatis.model.Button;
import com.mybatis.model.ButtonExample;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootInitApplicationTests {

	@Autowired
	ButtonMapper buttonMapper;
	
	@Test
	public void button(){
		
		Page pageh = PageHelper.startPage(1, 2);
		
//		Button button = new Button();
//		button.setAppid("123");
//		button.setKey("123");
//		button.setMedia_id("123");
//		buttonMapper.insertSelective(button);
		
		ButtonExample example = new ButtonExample();
		example.setOrderByClause(" id desc ");
		List<Button> buttons = buttonMapper.selectByExample(example);
		for(Button button : buttons){
			System.out.println(button.getId());
		}
	}	


}
