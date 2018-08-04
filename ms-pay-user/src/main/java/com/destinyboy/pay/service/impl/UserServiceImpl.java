package com.destinyboy.pay.service.impl;

import com.destinyboy.api.user.dto.UserDto;
import com.destinyboy.api.user.vo.UserVo;
import com.destinyboy.pay.entity.User;
import com.destinyboy.pay.repository.UserRepository;
import com.destinyboy.pay.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * 保存 用户
     * @param userDto
     * @return
     */
    @Override
    public UserVo saveUser(UserDto userDto) throws Exception{
        User user = new User();
        user.setName(userDto.getName());
        user.setBalance(userDto.getBalance());
        User userTemp = userRepository.save(user);
        UserVo vo = new UserVo();
        vo.setName(userTemp.getName());
        vo.setBalance(userTemp.getBalance());
        return vo;
    }

    /**
     * 编辑用户余额
     * @param userDto
     * @return
     */
    @Override
    public UserVo editUserBalance(UserDto userDto) throws Exception{
        User user = userRepository.findById(userDto.getId()).map(obj -> {
            if (obj.getBalance().doubleValue() < userDto.getBalance().doubleValue()) {
                throw  new RuntimeException("余额不足");
            }
            return obj;
        }).orElseThrow(()-> new RuntimeException("用户信息不存在"));
        user.setBalance(user.getBalance().subtract(userDto.getBalance()));

        User userTemp = userRepository.saveAndFlush(user);
        UserVo vo = new UserVo();
        vo.setName(userTemp.getName());
        vo.setBalance(userTemp.getBalance());
        return vo;
    }

    /**
     * 根据UserId 获取用户
     * @return
     */
    @Override
    public UserVo getUser(Long id) throws Exception{
        User user = this.userRepository.getOne(id);
        UserVo vo = new UserVo();
        BeanUtils.copyProperties(user, vo);
        return vo;
    }


}
