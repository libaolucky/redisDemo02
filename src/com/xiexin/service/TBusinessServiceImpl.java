package com.xiexin.service;

import com.xiexin.bean.TBusiness;
import com.xiexin.bean.TBusinessExample;
import com.xiexin.dao.TBusinessDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("tBusinessService")
public class TBusinessServiceImpl implements TBusinessService{
	@Autowired(required = false)
	private TBusinessDAO tBusinessDAO;
	public long countByExample(TBusinessExample example){
    	return tBusinessDAO.countByExample(example);
    }

	public int deleteByExample(TBusinessExample example){
    	return tBusinessDAO.deleteByExample(example);
    }

	public int deleteByPrimaryKey(Integer id){
    	return tBusinessDAO.deleteByPrimaryKey(id);
    }

	public int insert(TBusiness record){
    	return tBusinessDAO.insert(record);
    }

	public int insertSelective(TBusiness record){
    	return tBusinessDAO.insertSelective(record);
    }

	public List<TBusiness> selectByExample(TBusinessExample example){
    	return tBusinessDAO.selectByExample(example);
    }

	public TBusiness selectByPrimaryKey(Integer id){
    	return tBusinessDAO.selectByPrimaryKey(id);
    }
  
	public int updateByExampleSelective(TBusiness record, TBusinessExample example){
    	return tBusinessDAO.updateByExampleSelective(record, example);
    }

	public int updateByExample(TBusiness record, TBusinessExample example){
    	return tBusinessDAO.updateByExample(record, example);
    }

	public int updateByPrimaryKeySelective(TBusiness record){
    	return tBusinessDAO.updateByPrimaryKeySelective(record);
    }

	public int updateByPrimaryKey(TBusiness record){
    	return tBusinessDAO.updateByPrimaryKey(record);
    }

	// 2表 联查， 因为是将 N张表显示到 一张表格中，就要用到map，不是用的 1 对多，这些东西
	@Override
	public List<Map> selectTwoTabel() {
		return tBusinessDAO.selectTwoTabel();
	}


}
