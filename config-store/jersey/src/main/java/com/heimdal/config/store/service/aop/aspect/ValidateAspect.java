package com.heimdal.config.store.service.aop.aspect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Controller;

import javax.validation.Valid;

import com.heimdal.config.store.service.base.controller.HeimdalBaseController;

@Aspect
@Controller
public class ValidateAspect implements Ordered{

	@Override
	public int getOrder() {
		return 1;
	}
	
	@Before("execution(public * * (.., @javax.validation.Valid (*), ..))")
	public void validate(JoinPoint joinPoint) {
				
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		Object target = joinPoint.getTarget();
		Object args[] = joinPoint.getArgs();
		Annotation annotations[][] = method.getParameterAnnotations();
		List<Integer> parameters = new ArrayList<Integer>();
		for(int i = 0;i<annotations.length;i++) {
			for(int c = 0;c<annotations[i].length;c++) {
				if(annotations[i][c] instanceof Valid) {
					parameters.add(i);
				}
			}
		}
		
		if (target instanceof HeimdalBaseController) {
			HeimdalBaseController controller = (HeimdalBaseController) target;
			for(int parameter : parameters) {
				controller.validate(args[parameter]);
			}
		}
		
	}
}
