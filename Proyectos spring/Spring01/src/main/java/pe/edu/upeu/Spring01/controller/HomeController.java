package pe.edu.upeu.Spring01.controller;

import javax.swing.JOptionPane;

import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javafx.css.ParsedValue;
import pe.edu.upeu.Spring01.dao.UsuarioDao;
import pe.edu.upeu.Spring01.daoImp.UsuarioDaoImp;
import pe.edu.upeu.Spring01.pojo.Usuario;
import pe.edu.upeu.Spring01.service.UsuarioService;
import pe.edu.upeu.Spring01.serviceImp.UsuarioServiceImp;



@Controller
public class HomeController {

	@Autowired
	UsuarioService usuarioService;

	@RequestMapping(value="/user")
	public ModelAndView  mensaje() {
		
		ModelAndView ma = new ModelAndView();
		ma.setViewName("user");
		//List<Usuario> list = usuarioService.readAll();
		ma.addObject("lista", usuarioService.readAll());
		return ma;
	}
	 @RequestMapping(value = "/delete/{id}")
	    public ModelAndView deletes(@PathVariable("id") int id)
	    {
			 usuarioService.delete(id);
			 									
			 
	        return new ModelAndView("redirect:/user");
	    }
	 @RequestMapping(value = "/save", method = RequestMethod.POST)
	 public ModelAndView save(@RequestParam String usu,@RequestParam String pass) {
		 try {
			 Usuario u=new Usuario();
			 u.setNomuser(usu);
			 u.setClave(pass);
			 usuarioService.create(u);
			 

		 }catch (Exception e) {
			 System.out.print(""+e);
				// TODO: handle exception
		}
	  return new ModelAndView("redirect:/user");
	 }
	 @RequestMapping(value = "/read/{id}")
	    public void read(@PathVariable("id") int id)
	    {
		 
		 
			 usuarioService.delete(id);
			 									

	    }
}
	