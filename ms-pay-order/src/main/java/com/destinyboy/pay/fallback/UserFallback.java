package com.destinyboy.pay.fallback;

import com.destinyboy.api.user.dto.UserDto;
import com.destinyboy.api.user.vo.UserVo;
import com.destinyboy.pay.feign.UserServer;
import org.springframework.stereotype.Component;

@Component
public class UserFallback implements UserServer {

    @Override
    public UserVo editUserBalance(UserDto userDto) throws Exception {
        System.out.println("editUserBalance 出现熔断了。。。");
        return new UserVo();
    }

    @Override
    public UserVo getUser(Long id) throws Exception {
        System.out.println("getUser 出现熔断了。。。");
        return new UserVo();
    }
}
