package example.spring.config;

import example.common.CommonController;
import example.common.ResultCodeType;
import example.common.ResultJson;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 * Created by yookeun on 2017. 2. 26..
 */

@Aspect
public class ApiAop extends CommonController {
    /**
     * ResultJson 으로 리턴되는 메소드인 경우
     * @param joinPoint
     * @return
     */
    @Around("execution(public example.common.ResultJson example.api.control.*Controller.*(..))")
    public ResultJson coverAroundJson(ProceedingJoinPoint joinPoint) {
        ResultJson result = new ResultJson();
        try {
            result = (ResultJson)joinPoint.proceed();
        } catch (Throwable e) {
            result.setResultCode(ResultCodeType.FAIL_REQUEST.getCode());
            result.setMsg(e.toString());
            log.error("["+joinPoint.toString()+"]" + e);
        }
        return result;
    }
}