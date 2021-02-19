package com.macro.mall.tiny.service.impl;

import com.github.pagehelper.PageHelper;
import com.macro.mall.tiny.mbg.mapper.SmsHomeAdvertiseMapper;
import com.macro.mall.tiny.mbg.model.SmsHomeAdvertise;
import com.macro.mall.tiny.mbg.model.SmsHomeAdvertiseExample;
import com.macro.mall.tiny.service.SmsHomeAdvertiseService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * TODO
 *
 * @author TANPENG
 * @version 1.0
 * @date 2021/2/18 14:36
 */

@Service
public class SmsHomeAdvertiseServiceImpl implements SmsHomeAdvertiseService {


    @Autowired
    private SmsHomeAdvertiseMapper advertiseMapper;

    @Override
    public List<SmsHomeAdvertise> list(String name, Integer type, String endTime, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        SmsHomeAdvertiseExample example = new SmsHomeAdvertiseExample();
        SmsHomeAdvertiseExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(name)){
            criteria.andNameLike("%" + name + "%");
        }
        if (type != null){
            criteria.andTypeEqualTo(type);
        }
        if (!StringUtils.isEmpty(endTime)){
            String startStr = endTime + " 00:00:00";
            String endStr = endTime + " 23:59:59";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date start = null;
            try {
                start = sdf.parse(startStr);
            }catch (ParseException e){
                e.printStackTrace();
            }
            Date end = null;
            try {
                end = sdf.parse(endStr);
            }catch (ParseException e){
                e.printStackTrace();
            }
            if (start != null && end != null){
                criteria.andEndTimeBetween(start,end);
            }
        }
        example.setOrderByClause("sort desc");
        return advertiseMapper.selectByExample(example);
    }

    @Override
    public int create(SmsHomeAdvertise homeAdvertise) {
        homeAdvertise.setClickCount(0);
        homeAdvertise.setOrderCount(0);
        return advertiseMapper.insert(homeAdvertise);
    }

    @Override
    public int delete(Long ids) {
        return advertiseMapper.deleteByPrimaryKey(ids);
    }
}
