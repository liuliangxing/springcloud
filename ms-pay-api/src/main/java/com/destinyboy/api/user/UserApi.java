package com.destinyboy.api.user;


import com.destinyboy.api.user.dto.UserDto;
import com.destinyboy.api.user.groups.EditUserBalanceGroup;
import com.destinyboy.api.user.groups.GetUserGroup;
import com.destinyboy.api.user.vo.UserVo;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserApi {
    /**
     * 修改用户余额
     * @param userDto
     * @return
     */
    @PostMapping("/edit")
    public UserVo editUserBalance(@Validated(value = EditUserBalanceGroup.class)  @RequestBody UserDto userDto) throws Exception;


    /**
     * 根据UserId 获取用户
     * @return
     */
    @GetMapping("/get/{id}")
    public UserVo getUser(@PathVariable("id") Long id) throws Exception;
}
