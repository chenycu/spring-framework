package cn.cheny.cycle;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MethodBeforeInterceptor implements SmartInstantiationAwareBeanPostProcessor {
	@Override
	public Object getEarlyBeanReference(Object bean, String beanName) throws BeansException {
		if ("serviceA".equals(beanName)) {
			//代理创建工厂，需传入被代理的目标对象
			ProxyFactory proxyFactory = new ProxyFactory(bean);
			//添加一个方法前置通知，会在方法执行之前调用通知中的before方法
			proxyFactory.addAdvice((MethodBeforeAdvice) (method, args, target) -> System.out.println("hello,serviceA"));
			//返回代理对象
			return proxyFactory.getProxy();
		}
		return bean;
	}
}
