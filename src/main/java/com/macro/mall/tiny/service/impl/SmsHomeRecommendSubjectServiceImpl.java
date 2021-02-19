package com.macro.mall.tiny.service.impl;

import com.github.pagehelper.PageHelper;
import com.macro.mall.tiny.mbg.mapper.SmsHomeRecommendSubjectMapper;
import com.macro.mall.tiny.mbg.model.SmsHomeRecommendSubject;
import com.macro.mall.tiny.mbg.model.SmsHomeRecommendSubjectExample;
import com.macro.mall.tiny.service.SmsHomeRecommendSubjectService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO
 *
 * @author TANPENG
 * @version 1.0
 * @date 2021/2/19 11:20
 */

@Service
public class SmsHomeRecommendSubjectServiceImpl implements SmsHomeRecommendSubjectService {


    @Autowired
    private SmsHomeRecommendSubjectMapper recommendProductMapper;


    @Override
    public List<SmsHomeRecommendSubject> list(String subjectName, Integer recommendStatus, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        SmsHomeRecommendSubjectExample example = new SmsHomeRecommendSubjectExample();
        SmsHomeRecommendSubjectExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(subjectName)){
            criteria.andSubjectNameLike("%" + subjectName + "%");
        }
        if (recommendStatus != null){
            criteria.andRecommendStatusEqualTo(recommendStatus);
        }
        example.setOrderByClause("sort desc");
        return recommendProductMapper.selectByExample(example);
    }
}
