package io.shaikezam.scope;

import jakarta.enterprise.context.NormalScope;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Inherited
@NormalScope
@Retention(RetentionPolicy.RUNTIME)
public @interface JmsScoped {}
