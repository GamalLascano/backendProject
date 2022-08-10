package com.example.mslogin.configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


/**
 * Configuracion del proyecto.
 */
@org.springframework.context.annotation.Configuration
public class Configuration extends WebSecurityConfigurerAdapter {
  @Override
    protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable();
    http.headers().frameOptions().disable();
  }

}
