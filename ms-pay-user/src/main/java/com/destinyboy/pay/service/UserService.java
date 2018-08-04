package com.destinyboy.pay.service;

import com.destinyboy.api.user.dto.UserDto;
import com.destinyboy.api.user.vo.UserVo;

public interface UserService {

    /**
     * 保存用户
     * @param userDto
     * @return
     */
    UserVo saveUser(UserDto userDto) throws Exception;


    /**
     * 修改用户余额
     * @param userDto
     * @return
     */
    UserVo editUserBalance(UserDto userDto) throws Exception;


    /**
     * 根据UserId 获取用户
     * @return
     */
    UserVo getUser(Long id) throws Exception;
}
