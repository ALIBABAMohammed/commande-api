package com.learning.code.spring_boot_first_fake_app.ws.facade;

import com.learning.code.spring_boot_first_fake_app.bean.Commande;
import com.learning.code.spring_boot_first_fake_app.service.facade.CommandeService;
import com.learning.code.spring_boot_first_fake_app.workflow.commande.payer.CommandePayerProcess;
import com.learning.code.spring_boot_first_fake_app.ws.converter.CommandeConverter;
import com.learning.code.spring_boot_first_fake_app.ws.dto.CommandeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Gestion-Commercial/command")
public class CommandProvided {

    @GetMapping("/ref/{ref}")
    public CommandeDto findByRef(@PathVariable String ref) {
        Commande commande = commandeService.findByRef(ref);
        return commandeConverter.toDto(commande);
    }

    @DeleteMapping("/ref/{ref}")
    @Transactional
    public int deleteByRef(@PathVariable String ref) {
        commandeService.deleteByRef(ref);
        return 1;
    }

    @GetMapping("/ref/{ref}/total/{total}")
    public List<CommandeDto> findByRefAndTotalGreaterThan(@PathVariable String ref, @PathVariable double total) {
        List<Commande> commands = commandeService.findByRefAndTotalGreaterThan(ref, total);
        return commandeConverter.toDto(commands);
    }

    @GetMapping("/id/{id}")
    @Deprecated
    public CommandeDto getById(@PathVariable Long id) {
        Commande commande = commandeService.getById(id);
        return commandeConverter.toDto(commande);
    }

    @GetMapping("/")
    public List<CommandeDto> findAll() {
        List<Commande> commands = commandeService.findAll();
        return commandeConverter.toDto(commands);
    }

    @PostMapping("/")
    public int save(@RequestBody CommandeDto commandeDto) {
        Commande commande = commandeConverter.toItem(commandeDto);
        return commandeService.save(commande);
    }

    @PutMapping("/payer/ref/{ref}/mt/{mt}")
    public int payer(@PathVariable String ref, @PathVariable double mt) {
        return commandePayerProcess.run(ref, mt);
    }

    @Autowired
    private CommandePayerProcess commandePayerProcess;
    @Autowired
    private CommandeService commandeService;
    @Autowired
    private CommandeConverter commandeConverter;
}
