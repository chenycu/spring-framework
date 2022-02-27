package cn.cheny.cycle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceB {

	public void mB() {
		System.out.println("ServiceB mB");
		this.serviceA.mA();//@1
	}

	private ServiceA serviceA;

	@Autowired
	public void setService1(ServiceA serviceA) {
		this.serviceA = serviceA;
	}

	public ServiceA getServiceA() {
		return serviceA;
	}
}
