package cn.cheny;

import cn.cheny.cycle.MainConfig3;
import cn.cheny.cycle.ServiceA;
import cn.cheny.cycle.ServiceB;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class BasicTest1 {

	@Test
	public void test1() {
		String cheny = BeanFactoryUtils.transformedBeanName("&cheny");
	}

	@Test
	public void test2() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(MainConfig3.class);
		context.refresh();

		//获取service1
		ServiceA service1 = context.getBean(ServiceA.class);
		//获取service2
		ServiceB service2 = context.getBean(ServiceB.class);

		System.out.println("----A-----");
		service2.mB(); //@1
		System.out.println("----B-----");
		service1.mA(); //@2
		System.out.println("----C-----");
		System.out.println(service2.getServiceA() == service1);
	}
}
