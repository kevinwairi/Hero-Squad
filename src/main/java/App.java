import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.HashMap;
import java.util.Map;


public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        String layout = "templates/layout.vtl";

        get("/" , (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template", "templates/hero.vtl" );
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/form", (request,response)->{
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template", "templates/form.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/hero-squad", (request, response)->{
            Map<String, Object> model = new HashMap <String, Object>();
            String name = request.queryParams("name");
            String age = request.queryParams("age");
            String superpower = request.queryParams("superpower");
            String weakness = request.queryParams("weakness");
            model.put("name", name);
            model.put("age", age);
            model.put("superpower", superpower);
            model.put("weakness", weakness);
            model.put("template", "templates/hero-squad.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());






    }
}
