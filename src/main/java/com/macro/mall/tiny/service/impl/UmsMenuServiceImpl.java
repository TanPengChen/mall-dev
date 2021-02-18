package com.macro.mall.tiny.service.impl;

import com.github.pagehelper.PageHelper;
import com.macro.mall.tiny.mbg.mapper.UmsMenuMapper;
import com.macro.mall.tiny.mbg.model.UmsMenu;
import com.macro.mall.tiny.mbg.model.UmsMenuExample;
import com.macro.mall.tiny.mbg.model.UmsMenuNode;
import com.macro.mall.tiny.service.UmsMenuService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * TODO
 *
 * @author TANPENG
 * @version 1.0
 * @date 2021/1/15 19:49
 */
@Service
public class UmsMenuServiceImpl implements UmsMenuService {

    @Autowired
    private UmsMenuMapper umsMenuMapper;

    @Override
    public List<UmsMenu> list(Long parentId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        UmsMenuExample example = new UmsMenuExample();
        example.setOrderByClause("sort desc");
        example.createCriteria().andParentIdEqualTo(parentId);
        return umsMenuMapper.selectByExample(example);
    }

    @Override
    public int updateHidden(Long id, Integer hidden) {
        UmsMenu umsMenu = new UmsMenu();
        umsMenu.setId(id);
        umsMenu.setHidden(hidden);
        return umsMenuMapper.updateByPrimaryKeySelective(umsMenu);
    }

    @Override
    public int create(UmsMenu umsMenu) {
        umsMenu.setCreateTime(new Date());
        updateLevel(umsMenu);
        return umsMenuMapper.insert(umsMenu);
    }

    @Override
    public int delete(Long id) {
        return umsMenuMapper.deleteByPrimaryKey(id);
    }

    @Override
    public UmsMenu getItem(Long id) {
        return umsMenuMapper.selectByPrimaryKey(id);
    }

    @Override
    public int update(Long id, UmsMenu umsMenu) {
        umsMenu.setId(id);
        updateLevel(umsMenu);
        return umsMenuMapper.updateByPrimaryKeySelective(umsMenu);
    }

    @Override
    public List<UmsMenuNode> treeList() {
        List<UmsMenu> umsMenuList = umsMenuMapper.selectByExample(new UmsMenuExample());
        List<UmsMenuNode> result = umsMenuList.stream().filter(umsMenu -> umsMenu.getParentId().equals(0L)).map(umsMenu -> covertMenuNode(umsMenu,umsMenuList)).collect(Collectors.toList());
        return result;
    }

    /**
     * UmsMenu转化为UmsMenuNode并设置children属性
     * @param umsMenu
     * @param umsMenuList
     * @return
     */
    private UmsMenuNode covertMenuNode(UmsMenu umsMenu, List<UmsMenu> umsMenuList) {
        UmsMenuNode node = new UmsMenuNode();
        BeanUtils.copyProperties(umsMenu,node);
        List<UmsMenuNode> children = umsMenuList.stream().filter(subMenu -> subMenu.getParentId().equals(umsMenu.getId()))
                .map(subMenu -> covertMenuNode(subMenu,umsMenuList)).collect(Collectors.toList());
        node.setChildren(children);
        return node;
    }

    /**
     * 修改菜单层级
     * @param umsMenu
     */
    private void updateLevel(UmsMenu umsMenu) {

        //没有父级ID时
        if (umsMenu.getParentId() == 0){
            umsMenu.setLevel(0);
        }else {
            //有父菜单时选择根据父菜单level设置
           UmsMenu parentUmsMenu =  umsMenuMapper.selectByPrimaryKey(umsMenu.getParentId());
            if (parentUmsMenu != null){
                umsMenu.setLevel(parentUmsMenu.getLevel() + 1);
            }else {
                umsMenu.setLevel(0);
            }
        }

    }
}
