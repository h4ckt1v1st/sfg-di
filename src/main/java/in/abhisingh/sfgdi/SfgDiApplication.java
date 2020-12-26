package in.abhisingh.sfgdi;

import in.abhisingh.sfgdi.controllers.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SfgDiApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);

		I18nController i18nController = (I18nController) ctx.getBean("i18nController");
		System.out.println(i18nController.sayHello());

//		Here the framework is creating the object and putting it in the context.
		MyController myController = (MyController) ctx.getBean("myController");

		System.out.println("-------- Primary Bean");
		System.out.println(myController.sayHello());

//		For these, we need to annotate GreetingServiceImpl as a @Service.

//		Then we need to annotate PropertyInjectedController class with @Controller to tell spring that it is a spring managed component.
//		Then we need to annotate the property inside the class with @Autowired to tell spring to inject this as a dependency. Otherwise it'll be a NPE.
		System.out.println("------- Property");
		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
		System.out.println(propertyInjectedController.getGreeting());

//		Then we need to annotate SetterInjectedController class with @Controller to tell spring that it is a spring managed component.
//		Then we need to annotate the setter inside the class with @Autowired to tell spring to inject this as a dependency. Otherwise it'll be a NPE.
		System.out.println("------- Setter");
		SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController");
		System.out.println(setterInjectedController.getGreeting());

//		Then we need to annotate ConstructorInjectedController class with @Controller to tell spring that it is a spring managed component.
//		For constructors we don't need to annotate the constructor inside the class with @Autowired.
		System.out.println("------- Constructor");
		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");
		System.out.println(constructorInjectedController.getGreeting());

	}

}
