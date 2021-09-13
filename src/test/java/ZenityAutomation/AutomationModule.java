package ZenityAutomation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface AutomationModule {

    String[] outputs() default {};
    String[] inputs() default {};
    String moduleName();
    String moduleDescription();
    String category() default "default";

    ModuleParameters[] parameters() default {};
}
