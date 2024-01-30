package com.in28minutes.learnspringframework;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


// Eliminate verbosity in creating Java Beans
// Public accessor methods, constructor,
// equals, hashcode and toString are automatically created.
// record is Released in JDK 16.
// record 를 사용하면 getter, setter 를 만들 필요없다. 자동생서해 준다.

record Person (String name, int age, Address address) {};

record Address (String firstLine, String city) {};
@Configuration
public class HelloWorldConfiguration {

    @Bean
    public String name() {
        return "Seo";
    }

    @Bean
    public int age() {
        return 51;
    }

    @Bean
    public Person person() {
        // var person = new Person("jo", 41);
        // return person;
        return new Person("jo", 41, new Address("Main Street", "Utrecht"));
    }

    @Bean
    public Person person2MethodCall() {
        return new Person(name(), age(), address());
    }

    @Bean
    public Person person3Parameters(String name, int age, Address address3) {
        return new Person(name, age, address3);
    }

    @Bean
    @Primary
    public Person person4Parameters(String name, int age, Address address) {
        return new Person(name, age, address);
    }

    @Bean
    public Person person5Qualifier(String name, int age, @Qualifier("address3qualifier") Address address) {
        return new Person(name, age, address);
    }

    @Bean(name="address2")
    @Primary
    public Address address() {
        return new Address("PungDuckChan Street", "Youngin");
    }

    @Bean(name="address3")
    @Qualifier("address3qualifier")
    public Address address3() {
        return new Address("JongRo1ga Street", "Seoul");
    }
}
