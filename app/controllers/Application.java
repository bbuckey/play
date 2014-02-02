package controllers;

import java.util.HashMap;
import java.util.Map;

import play.*;
import play.mvc.*;
import model.User;
import play.api.data.FormUtils;
import play.data.Form;
import views.html.*;

import com.fasterxml.jackson.databind.JsonNode;
import play.api.libs.json.Json;
import utils.StringUtils;


public class Application extends Controller {

    public static Result index() {

        return ok(index.render(Form.form(User.class)));
    }

    public static Result test(){
    	return ok(views.html.test.render("this is a test"));
    }
 
    
    public static Result formUser(){
    	User user = new User("fake@email.com", " Johhnny");
    	String s = "";
    	try{
    		s = StringUtils.jsonify(User.class, (Object)user);
    	} catch(Throwable t){
    		t.printStackTrace();
    	}
    	return ok(form.render(Form.form(User.class)));
    }
    
    public static Result formTest(){
    	Form<User> userForm = Form.form(User.class).bindFromRequest();;
    	User user = userForm.get();
    	return play.mvc.Controller.redirect(controllers.routes.Application.index());
    }
    
}
