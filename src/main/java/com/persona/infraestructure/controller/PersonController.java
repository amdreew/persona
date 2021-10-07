package com.persona.infraestructure.controller;

import com.persona.app.dto.PersonDTO;
import com.persona.app.port.PersonAppPort;
import com.persona.infraestructure.controller.filter.IValidatorGenericParams;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/persona")
@AllArgsConstructor
@CrossOrigin("*")
public class PersonController {
    private final PersonAppPort port;
    private final IValidatorGenericParams iValidatorGenericParams;

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        return new ResponseEntity<>(this.port.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody PersonDTO personDTO, BindingResult result) {
        ResponseEntity<?> responseValidator = this.iValidatorGenericParams.validateParams(result);
        return responseValidator == null? new ResponseEntity<>(this.port.savePerson(personDTO), HttpStatus.CREATED)
                :responseValidator;
    }

    @PutMapping
    public ResponseEntity<?> update(@Valid  @RequestBody PersonDTO personDTO, BindingResult result) {
        ResponseEntity<?> responseValidator = this.iValidatorGenericParams.validateParams(result);
        return responseValidator == null? new ResponseEntity<>(this.port.updatePerson(personDTO), HttpStatus.CREATED)
                :responseValidator;
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(this.port.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/byname/{name}")
    public ResponseEntity<?> findByName(@PathVariable String name) {
        return new ResponseEntity<>(this.port.findByName(name), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id) {
        return new ResponseEntity<>(this.port.deletePersonById(id), HttpStatus.OK);
    }
}
