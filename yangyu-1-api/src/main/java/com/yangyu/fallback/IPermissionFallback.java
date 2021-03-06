package com.yangyu.fallback;

import com.yangyu.api.PermissionApi;
import com.yangyu.common.json.JsonResult;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class IPermissionFallback implements FallbackFactory<PermissionApi>{
    @Override
    public PermissionApi create(Throwable throwable) {
        return new PermissionApi() {
            @Override
            public JsonResult authority(List<String> authorities) {
                return JsonResult.fail("菜单获取失败，请稍后再试");
            }
        };
    }
}
