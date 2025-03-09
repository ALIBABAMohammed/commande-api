package com.learning.code.spring_boot_first_fake_app.ws.converter;

import com.learning.code.spring_boot_first_fake_app.bean.Commande;
import com.learning.code.spring_boot_first_fake_app.ws.dto.CommandeDto;

import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractConverter<T, DTO> {
    public abstract DTO toDto(T item);

    public abstract T toItem(DTO dto);

    public List<DTO> toDto(List<T> list){
        List<DTO> result=null;
        if (list != null) {
    //Collectors.toList() method is specifically used to collect the elements of a stream into a List
            result = list.stream().map(e->toDto(e)).collect(Collectors.toList());
        }
        return result;
    }
    public List<T> toItem(List<DTO> list){
        List<T> result=null;
        if (list != null) {
            result = list.stream().map(e->toItem(e)).collect(Collectors.toList());
        }
        return result;
    }
}
