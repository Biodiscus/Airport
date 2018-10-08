package com.capgemini.airport.controller.api;

import com.capgemini.airport.data.model.Type;
import com.capgemini.airport.data.service.BrandService;
import com.capgemini.airport.data.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("type_api")
@RequestMapping("/api/type")
public class TypeController {
    @Autowired
    private TypeService typeService;

    @Autowired
    private BrandService brandService;

    @GetMapping("/")
    public Iterable<Type> getAll() {
        return typeService.readAll();
    }

    @GetMapping("/{id}")
    public Type get(Long id) {
        return typeService.read(id);
    }

    @PostMapping("/")
    public Type create(@RequestBody Type type) {
        type = typeService.create(type);
        if(type.getBrand() != null) {
            long id = type.getBrand().getId();
            type.setBrand(brandService.read(id));
        }

        return type;
    }

    @PutMapping("/")
    public Type update(@RequestBody Type type) {
        type = typeService.update(type);
        if(type.getBrand() != null) {
            long id = type.getBrand().getId();
            type.setBrand(brandService.read(id));
        }
        return type;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id) {
        typeService.delete(id);
        return "{'success': true}";
    }
}
