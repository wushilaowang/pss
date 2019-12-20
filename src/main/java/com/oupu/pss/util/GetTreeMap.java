package com.oupu.pss.util;

import com.oupu.pss.dao.CategoryMapper;
import com.oupu.pss.entity.Category;
import com.oupu.pss.vo.Tree;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * Classname:TreeMap
 * Package:com.oupu.pss.util
 * Description:
 *
 * @Data:2019/12/11 14:58
 * @Author:
 */
public class GetTreeMap {


    @Autowired
    private CategoryMapper categoryMapper;
    private Iterator<Category> iterator;

    public  List<Map<String,Object>> treeMap(){
        //获取所有类目
        List<Category> catList=categoryMapper.findAllCat();
        Map<String,Object> map=new HashMap<>();
        List<Map<String,Object>> list=new ArrayList<>();
        //迭代器遍历
        iterator = catList.iterator();
        while(iterator.hasNext()){
            int parentId=iterator.next().getParent_id();
            if(parentId==0) {
                int childSize = iterator.next().getChild_size();
                String name = iterator.next().getName();
                int id = iterator.next().getId();
                map.put("id", id);
                map.put("title", name);
                if(childSize!=0){
                    map.put("children",getChildren(iterator,id));
                }
            }
            list.add(map);
        }
        return list;
    }

    //子节点
    private Object getChildren( Iterator<Category> iterator, int pid) {
        Map<String,Object> map=new HashMap<>();
        while (iterator.hasNext()){
            if(iterator.next().getParent_id()==pid){
                int id=iterator.next().getId();
                String title=iterator.next().getName();
                map.put("id",id);
                map.put("title",title);
                if(iterator.next().getChild_size()!=0){
                    getChildren(iterator,id);
                }
            }
        }
        return map;
    }
}
