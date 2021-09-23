package com.xiexin.redistest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.JedisPool;

import java.util.List;
import java.util.Map;
import java.util.Set;

/*
* redis 的测试， 测试和ssm项目结合
* ssm项目如何使用 redis，第一种方式:使用jedis ，类似于jdbc
*   //第一步：在applicationContext.xml 中的注释去掉
*   //第二部：在db.properties 中的把redis 配置的注释去掉
*   
*   springmvc 中的单元测试
*   为什么要用 junit 单元测试，因为在框架中传统的main方法，已经无法
*   处理， 如 req 请求，等等， 无法满足 测试需求了
*   单元测试的好处是，在最小的代码结构单元中 找出 bug,最快速的找到bug的所在地
*   迅速的解决， 1个dao方法1个测试， 1个controller 1个测试， 1个service一个测试
*  
* */
@RunWith(SpringJUnit4ClassRunner.class)  //使用 spring的junit测试
@ContextConfiguration({"classpath:applicationContext.xml"})  //模拟ssm框架运行后加载xml容器
public class MyRedisTest {
    @Autowired
    private JedisPool jedisPool;
    //测试 String 类型
    @Test
    public void test01() throws InterruptedException {
        // redisTemplate
        String pcode = jedisPool.getResource().set("pcode", "4765");
        System.out.println("pcode = " + pcode);
        //查询  pcode 这个key 在不在，如果在，就把他设置为120 倒计时，
       // 且 值也该为7788 ，并且 在10s 后输出 所剩下的倒计时！
        Boolean pcode1 = jedisPool.getResource().exists("pcode");
        if(pcode1){
            //set  phoneCode 3343  , expire  phoneCode  60
            String pcode2 = jedisPool.getResource().setex("pcode",120,"7788");;
            System.out.println("pcode2 = " + pcode2);
            // 且 值也该为7788 ，并且 在10s 后输出 所剩下的倒计时！
            Thread.sleep(1000);
            Long pcode3 = jedisPool.getResource().ttl("pcode");
            System.out.println("pcode3 = " + pcode3);
            // 输出完毕后， 将该key 设置成 永久的key  返回0 和1
            Long pcode4 = jedisPool.getResource().persist("pcode");
            System.out.println("pcode4 = " + pcode4);
            Long pcode5 = jedisPool.getResource().ttl("pcode");
            System.out.println("pcode5 = " + pcode5);
        }else{
            System.out.println(" pcode1="+ pcode1 +",key不存在");
        }
    }

    // 测试常用命令
    @Test
    public void test02(){
        //查询所有的key
        Set<String> keys = jedisPool.getResource().keys("*");
        for (String key : keys) {
           String value=jedisPool.getResource().get(key);
            System.out.println("key= " + key+":"+"value"+value);

            //自增
            Long incr = jedisPool.getResource().incr(key);
            System.out.println("incr = " + incr);
            String value1=jedisPool.getResource().get(key);
            System.out.println("key= " + key+":"+"value"+value1);
        }
    }

    //测试hash
    @Test
    public void test03(){
        // 增加
        Long hset = jedisPool.getResource().hset("food", "name", "苹果");
        Long hset1 = jedisPool.getResource().hset("food", "color", "红色");
        System.out.println("hset = " + hset);
        //查
        String color=jedisPool.getResource().hget("food","color");
        System.out.println("color = " + color);

        //查 key
        Set<String> food = jedisPool.getResource().hkeys("food");
        for (String s : food) {
            System.out.println("key = " + s);
        }
        //查 k-v
        Map<String, String> food1 = jedisPool.getResource().hgetAll("food");
        for (String s : food1.keySet()) {
            System.out.println("s = " + s);
        }
    }
    
    // 测试list
    @Test
    public void test04(){
         jedisPool.getResource().lpush("names", "唐僧", "孙悟空");
        List<String> names = jedisPool.getResource().lrange("names", 0, -1);
        for (String name : names) {
            System.out.println("names = " + names);
        }

        String names1 = jedisPool.getResource().lpop("names");
        System.out.println("names1 = " + names1);

        List<String> names2 = jedisPool.getResource().lrange("names", 0, -1);
        for (String s : names2) {
            System.out.println("s = " + s);
        }

    }
    
    // 测试 set
    @Test
    public void test05(){
        jedisPool.getResource().sadd("pnames","张三","李四");
        Set<String> pnames = jedisPool.getResource().smembers("pnames");
        for (String pname : pnames) {
            System.out.println("pname = " + pname);
        }
        Long pnames1 = jedisPool.getResource().scard("pnames");
        System.out.println("pnames1 = " + pnames1);

        //指定删除： srem key value
        jedisPool.getResource().srem("pnames","张三");
        //随机的删除！   spop names
        jedisPool.getResource().spop("pnames");
    }

    //测试 zest
    @Test
    public void test06(){
//        增加： zadd key 分数  值  pnames
        jedisPool.getResource().zadd("xnames",1.0,"大娃");
        jedisPool.getResource().zadd("xnames",2.0,"二娃");
        jedisPool.getResource().zadd("xnames",3.0,"三娃");
        jedisPool.getResource().zadd("xnames",4.0,"四娃");
//        遍历： zrange key 0 -1 withscores  加上 withscores  带分数（下标）， 不带直接全部显示值
        Set<String> xnames = jedisPool.getResource().zrange("xnames", 0, -1);
        for (String xname : xnames) {
            System.out.println("xnames = " + xnames);
        }

//        查条数： zcard key
        Long xnames1 = jedisPool.getResource().zcard("xnames");
        System.out.println("xnames1 = " + xnames1);

//        指定的删除： 移除集合中的一个或者多个成员 zrem key value
        Long zrem = jedisPool.getResource().zrem("xnames", "三娃");
        System.out.println("zrem = " + zrem);
    }
}
