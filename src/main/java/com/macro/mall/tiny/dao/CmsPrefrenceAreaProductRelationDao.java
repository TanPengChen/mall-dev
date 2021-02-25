package com.macro.mall.tiny.dao;

import com.macro.mall.tiny.mbg.model.CmsPrefrenceAreaProductRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CmsPrefrenceAreaProductRelationDao {

    /**
     * 批量创建
     * @param prefrenceAreaProductRelationList
     * @return
     */
    int insertList(@Param("list") List<CmsPrefrenceAreaProductRelation> prefrenceAreaProductRelationList);
}
