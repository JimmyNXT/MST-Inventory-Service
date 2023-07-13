package com.mtech.inventoryservice;

import com.mtech.inventoryservice.model.Inventory;
import com.mtech.inventoryservice.repository.InventoryRepository;
import com.mtech.inventoryservice.service.InventoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(InventoryRepository inventoryRepository, InventoryService inventoryService) {

        return args -> {
            Inventory inventory = new Inventory();
            inventory.setSkuCode("iphone_13");
            inventory.setQuantity(100);

            Inventory inventory1 = new Inventory();
            inventory1.setSkuCode("iphone_13_red");
            inventory1.setQuantity(0);

            if (!inventoryService.isInStock(inventory.getSkuCode())) {
                inventoryRepository.save(inventory);
            }

            if (!inventoryService.isInStock(inventory1.getSkuCode())) {
                inventoryRepository.save(inventory1);
            }
        };
    }
}
