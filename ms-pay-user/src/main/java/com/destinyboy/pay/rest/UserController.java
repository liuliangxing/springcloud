package com.destinyboy.pay.rest;


import com.destinyboy.api.user.dto.UserDto;
import com.destinyboy.api.user.groups.EditUserBalanceGroup;
import com.destinyboy.api.user.groups.GetUserGroup;
import com.destinyboy.api.user.groups.SaveUserGroup;
import com.destinyboy.api.user.vo.UserVo;
import com.destinyboy.pay.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    /**
     * 保存用户
     * @param userDto
     * @return
     */
    @PostMapping("/save")
    public UserVo saveUser(@Validated(value = SaveUserGroup.class) @RequestBody UserDto userDto) throws Exception{
        return userService.saveUser(userDto);
    }


    /**
     * 修改用户余额
     * @param userDto
     * @return
     */
    @PostMapping("/edit")
    public UserVo editUserBalance(@Validated(value = EditUserBalanceGroup.class)  @RequestBody UserDto userDto) throws Exception{
        return userService.editUserBalance(userDto);
    }


    /**
     * 根据UserId 获取用户
     * @return
     */
    @GetMapping("/get/{id}")
    public UserVo getUser(@PathVariable("id") Long id) throws Exception{
        return userService.getUser(id);
    }

}
