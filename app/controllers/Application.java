package controllers;

import play.*;
import play.mvc.*;
import play.mvc.Http;
import model.User;
import play.api.data.FormUtils;
import play.data.Form;
import views.html.*;

public class Application extends Controller {

    public static Result index() {

        return ok("It works!");
    }

    public static Result test(){
    	return ok(views.html.test.render("this is a test"));
    }
 
    public static Result formTest(){
    	Form<User> userForm = Form.form(User.class);
    	userForm.bindFromRequest(request(), "email","name");
    	User user = userForm.get();
    	return ok("Here is the User" + user);
    }
    
}
