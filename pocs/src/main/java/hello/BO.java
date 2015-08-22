package hello;

import org.springframework.stereotype.Service;

@Service
public class BO {

	
	
	
	public String doSomething(){
		System.out.println("BO");
		throw new NullPointerException("Mandando nullpointer exception");
	}
}
