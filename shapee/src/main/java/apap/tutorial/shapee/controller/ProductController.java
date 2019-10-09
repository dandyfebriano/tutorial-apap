package apap.tutorial.shapee.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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

    @RequestMapping(value = "product/add/{idStore}", method = RequestMethod.GET)
    private String addProductFormPage(@PathVariable(value = "idStore") Long idStore, Model model) {
        ProductModel product = new ProductModel();

        StoreModel store = storeService.getStoreById(idStore);
        ArrayList<ProductModel> listProduct = new ArrayList<ProductModel>();
        listProduct.add(product);
        store.setListProduct(listProduct);
        model.addAttribute("store",store);
        model.addAttribute("product", product);
        return "form-add-product";
    }

    @RequestMapping(value = "product/add/{idStore}" ,params={"addRow"})
    private String addRow(@ModelAttribute StoreModel store, Model model){
        if(store.getListProduct() == null){
            store.setListProduct(new ArrayList<ProductModel>());
        }
        store.getListProduct().add(new ProductModel());
        model.addAttribute("store", store);
        return "form-add-product";
    }

    @RequestMapping(value = "product/add/{idStore}", method = RequestMethod.POST, params={"removeRow"})
    private String removeRow(@PathVariable(value = "idStore") Long idStore, @ModelAttribute StoreModel store, Model model, HttpServletRequest req){
        Integer rowId = Integer.valueOf(req.getParameter("removeRow"));
        store.getListProduct().remove(rowId.intValue());
        model.addAttribute("idStore", idStore);
        model.addAttribute("store", store);
        return "form-add-product";
    }

    @RequestMapping(value= "product/add/{idStore}", method = RequestMethod.POST, params={"save"})
    private String addProductSubmit(@PathVariable(value = "idStore") Long idStore, @ModelAttribute StoreModel store, ModelMap model){
        StoreModel oldStore = storeService.getStoreById(idStore);
        model.addAttribute("idStore", idStore);
        for(ProductModel product : store.getListProduct()){
            product.setStoreModel(oldStore);
            productService.addProduct(product);
        }
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
     @RequestMapping(value = "/product/delete", method = RequestMethod.POST)
    public String delete(@ModelAttribute StoreModel store, Model model){
        for(ProductModel product :store.getListProduct()){
            productService.deleteProduct(product);
        }
        return "delete-product";
    }
}