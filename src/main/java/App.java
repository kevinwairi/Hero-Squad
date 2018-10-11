import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {


        get("/", (request, response) -> {
            return new ModelAndView(new HashMap(), "templates/hero.vtl");
        }, new VelocityTemplateEngine());
    }
}
