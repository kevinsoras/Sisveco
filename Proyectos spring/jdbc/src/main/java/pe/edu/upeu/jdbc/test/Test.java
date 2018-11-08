package pe.edu.upeu.jdbc.test;

import java.util.List;
import java.util.Map;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import pe.edu.upeu.jdbc.dao.UsuarioDao;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
        UsuarioDao dao = (UsuarioDao)context.getBean("usuarioDaoImp");
             List<Map<String, Object>> lista = dao.readAll();
        for(Map<String,Object> map:lista) {
        	System.out.println(map.get("nom_user"));
        }
        
      //  dao.delete(3);
        context.close();
	}

}
