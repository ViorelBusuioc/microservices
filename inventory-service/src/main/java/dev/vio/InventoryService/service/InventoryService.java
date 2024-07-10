package dev.vio.InventoryService.service;

import dev.vio.InventoryService.dto.InventoryResponse;

import java.util.List;

public interface InventoryService {

    public List<InventoryResponse> isInStock(List<String> skuCode);

}
