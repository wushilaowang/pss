package com.oupu.pss.service.impl;

import com.oupu.pss.dao.CategoryMapper;
import com.oupu.pss.dao.GoodsMapper;
import com.oupu.pss.entity.Category;
import com.oupu.pss.service.CategoryService;
import com.oupu.pss.util.GetTreeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Classname:NavigetionServiceImpl
 * Package:com.oupu.pss.service.impl
 * Description:
 *
 * @Data:2019/12/8 10:39
 * @Author:
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<Map<String,Object>> findAllCat() {
        //获取所有类目
        List<Category> catList=categoryMapper.findAllCat();
        List<Map<String,Object>> list=new ArrayList<>();
        //迭代器遍历
        Iterator<Category> iterator = catList.listIterator();
        while(iterator.hasNext()){
            Map<String,Object> map=new HashMap<>();
            Category next=iterator.next();
            int parentId=next.getParent_id();//获取父id
            if(parentId==0) {//过滤有上级的
                int childSize = next.getChild_size();
                String name = next.getName();
                int id = next.getId();
                if(childSize!=0){//有子菜单
                    map.put("children",getChildren(catList,id));
                }
                map.put("id", id);
                map.put("title", name);
                map.put("spread", true);
                list.add(map);
                //System.out.println(list+"@");
            }

        }
        return list;
    }

    @Override
    @Transactional
    public int addCat(Category category) {
        category.setChild_size(0);
        if(category.getParent_id()!=0) {
            //增加父类child_size数量
            categoryMapper.updateCatParent(category.getParent_id());
        }
        return categoryMapper.addCat(category);
    }

    @Override
    public int updateCat(Category category) {
        return categoryMapper.updateCat(category);
    }

    @Override
    @Transactional
    public String deleteCat(int id) {
        int catNum=goodsMapper.findCatByCatId(id);
        if(catNum!=0){
            return "改类目还有商品存在";
        }else {
            if(categoryMapper.deleteCat(id)==1)
                return "删除成功";
            return "删除失败";
        }
    }


    //子节点
    private List<Map<String,Object>> getChildren(List<Category> catList, int pid) {
        //子节点容器
        List<Map<String,Object>> childList=new ArrayList<>();
        Iterator<Category> iterator=catList.listIterator();
        while (iterator.hasNext()){
            Map<String,Object> map=new HashMap<>();
            Category next=iterator.next();
            if(next.getParent_id()==pid){
                int id=next.getId();
                String title=next.getName();
                map.put("id",id);
                map.put("title",title);
                map.put("spread", true);
                if(next.getChild_size()!=0){
                    map.put("children",getChildren(catList,id));
                }
                childList.add(map);
            }
        }
        return childList;
    }
}
