package dev.vio.InventoryService.controller;

import dev.vio.InventoryService.dto.InventoryResponse;
import dev.vio.InventoryService.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping("/inventory")
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isInStock(@RequestParam List<String> skuCode) {

        return inventoryService.isInStock(skuCode);
    }
}
