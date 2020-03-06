package com.gem.sell.form;

import lombok.Data;

/**
 * 2020-03-01 16:43
 */
@Data
public class CategoryForm {

    private Integer categoryId;

    /** 类目名字. */
    private String categoryName;

    /** 类目编号. */
    private Integer categoryType;
}
