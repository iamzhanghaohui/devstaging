package com.free.devquickstart.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.free.devquickstart.dao.UserInfoDao;
import com.free.devquickstart.pojo.UserInfoEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassNameUserInfoSerivceImpl
 * @Description
 * @Author Free
 * @Date2020/8/12 17:06
 * @Version V1.0
 **/

@Service
@Transactional
public class UserInfoSerivceImpl extends ServiceImpl<UserInfoDao, UserInfoEntity> implements UserInfoService {

}
