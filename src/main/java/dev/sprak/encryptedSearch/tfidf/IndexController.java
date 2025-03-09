package dev.sprak.encryptedSearch.tfidf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/inverted-index")
public class IndexController {

    @Autowired
    private IndexService indexService;

    @GetMapping("/get-index")
    public ResponseEntity<IndexModel> getIndex() {
        Optional<IndexModel> index = indexService.getIndex();
        return index.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.noContent().build());
    }

    @PostMapping("/post-index")
    public ResponseEntity<IndexModel> postIndex(@RequestBody IndexModel newIndex) {
        IndexModel savedIndex = indexService.saveIndex(newIndex);
        return ResponseEntity.ok(savedIndex);
    }
}
