package com.free.devquickstart.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.free.devquickstart.entity.UserInfo;
import org.springframework.stereotype.Repository;

/**
 * @ClassNameUserInfoDao
 * @Description
 * @Author Free
 * @Date2020/8/12 17:01
 * @Version V1.0
 **/
@Repository
public interface UserInfoDao extends BaseMapper<UserInfo> {
}
