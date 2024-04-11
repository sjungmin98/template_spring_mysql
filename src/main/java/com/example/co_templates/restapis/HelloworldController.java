package com.example.co_templates.restapis;

import java.util.ArrayList;
import java.util.HashMap;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloworldController {

    @GetMapping("/r/helloWorldResponseList/{currentPage}/{perPage}/{SN}")
    public ResponseEntity<Object> helloWorldResponseList(@PathVariable String currentPage, @PathVariable String perPage, @PathVariable String SN) {
        ArrayList<HashMap<String, Object>> arrayList = new ArrayList<>();
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("spm_row", 471);
        resultMap.put("SN", 1);
        resultMap.put("CMPNM", "로이유통");
        resultMap.put("RDNMADR", null);
        arrayList.add(resultMap);

        resultMap = new HashMap<>();
        resultMap.put("spm_row", 571);
        resultMap.put("SN", 2);
        resultMap.put("CMPNM", "의료유통");
        resultMap.put("RDNMADR", 3);
        arrayList.add(resultMap);

        return ResponseEntity.ok().body(arrayList);
    }

    @GetMapping("/r/helloWorldResponseWithException/{companyID}")
    public ResponseEntity<Object> helloWorldResponseWithException(@PathVariable String companyID) {
        try {
            int result = 5 / 0;
            return ResponseEntity.ok().body(null);
        } catch (Exception e) {
            String errorMessage = "Error: " + e.getMessage();
            return ResponseEntity.badRequest().body(errorMessage);
        }
    }
}
