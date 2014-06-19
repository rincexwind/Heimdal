package com.heimdal.config.store.service.aop.aspect;

import java.lang.reflect.Method;
import java.util.List;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Controller;

import javax.ws.rs.core.HttpHeaders;

import com.heimdal.config.store.service.aop.annotations.AuthorizationRequired;
import com.heimdal.config.store.service.authorization.AuthorizationService;
import com.heimdal.config.store.service.base.controller.HeimdalBaseController;
import com.heimdal.config.store.service.exceptions.NotAuthorizedException;

@Aspect
@Controller
public class AuthorizationRequiredAspect implements Ordered{

	@Override
	public int getOrder() {
		return 0;
	}
	
	@Autowired
	private AuthorizationService authService;
	
	@Before("@annotation(authRequired)")
	public void logBefore(JoinPoint joinPoint,
			AuthorizationRequired authRequired) {

		HttpHeaders headers = null;

		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();

		Object target = joinPoint.getTarget();
		if (target instanceof HeimdalBaseController) {
			HeimdalBaseController controller = (HeimdalBaseController) target;
			headers = controller.getHeaders();
			String authKey = null;
			List<String> headerList = headers.getRequestHeader("Authorization");
			if (headerList != null && headerList.size() == 1) {
				authKey = headerList.get(0);
			}
			if (!authService.lookupAuth(method.getName(), authKey)) {
				throw new NotAuthorizedException(
						"Not Authorized for this service");
			}
		}
	}
}