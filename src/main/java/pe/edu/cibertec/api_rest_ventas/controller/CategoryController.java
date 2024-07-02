package pe.edu.cibertec.api_rest_ventas.controller;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.api_rest_ventas.exception.ResourceNotFoundException;
import pe.edu.cibertec.api_rest_ventas.model.bd.Category;
import pe.edu.cibertec.api_rest_ventas.service.CategoryService;

import java.util.ArrayList;
import java.util.List;

/*Habilitando cross por url's*/
/*@CrossOrigin(origins = {"https://cibertec.blackboard.com", "https://intranet.cibertec.edu.pe"})*/
/* Habilitando cross para todas las urls delimitando por metodo HTTP
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})*/
@AllArgsConstructor
@RestController
@RequestMapping(path="api/v1/category")
public class CategoryController {

    private CategoryService categoryService;
    /*Habilitando Cross solo para el método listarCategorias
    @CrossOrigin(origins = {"https://cibertec.blackboard.com",
            "https://intranet.cibertec.edu.pe"})*/
    @GetMapping("")
    public ResponseEntity<List<Category>> listarCategorias(){
        List<Category> categoryList = new ArrayList<>(categoryService.listarCategorias());
        if(categoryList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> obtenerCategoriaXId(
            @PathVariable Integer id){
        Category category = categoryService
                .obtenerCategoriaxId(id).orElseThrow(
                        () -> new ResourceNotFoundException("La categoria con Id " +
                                id + " no existe"));
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Category> registrarCategoria(
            @RequestBody Category category
    ){
        return new ResponseEntity<>(
                categoryService.guardarCategoria(category), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> actualizarCategoria(
            @PathVariable Integer id,
            @RequestBody Category category
    ){
        Category newCategory = categoryService.obtenerCategoriaxId(id)
                .orElseThrow(() -> new ResourceNotFoundException("La categoria con Id "
                        + id +" no existe"));
        newCategory.setCategoryname(category.getCategoryname());
        newCategory.setDescription(category.getDescription());
        return new ResponseEntity<>(
                categoryService.guardarCategoria(newCategory),
                HttpStatus.OK);
    }



}