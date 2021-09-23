package com.xiexin.service;

import com.xiexin.bean.TType;
import com.xiexin.bean.TTypeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TTypeService {
   
    long countByExample(TTypeExample example);

    int deleteByExample(TTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TType record);

    int insertSelective(TType record);

    List<TType> selectByExample(TTypeExample example);

    TType selectByPrimaryKey(Integer id);
  
    int updateByExampleSelective(@Param("record") TType record, @Param("example") TTypeExample example);

    int updateByExample(@Param("record") TType record, @Param("example") TTypeExample example);

    int updateByPrimaryKeySelective(TType record);

    int updateByPrimaryKey(TType record);

}
