package apap.tutorial.shapee.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import apap.tutorial.shapee.model.ProductModel;
import apap.tutorial.shapee.model.StoreModel;
import apap.tutorial.shapee.service.StoreService;
import apap.tutorial.shapee.service.ProductService;

@Controller
public class StoreController{
    @Qualifier("storeServiceImpl")
    @Autowired
    private StoreService storeService;

    @Autowired
    private ProductService productService;

    @RequestMapping("/")
    private String home(){
        return "home";
    }

    //API yang digunakan untuk mengakses halaman add store
    @RequestMapping(value="/store/add", method= RequestMethod.GET)
    public String addStoreFormPage(Model model){
        StoreModel newStore = new StoreModel();
        newStore.setFollowers(0);
        model.addAttribute("store", newStore);
        return "form-add-store";
    }

    //API uang digunakan unntuk submit form yang telah anda masukan di halaman add store
    @RequestMapping(value = "/store/add", method = RequestMethod.POST)
    private String addStoreSubmit(@ModelAttribute StoreModel store, Model model){
        storeService.addStore(store);
        model.addAttribute("nama", store.getNama());
        return "add-store";        
    }

    //API yang digunakan untuk menuju halaman form change store
    @RequestMapping(value="store/change/{idStore}", method = RequestMethod.GET)
    public String changeStoreFormPage(@PathVariable Long idStore, Model model){
        // Mengambil existing data store
        StoreModel storeLink = storeService.getStoreByIdLink(idStore);
        if(storeLink == null){
            return "error-store";
        }
        else{
        StoreModel existingStore = storeService.getStoreById(idStore);
        model.addAttribute("store", existingStore);
        return "form-change-store";
        }
    }

    //API yang digunakan untuk submit form change store
    @RequestMapping(value="store/change/{idStore}", method = RequestMethod.POST)
    public String changeStoreFormSubmit(@PathVariable Long idStore, @ModelAttribute StoreModel store, Model model) {
        StoreModel newStoreData = storeService.changeStore(store);
        model.addAttribute("store", newStoreData);
        return "change-store";
    }

    //API untuk mengakses halaman view store
    @RequestMapping("/store/view")
    public String view(
        //Request Parameter untuk di pass
        @RequestParam(value = "idStore") Long idStore, Model model
    ){
        //Mengambil objek store yang dituju berdasarkan id
        StoreModel storeLink = storeService.getStoreByIdLink(idStore);
        if(storeLink == null){
            return "error-store";
        }
        else{
        StoreModel store = storeService.getStoreById(idStore);
        //Add objek store ke "store" untuk dirender
        model.addAttribute("store", store);
        List<ProductModel> productList = productService.findAllProductByStoreId(store.getId());
        model.addAttribute("productList", productList);
        //Return view template view-store
        return "view-store";
        }
    }
    //URL Mapping View All
    @RequestMapping(value = "/store/view-all")
    public String viewAll(Model model){
        //Mengambil data semua objek store yang ada
        List<StoreModel> storeList = storeService.getStoreList();
        //Mengurutkan store berdasarkan nama
        Collections.sort(storeList);
        //Add objek ke "storeList" untuk dirender
        model.addAttribute("storeList", storeList);
        //return view template
        return "view-all-store";
    }

    @RequestMapping(value = "/store/delete/{idStore}")
    public String delete(
        @PathVariable(value = "idStore") Long idStore, Model model){
        List<ProductModel> products = productService.findAllProductByStoreId(idStore);
        StoreModel storeLink = storeService.getStoreByIdLink(idStore);
        if(storeLink == null){
            return "error-store";
        }
        else if(products.size() > 0){
            return "tidak-bisa-delete-store";
        }
        else{
        storeService.deleteStore(idStore);
        return "delete-store";
        }
    }
}