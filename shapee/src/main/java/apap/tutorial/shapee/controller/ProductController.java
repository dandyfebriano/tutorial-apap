package apap.tutorial.shapee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import apap.tutorial.shapee.model.ProductModel;
import apap.tutorial.shapee.model.StoreModel;
import apap.tutorial.shapee.service.ProductService;
import apap.tutorial.shapee.service.StoreService;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @Qualifier("storeServiceImpl")
    @Autowired
    StoreService storeService;

    @RequestMapping(value = "product/add/{storeId}", method = RequestMethod.GET)
    private String addProductFormPage(@PathVariable(value = "storeId") Long storeId, Model model) {
        ProductModel product = new ProductModel();
        StoreModel store = storeService.getStoreById(storeId);
        product.setStoreModel(store);

        model.addAttribute("product", product);
        return "form-add-product";
    }

    @RequestMapping(value= "product/add", method = RequestMethod.POST)
    private String addProductSubmit(@ModelAttribute ProductModel productModel, Model model){
        productService.addProduct(productModel);
        model.addAttribute("nama", productModel.getNama());
        return "add-product";
    }

    @RequestMapping(value= "product/change/{idProduct}", method = RequestMethod.GET)
    public String changeProductFormPage(@PathVariable Long idProduct, Model model){
        // Mengambil existing data product
        ProductModel existingProduct = productService.getProductById(idProduct);
        model.addAttribute("product", existingProduct);
        return "form-change-product";
    }

     //API yang digunakan untuk submit form change product
     @RequestMapping(value="product/change/{idProduct}", method = RequestMethod.POST)
     public String changeProductFormSubmit(@PathVariable Long idProduct, @ModelAttribute ProductModel product, Model model) {
         ProductModel newProductData = productService.changeProduct(product);
         model.addAttribute("product", newProductData);
         return "change-product";
     }

     //API yang digunakan untuk menghapus product
     @RequestMapping(value = "/product/delete/{idProduct}")
    public String delete(
        @PathVariable(value = "idProduct") Long idProduct){
        productService.deleteProduct(idProduct);
        return "delete-product";
    }
}