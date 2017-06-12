package com.transactionManager.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mybatis.mapper.ButtonMapper;
import com.mybatis.model.Button;
import com.mybatis.model.ButtonExample;

@Service
public class ButtonService {
	@Autowired
	ButtonMapper buttonMapper;
	
	public void getButton(){
		
		Page pageh = PageHelper.startPage(1, 2);
		
		ButtonExample example = new ButtonExample();
		example.setOrderByClause(" id desc ");
		List<Button> buttons = buttonMapper.selectByExample(example);
		for(Button button : buttons){
			System.out.println(button.getId());
		}
	}
	
	public void addButton(){
		
		Button button = new Button();
		button.setAppid("123");
		button.setKey("123");
		button.setMedia_id("123");
		buttonMapper.insertSelective(button);
		
		getButton();
		
	}	
}
