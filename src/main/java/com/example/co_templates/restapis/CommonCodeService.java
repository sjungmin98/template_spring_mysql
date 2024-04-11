package com.example.co_templates.restapis;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class CommonCodeService {
    public ArrayList<HashMap<String, Object>> list(@PathVariable("pageNumber") Integer pageNumber) {
        ArrayList<HashMap<String, Object>> itemList = new ArrayList<HashMap<String, Object>>();
 
        HashMap<String, Object> item = new HashMap<>();
        item.put("PK_ID", 1);
        item.put("FK_ID", 10);
        item.put("NAME", "Excalibur");
        itemList.add(item);
    
        item = new HashMap<>();
        item.put("PK_ID", 2);
        item.put("FK_ID", 20);
        item.put("NAME", "Dragon Sword");
        itemList.add(item);
    
        return itemList;
    }

    public HashMap<String, Object> view(Integer pkID){
        HashMap<String, Object> itemDetails = new HashMap<>();
        
        String fkID = "FK_0382";
        String name = "Commons";
        itemDetails.put("PK_ID", pkID);
        itemDetails.put("FK_ID", fkID);
        itemDetails.put("NAME", name);

        return itemDetails;
    }
}
