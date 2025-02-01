package com.inventory.control.pro.sprgbt.controller.api.category.adapter;

import static com.inventory.control.pro.sprgbt.controller.api.category.constants.Constants.ALL;
import static com.inventory.control.pro.sprgbt.controller.api.category.constants.Constants.CREATE;
import static com.inventory.control.pro.sprgbt.controller.api.category.constants.Constants.RESOURCE;

import com.inventory.control.pro.sprgbt.controller.api.category.dto.CategoryRequest;
import com.inventory.control.pro.sprgbt.controller.api.category.dto.CategoryResponse;
import com.inventory.control.pro.sprgbt.controller.api.category.dto.PageableResponse;
import com.inventory.control.pro.sprgbt.controller.api.category.dto.WrapperResponse;
import com.inventory.control.pro.sprgbt.controller.api.category.mapper.CategoryMapperInput;
import com.inventory.control.pro.sprgbt.service.category.port.CategoryService;
import com.inventory.control.pro.sprgbt.utils.category.CategoryMessages;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(path = RESOURCE)
class CategoryController {

  private final CategoryService categoryService;
  private final CategoryMapperInput mapperInput;

  @PostMapping(path = CREATE, consumes = MediaType.APPLICATION_JSON_VALUE, produces =
      MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<WrapperResponse<CategoryResponse>> createCategory(
      @Valid @RequestBody CategoryRequest categoryRequest) {
    log.info("Init to create category");
    var domain = mapperInput.toDomain(categoryRequest);
    var category = mapperInput.toResponse(categoryService.saveCategory(domain));
    return new ResponseEntity<>(new WrapperResponse<>(CategoryMessages.CREATED_SUCCESS.getCode(),
        CategoryMessages.CREATED_SUCCESS.getMessage(), category), HttpStatus.CREATED);
  }

  @GetMapping(path = ALL, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<WrapperResponse<PageableResponse<CategoryResponse>>> getAllCategory(
      @RequestParam(required = false) Integer page,
      @RequestParam(required = false) Integer size,
      @RequestParam(required = false) String sortDirection) {
    log.info("Get all categories");
    var categoryDomainPage = categoryService.getAllCategories(page, size, sortDirection);
    var pageableResponse = mapperInput.toPageableResponse(categoryDomainPage);
    return new ResponseEntity<>(new WrapperResponse<>(CategoryMessages.GET_ALL.getCode(),
        CategoryMessages.GET_ALL.getMessage(), pageableResponse), HttpStatus.OK);
  }
}

