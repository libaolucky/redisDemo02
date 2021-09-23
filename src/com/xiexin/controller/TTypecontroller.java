package com.xiexin.controller;

import com.xiexin.bean.TType;
import com.xiexin.service.TTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/type")
public class TTypecontroller {

    @Autowired
    private TTypeService tTypeService;
    //写一个全查的数据的接口 给 前端的下拉框使用， 对应的是全查
    // 注意 给数据，直接用 json ，不在 转发 和 el /jstl表达式
    @RequestMapping("/selectAll")
    @ResponseBody
    public Map selectAll() throws IOException {
        // 调用 service 层。。。。
        List<TType> tTypes = tTypeService.selectByExample(null);
        Map codeMap=new HashMap();
        codeMap.put("code",0);
        codeMap.put("data",tTypes);

        return codeMap;
    }

}
