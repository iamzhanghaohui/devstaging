package com.free.devquickstart.controller;

/**
 * @ClassNameUserInfoPlusController
 * @Description
 * @Author Free
 * @Date2020/8/12 17:11
 * @Version V1.0
 **/

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.free.devquickstart.entity.UserInfo;
import com.free.devquickstart.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

/**
 * @Description UserInfoPlusController
 * @Author Sans
 * @CreateTime 2019/6/9 14:52
 */
@RestController
@RequestMapping("/userInfoPlus")
public class UserInfoPlusController {

    @Autowired
    private UserInfoService userInfoService;

    /**
     * MP扩展演示
     * @Author Sans
     * @CreateTime 2019/6/8 16:37
     * @Return Map<String,Object> 返回数据
     */
    @RequestMapping("/getInfoListPlus")
    public Map<String,Object> getInfoListPage(){
        //初始化返回类
        Map<String,Object> result = new HashMap<>();
        //查询年龄等于18岁的学生
        //等价SQL: SELECT id,name,age,skill,evaluate,fraction FROM user_info WHERE age = 18
        QueryWrapper<UserInfo> queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.lambda().eq(UserInfo::getAge,18);
        List<UserInfo> userInfoEntityList1 = userInfoService.list(queryWrapper1);
        result.put("studentAge18",userInfoEntityList1);
        //查询年龄大于5岁的学生且小于等于18岁的学生
        //等价SQL: SELECT id,name,age,skill,evaluate,fraction FROM user_info WHERE age > 5 AND age <= 18
        QueryWrapper<UserInfo> queryWrapper2 = new QueryWrapper<>();
        queryWrapper2.lambda().gt(UserInfo::getAge,5);
        queryWrapper2.lambda().le(UserInfo::getAge,18);
        List<UserInfo> userInfoEntityList2 = userInfoService.list(queryWrapper2);
        result.put("studentAge5",userInfoEntityList2);
        //模糊查询技能字段带有"画"的数据,并按照年龄降序
        //等价SQL: SELECT id,name,age,skill,evaluate,fraction FROM user_info WHERE skill LIKE '%画%' ORDER BY age DESC
        QueryWrapper<UserInfo> queryWrapper3 = new QueryWrapper<>();
        queryWrapper3.lambda().like(UserInfo::getSkill,"画");
        queryWrapper3.lambda().orderByDesc(UserInfo::getAge);
        List<UserInfo> userInfoEntityList3 = userInfoService.list(queryWrapper3);
        result.put("studentAgeSkill",userInfoEntityList3);
        //模糊查询名字带有"小"或者年龄大于18的学生
        //等价SQL: SELECT id,name,age,skill,evaluate,fraction FROM user_info WHERE name LIKE '%小%' OR age > 18
        QueryWrapper<UserInfo> queryWrapper4 = new QueryWrapper<>();
        queryWrapper4.lambda().like(UserInfo::getName,"小");
        queryWrapper4.lambda().or().gt(UserInfo::getAge,18);
        List<UserInfo> userInfoEntityList4 = userInfoService.list(queryWrapper4);
        result.put("studentOr",userInfoEntityList4);
        //查询评价不为null的学生,并且分页
        //等价SQL: SELECT id,name,age,skill,evaluate,fraction FROM user_info WHERE evaluate IS NOT NULL LIMIT 0,5
        IPage<UserInfo> page = new Page<>();
        page.setCurrent(1);
        page.setSize(5);
        QueryWrapper<UserInfo> queryWrapper5 = new QueryWrapper<>();
        queryWrapper5.lambda().isNotNull(UserInfo::getEvaluate);
        page = userInfoService.page(page,queryWrapper5);
        result.put("studentPage",page);
        return result;
    }
}

