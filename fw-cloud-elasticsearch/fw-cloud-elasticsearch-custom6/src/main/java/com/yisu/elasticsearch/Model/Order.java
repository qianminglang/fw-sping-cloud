package com.yisu.elasticsearch.Model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

/**
 * @author xuyisu
 * @date 2020/10/26
 */
@Data
@NoArgsConstructor
public class Order {

    private long id;

    /**
     * 店铺ID
     */
    @JSONField(name="store_id")
    private int storeId;

    /**
     * 店铺名字
     */
    @JSONField(name="store_name")
    private String storeName;

    /**
     * 类目ID
     */
    @JSONField(name="category_id")
    private int categoryId;
    /**
     * 类目名称
     */
    @JSONField(name="category_code")
    private String categoryCode;
    /**
     * 货号
     */
    @JSONField(name="product_code")
    private String productCode;
    /**
     * 销售件数
     */
    private int quantity;
    /**
     * 销售金额
     */
    private double amount;
    /**
     * 支付时间
     */
    @JSONField(name="pay_date")
    private Date payDate;


    public Order(long id, int storeId, String storeName, int categoryId, String categoryCode, String productCode, int quantity, double amount, Date payDate) {
        this.id = id;
        this.storeId = storeId;
        this.storeName = storeName;
        this.categoryId = categoryId;
        this.categoryCode = categoryCode;
        this.productCode = productCode;
        this.quantity = quantity;
        this.amount = amount;
        this.payDate = payDate;
    }
}
