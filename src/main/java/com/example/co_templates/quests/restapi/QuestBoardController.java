package com.example.co_templates.quests.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class QuestBoardController {

    @Autowired
    QuestBoardService boardService;

    @GetMapping("/q/r/board/list/{pageNumber}")
    public ResponseEntity<List<HashMap<String, Object>>> list(@PathVariable Integer pageNumber) {
        List<HashMap<String, Object>> itemList = boardService.list(pageNumber);
        return ResponseEntity.ok().body(itemList);
    }

    @GetMapping("/q/r/board/view/{pk_id}")
    public ResponseEntity<HashMap<String, Object>> view(@PathVariable("pk_id") Integer pkId) {
        HashMap<String, Object> itemDetails = boardService.view(pkId);
        return ResponseEntity.ok().body(itemDetails);
    }

    @DeleteMapping("/q/r/board/delete/{pk_id}")
    public ResponseEntity<Integer> delete(@PathVariable("pk_id") Integer pkId) {
        int result = boardService.delete(pkId);
        return ResponseEntity.ok().body(result);
    }

    @PostMapping("/q/r/board/insert/{title}/{contents}")
    public ResponseEntity<Integer> insert(@PathVariable("title") String title, @PathVariable("contents") String contents) {
        int result = boardService.insert(title, contents);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/q/r/board/mixed/{pageNumber}/{pk_id}")
    public ResponseEntity<HashMap<String, Object>> mixed(
            @PathVariable Integer pageNumber,
            @PathVariable("pk_id") Integer pkId,
            @RequestParam("title") String title,
            @RequestParam("contents") String contents) {

        HashMap<String, Object> response = new HashMap<>();
        HashMap<String, String> requestParams = new HashMap<>();

        requestParams.put("pageNumber", pageNumber.toString());
        requestParams.put("pk_id", pkId.toString());
        requestParams.put("title", title);
        requestParams.put("contents", contents);

        int deleteResult = boardService.delete(pkId);
        response.put("delete", deleteResult);

        int insertResult = boardService.insert(title, contents);
        response.put("insert", insertResult);

        HashMap<String, Object> viewResult = boardService.view(pkId);
        if (viewResult == null) {
            response.put("view", "Not found");
        } else {
            response.put("view", viewResult);
        }

        List<HashMap<String, Object>> listResult = boardService.list(pageNumber);
        response.put("list", listResult);

        response.put("requestParams", requestParams);

        return ResponseEntity.ok().body(response);
    }
}
