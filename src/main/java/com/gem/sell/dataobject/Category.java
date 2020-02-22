package com.gem.sell.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author 39726
 * @DynamicUpdate :动态更新数据库updateTime
 * @Data :自动生成get set方法
 */
@Entity
@DynamicUpdate
@Data
@Table(name = "product_category")
public class Category {

    /**类目id*/
    @Id
    @GeneratedValue
    private Integer categoryId;

    /**类目名字*/
    private String categoryName;

    /**类目编号*/
    private Integer categoryType;

    private Date createTime;

    private Date updateTime;

    public Category() {
    }

    public Category(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}
