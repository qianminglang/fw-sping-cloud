package com.yisu.elasticsearch.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

/**
 * @author xuyisu
 * @date 2020/10/26
 */
@Data
@Document(indexName = "order_index_2021",type = "_doc", shards = 5, replicas = 0)
public class Order {


    private long id;

    /**
     * 店铺ID
     */
    @Field(type = FieldType.Integer)
    @JSONField(name="store_id")
    private int storeId;

    /**
     * 店铺名字
     */
    @Field(type = FieldType.Keyword)
    @JSONField(name="store_name")
    private String storeName;

    /**
     * 类目ID
     */
    @Field(type = FieldType.Integer)
    @JSONField(name="category_id")
    private int categoryId;
    /**
     * 类目名称
     */
    @Field(type = FieldType.Keyword)
    @JSONField(name="category_code")
    private String categoryCode;
    /**
     * 货号
     */
    @Field(type = FieldType.Keyword)
    @JSONField(name="product_code")
    private String productCode;
    /**
     * 销售件数
     */
    @Field(type = FieldType.Integer)
    private int quantity;
    /**
     * 销售金额
     */
    @Field(type = FieldType.Double)
    private double amount;
    /**
     * 支付时间
     */
    @Field(type = FieldType.Date)
    @JSONField(name="pay_date")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date payDate;


}
