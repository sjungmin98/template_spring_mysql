package com.example.co_templates.quests.restapi;

import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class QuestBoardService {

    final AtomicInteger pkIdCounter = new AtomicInteger(); 
    final List<HashMap<String, Object>> boardItems = new CopyOnWriteArrayList<>(); 

    public QuestBoardService() {
        insert("무한의 대검", "치명타 피해량 보너스를 부여하며, 치명타 확률을 증가시킵니다.");
        insert("가시 갑옷", "공격자에게 피해를 반사하며, 공격자의 치유 효과를 감소시킵니다.");
        insert("라바돈의 죽음모자", "주문력을 대폭 증가시켜 능력치를 강화합니다.");
    }

    public List<HashMap<String, Object>> list(Integer pageNumber) {
        return boardItems;
    }

    public HashMap<String, Object> view(Integer pkId) {
        for (HashMap<String, Object> item : boardItems) {
            if (item.get("PK_ID").equals(pkId)) {
                return item;
            }
        }
        return null;
    }

    public int delete(Integer pkId) {
        for (HashMap<String, Object> item : boardItems) {
            if (item.get("PK_ID").equals(pkId)) {
                boardItems.remove(item);
                return 1;
            }
        }
        return 0;
    }
    
    public int insert(String title, String contents) {
        int newPkId = pkIdCounter.incrementAndGet();
        HashMap<String, Object> newItem = new HashMap<>();
        newItem.put("PK_ID", newPkId);
        newItem.put("TITLE", title);
        newItem.put("CONTENTS", contents);
        boardItems.add(newItem);
        return newPkId;
    }

    public HashMap<String, Object> mixed(Integer pageNumber, Integer pkId, String title, String contents) {
        HashMap<String, Object> response = new HashMap<>();
        response.put("delete", delete(pkId));
        int insertResult = insert(title, contents);
        response.put("insert", insertResult);
        response.put("view", view(insertResult));
        response.put("list", list(pageNumber));
        return response;
    }
}
