package ZenityAutomation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface ModuleParameters {

    enum paramType {
        STRING,
        CHECKBOX,
        CHOICE,
        NUMBER
    }

    paramType type();

    String label();

    String[] choices() default {};

    ModulesConnections drivenBy() default ModulesConnections.FLOW;
}
