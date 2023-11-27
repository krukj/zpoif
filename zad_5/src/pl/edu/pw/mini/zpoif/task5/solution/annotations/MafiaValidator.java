package pl.edu.pw.mini.zpoif.task5.solution.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.CONSTRUCTOR, ElementType.PARAMETER})
public @interface MafiaValidator {
    boolean notEmpty() default true;
    int maxLength() default 5;
}