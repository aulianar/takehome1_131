/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas1.toko_roti;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author USER DJOGJA
 */
    
@Controller
public class dataController {
    tableController result = new tableController();
    @RequestMapping("/input")
    
    public String getHasil(HttpServletRequest data, Model model) {
        String getNama = data.getParameter("nmRoti");
        int getJumlah = Integer.parseInt(data.getParameter("jmlRoti"));
        int getHarga = Integer.parseInt(data.getParameter("hrgRoti"));
        
        int diskon = result.getharga(getJumlah, getHarga);
        int compute = result.gethitung(getJumlah, getHarga);
        
        model.addAttribute("Nm_Roti",getNama);
        model.addAttribute("Jml_Roti", getJumlah);
        model.addAttribute("Harga", ("Rp. "+ getHarga));
        model.addAttribute("Total", ("Rp. "+(getHarga*getJumlah)));
        model.addAttribute("Diskon", "Rp. "+ compute);
        model.addAttribute("TotalDiskon", diskon + " %");
        
        return "viewerTable";
    }
}