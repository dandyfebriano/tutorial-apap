package apap.tutorial.shapee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import apap.tutorial.shapee.model.StoreModel;
import apap.tutorial.shapee.service.StoreService;

@Controller
public class StoreController {
    @Autowired
    private StoreService storeService;

    // URL Mapping View
    @RequestMapping("/store/add")
    public String add(
            // Request parameter untuk dipass
            @RequestParam(value = "idStore", required = true) String idStore,
            @RequestParam(value = "nama", required = true) String nama,
            @RequestParam(value = "keterangan", required = true) String keterangan,
            @RequestParam(value = "followers", required = true) int followers, Model model) {
        // Membuat objek store model
        StoreModel store = new StoreModel(idStore, nama, keterangan, followers);
        // Memanggil service addStore
        storeService.addStore(store);
        // Memasukkan attribute nama pada view template dengan variable nama
        model.addAttribute("nama", nama);
        // Return view template add-store
        return "add-store";
    }

    //URL mapping set keterangan
    @RequestMapping("store/update/id-store/{idStore}/keterangan/{keterangan}")
    public String setKeterangan(
        @PathVariable(value = "idStore") String idStore,
        @PathVariable(value = "keterangan") String keterangan, Model model){
            StoreModel store = storeService.getStoreById(idStore);
            if(store == null){
                return "error-store";
            }
            store.setKeterangan(keterangan);
            model.addAttribute("store", store);
            return "set-store";
        }
    
    //URL mapping delete store
    @RequestMapping("store/delete/id/{idStore}")
    public String delete(
        @PathVariable(value = "idStore") String idStore, Model model){
            StoreModel store = storeService.getStoreById(idStore);
            if(store == null) {
                return "error-store";
            }
            else{
            storeService.deleteStore(idStore);
            return "delete-store";
            }
        }


    // URL Mapping View
    @RequestMapping("/store/view")
    public String view(
            // Request parameter untuk di pass
            @RequestParam(value = "idStore") String idStore, Model model) {

        // Mengambil objek store yang dituju berdasarkan id
        StoreModel store = storeService.getStoreById(idStore);
        if(store == null){
            return "error-store";
        }
        // Add objek store ke "store" untuk dirender
        model.addAttribute("store", store);
        // Return view template view-store
        return "view-store";
    }

    //URL Mapping View Path Variable
    @RequestMapping("/store/view/id-store/{idStore}")
    public String viewPathVariable(
        @PathVariable(value = "idStore") String idStore, Model model){
            StoreModel store = storeService.getStoreById(idStore);
            if(store == null){
                return "error-store";
            }
            model.addAttribute("store", store);
            return "view-store";
        }


    // URL Mapping viewAll
    @RequestMapping(value = "/store/view-all")
    public String viewAll(Model model) {
        // Mengambil data semua objek store yang ada
        List<StoreModel> storeList = storeService.getStoreList();
        //Add objek ke "storeList" untuk dirender
        model.addAttribute("storeList", storeList);
        //Return view template view-all-store
        return "view-all-store";
    }
}
