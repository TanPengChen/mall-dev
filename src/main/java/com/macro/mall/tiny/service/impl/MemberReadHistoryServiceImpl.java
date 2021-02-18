package com.macro.mall.tiny.service.impl;

import com.macro.mall.tiny.nosql.mongdb.MemberReadHistory;
import com.macro.mall.tiny.nosql.mongdb.repository.MemberReadHistoryRepository;
import com.macro.mall.tiny.service.MemberReadHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 会员浏览历史记录管理Service实习类
 *
 * @author TANPENG
 * @version 1.0
 * @date 2020/12/25 13:15
 */

@Service
public class MemberReadHistoryServiceImpl implements MemberReadHistoryService {

    @Autowired
    private MemberReadHistoryRepository memberReadHistoryRepository;


    @Override
    public int create(MemberReadHistory memberReadHistory) {
        memberReadHistory.setId(null);
        memberReadHistory.setCreateTime(new Date());
        memberReadHistoryRepository.save(memberReadHistory);
        return 1;
    }

    @Override
    public int delete(List<String> ids) {
        List<MemberReadHistory> list = new ArrayList<>();
        for (String id:ids) {
            MemberReadHistory memberReadHistory = new MemberReadHistory();
            memberReadHistory.setId(id);
            list.add(memberReadHistory);
        }
        memberReadHistoryRepository.deleteAll(list);
        return list.size();
    }

    @Override
    public List<MemberReadHistory> list(Long memberId) {
        return memberReadHistoryRepository.findByMemberIdOrderByCreateTimeDesc(memberId);
    }
}
