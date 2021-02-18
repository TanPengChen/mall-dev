package com.macro.mall.tiny.service;

import com.macro.mall.tiny.nosql.mongdb.MemberReadHistory;

import java.util.List;

/**
 * 会员浏览历史记录管理Service
 */
public interface MemberReadHistoryService {

    /**
     * 生成浏览记录
     */
    int create(MemberReadHistory memberReadHistory);

    /**
     * 删除历史记录
     */
    int delete(List<String> ids);

    /**
     * 获取用例浏览历史记录
     */
    List<MemberReadHistory> list(Long memberId);
}
