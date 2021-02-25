package com.macro.mall.tiny.dao;

import com.macro.mall.tiny.mbg.model.CmsSubjectProductRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CmsSubjectProductRelationDao {
    /**
     * 批量创建
     * @param subjectProductRelationList
     * @return
     */
    int insertList(@Param("list") List<CmsSubjectProductRelation> subjectProductRelationList);
}
