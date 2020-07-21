package cn.yccoding.oss.rest;

import cn.yccoding.common.contant.ResultCodeEnum;
import cn.yccoding.common.exception.CustomException;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * @author YC
 * @since 2020/7/14
 **/
@RestController
@RequestMapping("/api/v1")
public class HelloController {

    @GetMapping("/hello")
    public Flux<String> hello() {
        return Flux.just("hello");
    }

    @GetMapping("/hello2")
    public String hello2() {
        if (1 == 1) {
            throw new CustomException(ResultCodeEnum.UNKNOWN_ERROR);
        }
        return "hello2";
    }
}
