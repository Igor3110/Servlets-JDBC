package by.trofimov.servlet_sample.mapper;

public interface Mapper<F, T> {

    T mapFrom(F object);

}
