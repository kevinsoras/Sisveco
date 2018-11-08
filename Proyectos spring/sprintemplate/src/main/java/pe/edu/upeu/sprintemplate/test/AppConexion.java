package pe.edu.upeu.sprintemplate.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import pe.edu.upeu.sprintemplate.entity.Cliente;
import pe.edu.upeu.sprintemplate.repository.ClienteRepository;

public class AppConexion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		ClienteRepository repo = context.getBean("clienteRepository",ClienteRepository.class);
		Cliente u = new Cliente(0,"Marcos","Chunga",123456789,"Jr.Friendzone","96867621","1");
		repo.save(u);
		context.close();
	}

}
