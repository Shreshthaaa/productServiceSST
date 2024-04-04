package com.sst.productservicesst.services;

import com.sst.productservicesst.dtos.FakeStoreProductDto;
import com.sst.productservicesst.models.Category;
import com.sst.productservicesst.models.Product;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService {
    @Override
    public Product getProductById(Long id) {
        //Call the fakeStore API to get the product with given id
        throw new RuntimeException("Something went wrong by service");
//        RestTemplate restTemplate = new RestTemplate();
//        FakeStoreProductDto fakeStoreProductDto =
//                restTemplate.getForObject("https://fakestoreapi.com/products/" + id,
//                        FakeStoreProductDto.class);
//
//        if(fakeStoreProductDto == null){
//            return null;
//        }
//
//        return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);
    }

    public List<Product> getAllProducts() {
        RestTemplate restTemplate = new RestTemplate();
        FakeStoreProductDto[] fakeStoreProductDtos =
                restTemplate.getForObject("https://fakestoreapi.com/products",
                        FakeStoreProductDto[].class);

        List<Product> products = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos){
            products.add(convertFakeStoreProductDtoToProduct(fakeStoreProductDto));
        }
        return products;
    }

    private  Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto fakeStoreProductDto){
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setImage(fakeStoreProductDto.getImage());
        Category category = new Category();
        category.setDescription(fakeStoreProductDto.getCategory());
        product.setCategory(category);

        return product;
    }
}
