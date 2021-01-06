package com.app;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;


@RestController
public class RESTMethods {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/ping")
    public ResponseEntity<String> ping(){
        return ResponseEntity.ok()
                .body("");
    }

    @GetMapping("/get")
     public ResponseEntity<Item> getNameQuantity(@RequestHeader("EAN") String EAN){
        HttpHeaders responseHeaders = new HttpHeaders();
        String query = "SELECT * FROM shop.items WHERE EAN = ?";
        Item item = jdbcTemplate.queryForObject(query, new Object[]{EAN}, (rs, rowNum) ->
                new Item(
                        rs.getString("name"),
                        rs.getString("EAN"),
                        rs.getString("old_amount"),
                        rs.getString("new_amount")

                ));
        return ResponseEntity.ok()
                .body(item);
    }
    @PutMapping("/put")
    public ResponseEntity<?> putAmount(@RequestBody Item item){
        String query = "UPDATE shop.items SET new_amount = ? WHERE EAN = ?";
        jdbcTemplate.update(query, item.getNew_amount(), item.getEAN());

        return ResponseEntity.ok()
                .body("");
    }

}
