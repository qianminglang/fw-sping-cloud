package com.yisu.elasticsearch;

import cn.hutool.json.JSONUtil;
import com.yisu.elasticsearch.entity.Order;
import com.yisu.elasticsearch.entity.SortingField;
import com.yisu.elasticsearch.repository.OrderRepository;
import com.yisu.elasticsearch.service.ElasticService;
import org.apache.lucene.search.SortField;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author xuyisu
 * @date 2020/10/26
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = FwElasticSearchStarterDataApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class QueryServiceTest {

    @Autowired
    private ElasticService elasticService;

    /**
     *
     * 创建index 输入数据
     *
     * */
    @Test
    public void save(){
        Random random = new Random();
        for(int i = 0 ; i < 10; i++){
            Order order = new Order();
            int j = random.nextInt(20) % 20 + 1;
            order.setId(i);
            order.setStoreId(j);
            order.setStoreName("旗舰店"+ j);
            order.setCategoryId(j);
            order.setCategoryCode("shirt_"+j);
            order.setProductCode("product_"+i);
            order.setQuantity(random.nextInt(20) % 20 + 1);
            order.setAmount(200 + (random.nextInt(20) % 20 + 1));
            order.setPayDate(new Date());
            elasticService.save(order);
        }

    }


    @Test
    public void findOrderByStoreName(){
        List<Order> storeName = elasticService.findOrderByStoreName("旗舰店1");
        System.out.println(JSONUtil.toJsonStr(storeName));
    }

    @Test
    public void findOrderLikeStoreName(){
        List<Order> storeName = elasticService.findOrderLikeStoreName("旗舰店1");
        System.out.println(JSONUtil.toJsonStr(storeName));
    }


    @Test
    public void searchByKeyWords(){
        List<Order> orders = elasticService.findAll();
        System.out.println(JSONUtil.toJsonStr(orders));
    }




}
