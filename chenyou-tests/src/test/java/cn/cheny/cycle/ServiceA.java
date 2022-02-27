package cn.cheny.cycle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceA {
	public void mA() {
		System.out.println("ServiceA mA");
	}

	private ServiceB serviceB;

	@Autowired
	public void setServiceB(ServiceB serviceB) {
		this.serviceB = serviceB;
	}
}
