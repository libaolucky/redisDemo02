package com.xiexin.service;

import com.xiexin.bean.TType;
import com.xiexin.bean.TTypeExample;
import com.xiexin.dao.TTypeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("tTyptService")
public class TTypeServiceImpl implements TTypeService {
	@Autowired(required = false)
	private TTypeDAO tTyptDAO;
	public long countByExample(TTypeExample example){
    	return tTyptDAO.countByExample(example);
    }

	public int deleteByExample(TTypeExample example){
    	return tTyptDAO.deleteByExample(example);
    }

	public int deleteByPrimaryKey(Integer id){
    	return tTyptDAO.deleteByPrimaryKey(id);
    }

	public int insert(TType record){
    	return tTyptDAO.insert(record);
    }

	public int insertSelective(TType record){
    	return tTyptDAO.insertSelective(record);
    }

	public List<TType> selectByExample(TTypeExample example){
    	return tTyptDAO.selectByExample(example);
    }

	public TType selectByPrimaryKey(Integer id){
    	return tTyptDAO.selectByPrimaryKey(id);
    }
  
	public int updateByExampleSelective(TType record, TTypeExample example){
    	return tTyptDAO.updateByExampleSelective(record, example);
    }

	public int updateByExample(TType record, TTypeExample example){
    	return tTyptDAO.updateByExample(record, example);
    }

	public int updateByPrimaryKeySelective(TType record){
    	return tTyptDAO.updateByPrimaryKeySelective(record);
    }

	public int updateByPrimaryKey(TType record){
    	return tTyptDAO.updateByPrimaryKey(record);
    }


}
