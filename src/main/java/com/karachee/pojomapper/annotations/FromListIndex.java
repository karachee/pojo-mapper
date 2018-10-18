package com.karachee.pojomapper.annotations;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(FromListIndexContainer.class)
public @interface FromListIndex {
    int index() default -1;
    int[] indices() default {};
    String parent() default "";

}
