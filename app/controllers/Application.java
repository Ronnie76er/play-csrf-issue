package controllers;

import play.filters.csrf.AddCSRFToken;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import views.html.index;


public class Application extends Controller {

    //To Reproduce
    //Clear cookies for localhost
    //Go to http://localhost:9000
    //"HI=THERE" is not present in the Play Session

    @AddCSRFToken
    public static Result index() {
        Http.Context current = Http.Context.current();
        current.session().put("HI", "THERE");
        return ok(index.render("Your new application is ready."));
    }

}
