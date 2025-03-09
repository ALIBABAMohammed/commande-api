package com.learning.code.spring_boot_first_fake_app.ws.converter;

import com.learning.code.spring_boot_first_fake_app.bean.Commande;
import com.learning.code.spring_boot_first_fake_app.ws.dto.CommandeDto;
import org.springframework.stereotype.Component;

@Component
public class CommandeConverter extends AbstractConverter<Commande, CommandeDto>{

    @Override
    public CommandeDto toDto(Commande item) {
        CommandeDto dto = null;
        if (item != null) {
            dto = new CommandeDto();
            dto.setId(item.getId());
            dto.setRef(item.getRef());
            dto.setTotal(item.getTotal());
            dto.setTotalePaye(item.getTotalePaye());
        }
        return dto;
    }
    @Override
    public Commande toItem(CommandeDto dto) {
        Commande item = null;
        if (dto != null) {
            item = new Commande();
            item.setId(dto.getId());
            item.setRef(dto.getRef());
            item.setTotal(dto.getTotal());
            item.setTotalePaye(dto.getTotalePaye());
        }
        return item;
    }
}
