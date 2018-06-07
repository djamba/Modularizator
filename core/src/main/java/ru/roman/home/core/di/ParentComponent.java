package ru.roman.home.core.di;

import javax.inject.Qualifier;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * User: ischenko
 * Date: 07.06.2018
 * Time: 9:55
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface ParentComponent {
}
