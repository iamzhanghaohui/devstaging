package com.free.devquickstart.service.impl;

import com.free.devquickstart.entity.UserInfo;
import com.free.devquickstart.mapper.UserInfoMapper;
import com.free.devquickstart.service.UserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 学生信息表 服务实现类
 * </p>
 *
 * @author Free
 * @since 2020-08-12
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

}
