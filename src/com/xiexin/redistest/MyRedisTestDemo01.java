package com.xiexin.redistest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.JedisPool;

import java.util.List;
import java.util.Set;

import static redis.clients.jedis.BinaryClient.LIST_POSITION.BEFORE;


@RunWith(SpringJUnit4ClassRunner.class)  //使用 spring的junit测试
@ContextConfiguration({"classpath:applicationContext.xml"})  //模拟ssm框架运行后加载xml容器
public class MyRedisTestDemo01 {
    //大作业1： 编程题
    //用java代码写，把咱们班33个人的名字 形成 一个集合，
    //运行后随机点一个人的名字，就把这个人的名字移除。 再次
    //点名是 点 32个人的随机中的一个。
    
    @Autowired
    private JedisPool jedisPool;

    @Test
    public void tt1(){
//        String[] clazzNames={"白世纪","陈红利","陈世纪", "陈洋洋", "杜晓梦", "付春辉", "高芳芳", "郭旭", "胡艺果", "贾礼博", "李雪莹", "李祎豪",
//                "林梦娇", "刘顺顺", "卢光辉", "吕亚伟","宁静静","牛志洋","史倩影","宋健行","孙超阳","孙乾力","田君垚","汪高洋","王学斌","杨天枫",
//                "杨原辉","袁仕奇","张浩宇","张晓宇","张志鹏","赵博苛","邹开源"};
//          //把string数组添加到 set集合里面
//        jedisPool.getResource().sadd("clazz",clazzNames);
        Set<String> clazz = jedisPool.getResource().smembers("clazz");
        Long clazz2 = jedisPool.getResource().scard("clazz");
        System.out.println("clazz2 = " + clazz2);

            String srandmember = jedisPool.getResource().srandmember("clazz");
            System.out.println("srandmember = " + srandmember);
            Long clazz1 = jedisPool.getResource().srem("clazz", srandmember);
            System.out.println("clazz1 = " + clazz1);

          Long clazz3 = jedisPool.getResource().scard("clazz");
            System.out.println("clazz3 = " + clazz3);

    }


//    大作业2：编程题，
//    使用 java 代码编写，
//    有一个双端队列集合， 里面有 10 条数据，
//    查询出  第5个人是什么数据，
//    左边弹出1个 ， 右边弹出1个，打印还剩多少条数据，
//    然后，再 第3个数据前面，插入一个数据，
//    然后，进行查询全部数据进行查看。

    @Test
    public void tt2(){
        //左边增： lpush  key XXX
        Long lpush = jedisPool.getResource().lpush("foods", "香蕉", "雪梨", "荔枝", "葡萄", "苹果","山竹", "青提", "西瓜", "哈密瓜", "火龙果");
        //遍历：  lrange key 0 -1  从0到-1就是遍历全部
//        List<String> foods = jedisPool.getResource().lrange("foods", 0, -1);
//        for (String food : foods) {
//            System.out.println("food = " + food);
//        }
        //查询出  第5个人是什么数据，
        String foods1 = jedisPool.getResource().lindex("foods", 4);
        System.out.println("foods1 = " + foods1);
        //左边弹出1个 ， 右边弹出1个，打印还剩多少条数据，
        jedisPool.getResource().lpop("foods");
        jedisPool.getResource().rpop("foods");
        List<String> ff = jedisPool.getResource().lrange("foods", 0, -1);
        for (String s : ff) {
            System.out.println("s = " + s);
        }
        //然后，再 第3个数据前面，插入一个数据，
        jedisPool.getResource().linsert("foods", BEFORE,"青提","黄瓜");
        //   然后，进行查询全部数据进行查看。
        List<String> ff1 = jedisPool.getResource().lrange("foods", 0, -1);
        for (String s : ff) {
            System.out.println("s = " + s);
        }
    }



}
