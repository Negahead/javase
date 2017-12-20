package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = {ElementType.METHOD,ElementType.FIELD,ElementType.CONSTRUCTOR,ElementType.TYPE,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@SuppressWarnings(value = "suppress the fucking warning message")
public @interface MyCustomAnnotation {
    int age() default 18;

    /**
     * no default value,so it is required
     */
    String name();
    String address();
}
