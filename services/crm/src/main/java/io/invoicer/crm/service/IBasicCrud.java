package io.invoicer.crm.service;

public interface IBasicCrud<T, K> {

    T create(T model);
}
