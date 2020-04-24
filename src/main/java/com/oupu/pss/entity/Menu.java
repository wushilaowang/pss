package com.oupu.pss.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * Classname:User
 * Package:com.oupu.pss.entity
 * Description:
 *
 * @Data:2019/12/25 10:44
 * @Author:
 */
@Data
@NoArgsConstructor
public class Menu implements Serializable {
    Integer id;
    String menu_name;
    Integer parent_id;
    Integer child_size;
    String url;
    Short is_toolbar;
    Date createtime;
}
