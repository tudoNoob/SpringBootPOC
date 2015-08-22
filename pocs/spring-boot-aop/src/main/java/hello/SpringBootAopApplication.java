package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootAopApplication implements CommandLineRunner {

	@Autowired
	public BO bo;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAopApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		System.out.println("teste");
		teste();
	}

	private void teste() {
		System.out.println("BO teste run: "+bo.doSomething());
		//throw new NullPointerException("teste aspecto");
	}
}
