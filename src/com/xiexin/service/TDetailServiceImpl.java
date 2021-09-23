package com.xiexin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xiexin.bean.TDetailExample;
import com.xiexin.bean.TDetail;
import com.xiexin.dao.TDetailDAO;
@Service("tDetailService")
public class TDetailServiceImpl implements TDetailService{
	@Autowired(required = false)
	private TDetailDAO tDetailDAO;
	public long countByExample(TDetailExample example){
    	return tDetailDAO.countByExample(example);
    }

	public int deleteByExample(TDetailExample example){
    	return tDetailDAO.deleteByExample(example);
    }

	public int deleteByPrimaryKey(Integer id){
    	return tDetailDAO.deleteByPrimaryKey(id);
    }

	public int insert(TDetail record){
    	return tDetailDAO.insert(record);
    }

	public int insertSelective(TDetail record){
    	return tDetailDAO.insertSelective(record);
    }

	public List<TDetail> selectByExample(TDetailExample example){
    	return tDetailDAO.selectByExample(example);
    }

	public TDetail selectByPrimaryKey(Integer id){
    	return tDetailDAO.selectByPrimaryKey(id);
    }
  
	public int updateByExampleSelective(TDetail record, TDetailExample example){
    	return tDetailDAO.updateByExampleSelective(record, example);
    }

	public int updateByExample(TDetail record, TDetailExample example){
    	return tDetailDAO.updateByExample(record, example);
    }

	public int updateByPrimaryKeySelective(TDetail record){
    	return tDetailDAO.updateByPrimaryKeySelective(record);
    }

	public int updateByPrimaryKey(TDetail record){
    	return tDetailDAO.updateByPrimaryKey(record);
    }


}
