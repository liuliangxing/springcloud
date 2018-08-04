package com.destinyboy.pay.feign;

import com.destinyboy.api.user.UserApi;
import com.destinyboy.pay.fallback.UserFallback;
import org.springframework.cloud.openfeign.FeignClient;


@FeignClient(value = "ms-pay-user",fallback = UserFallback.class)
public interface UserServer extends UserApi {
}
