package bg.softuni.thymeleaf;

import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.io.StringWriter;

public class Test {

  public static void main(String[] args) {
    ITemplateEngine engine = createEngine();
    Context ctx = new Context();
    ctx.setVariable("name", "Pesho");

    StringWriter sw = new StringWriter();

    engine.process("test.html", ctx, sw);

    System.out.println(sw.toString());
  }


  private static ITemplateEngine createEngine() {
    TemplateEngine engine = new TemplateEngine();
    engine.setTemplateResolver(new ClassLoaderTemplateResolver());
    return  engine;
  }
}
