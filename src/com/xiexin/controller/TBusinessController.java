package com.xiexin.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiexin.bean.TBusiness;
import com.xiexin.service.TBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/tb")
public class TBusinessController {
    @Autowired
    private TBusinessService tBusinessService;

    @RequestMapping("/selectTwoTabel")
    @ResponseBody //没这个注解，不返回给前端json数据！！！
    public Map selectTwoTabel(){
        List<Map> maps = tBusinessService.selectTwoTabel();
        Map codeMap=new HashMap();
        codeMap.put("code",0);
        codeMap.put("data",maps);
        return codeMap;
    }

    //增加
    @RequestMapping("/insert")
    @ResponseBody
    public Map insert(@RequestBody TBusiness tBusiness){
        Map codeMap=new HashMap();
        int i=tBusinessService.insertSelective(tBusiness);
        if(i==1){
            codeMap.put("code",0);
            codeMap.put("msg","添加成功！");
        }else{
            codeMap.put("code",400);
            codeMap.put("msg","添加失败！");
        }
        return codeMap;
    }
    //分页
    @RequestMapping("/selectByPage")
    @ResponseBody
    public Map selectByPage(@RequestParam(defaultValue = "1",required = true,name="page") Integer page,
                            @RequestParam(defaultValue = "3",required = true,name="pageSize")Integer pageSize){
        //该分页可以分多表查询， 牛逼！！！！ 只能用于mybatis

        // 分页的第一种方法， 仅限于mybatis ！
        //使用的是  pageHelper 分页， 基于 aop拦截
        // page 是当前页， 默认值 应该是1， pageSize 是值的条数
        //如果没有动态查询， 直接让 Example 为null 就可以了
        PageHelper.startPage(page,pageSize); // 这个PageHelper 拿到前端的 参数
        List<TBusiness> tBusinesses=tBusinessService.selectByExample(null); //查询的全部数据
       PageInfo<TBusiness> pageInfo=new PageInfo<>(tBusinesses); // PageHelper 进行拦截
       long total= pageInfo.getTotal(); //拿到总条数
       Map codeMap=new HashMap();
       codeMap.put("code",0);
       codeMap.put("data",pageInfo);
       codeMap.put("total",total);

       return codeMap;







    }
}
