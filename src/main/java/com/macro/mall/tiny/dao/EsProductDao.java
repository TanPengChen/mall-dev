package com.macro.mall.tiny.dao;

import com.macro.mall.tiny.nosql.elasticsearch.document.EsProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 搜索商品中自定义的Dao
 *
 * @author TANPENG
 * @version 1.0
 * @date 2020/12/24 17:12
 */
public interface EsProductDao {

    List<EsProduct> getAllEsProductList(@Param("id") Long id);
}
