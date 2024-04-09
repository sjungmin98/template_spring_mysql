package com.example.quests.restapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class CommonCodeController {

    @GetMapping("/commonCode/list/{pageNumber}")
    public ResponseEntity<List<HashMap<String, Object>>> list(@PathVariable("pageNumber") Integer pageNumber) {
        List<HashMap<String, Object>> itemList = new ArrayList<>();
 
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
    
        return ResponseEntity.ok().body(itemList);
    }

    @GetMapping("/commonCode/view/{pk_id}/{fk_id}/{name}")
    public ResponseEntity<HashMap<String, Object>> view(@PathVariable("pk_id") Integer pkId,
                                                        @PathVariable("fk_id") Integer fkId,
                                                        @PathVariable("name") String name) {
        HashMap<String, Object> itemDetails = new HashMap<>();

        itemDetails.put("PK_ID", pkId);
        itemDetails.put("FK_ID", fkId);
        itemDetails.put("NAME", name);

        return ResponseEntity.ok().body(itemDetails);
    }
}
