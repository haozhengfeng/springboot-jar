package com.mybatis.mapper;

import com.mybatis.model.Button;
import com.mybatis.model.ButtonExample;
import java.util.List;

public interface ButtonMapper {
    long countByExample(ButtonExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Button record);

    int insertSelective(Button record);

    List<Button> selectByExample(ButtonExample example);

    Button selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Button record);

    int updateByPrimaryKey(Button record);
}