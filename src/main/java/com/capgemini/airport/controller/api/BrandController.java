package com.capgemini.airport.controller.api;

import com.capgemini.airport.data.model.Brand;
import com.capgemini.airport.data.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("brand_api")
@RequestMapping("/api/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

    @GetMapping("/")
    public Iterable<Brand> getAll() {
        return brandService.readAll();
    }

    @GetMapping("/{id}")
    public Brand get(Long id) {
        return brandService.read(id);
    }

    @PostMapping("/")
    public Brand create(@RequestBody Brand brand) {
        return brandService.create(brand);
    }

    @PutMapping("/")
    public Brand update(@RequestBody Brand brand) {
        return brandService.update(brand);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id) {
        brandService.delete(id);
        return "{'success': true}";
    }
}
