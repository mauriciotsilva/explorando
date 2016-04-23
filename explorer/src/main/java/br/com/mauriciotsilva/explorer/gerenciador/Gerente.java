package br.com.mauriciotsilva.explorer.gerenciador;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static javax.transaction.Transactional.TxType.REQUIRED;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.enterprise.inject.Stereotype;
import javax.transaction.Transactional;

import br.com.mauriciotsilva.explorer.ExplorerException;

@Stereotype
@Documented
@Target(TYPE)
@Retention(RUNTIME)
@Transactional(value = REQUIRED, rollbackOn = ExplorerException.class)
public @interface Gerente {

}
