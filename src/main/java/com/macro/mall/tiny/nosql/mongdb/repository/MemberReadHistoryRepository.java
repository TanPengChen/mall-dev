package com.macro.mall.tiny.nosql.mongdb.repository;

import com.macro.mall.tiny.nosql.mongdb.MemberReadHistory;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * 会员商品浏览历史Repository
 *
 * @author TANPENG
 * @version 1.0
 * @date 2020/12/25 13:09
 */

public interface MemberReadHistoryRepository extends MongoRepository<MemberReadHistory,String> {

    /**
     * 根据会员Id时间倒叙获取浏览记录
     * @param memberId
     * @return
     */
    List<MemberReadHistory> findByMemberIdOrderByCreateTimeDesc(Long memberId);
}
