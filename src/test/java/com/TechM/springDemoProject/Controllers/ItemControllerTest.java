package com.TechM.springDemoProject.Controllers;

import com.TechM.springDemoProject.Models.Item;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ItemControllerTest {

    @Autowired
    ItemController itemController;

    @Test
    void getItemById() throws Exception {
        String itemName = itemController.getItemById(1).getName();
        assertEquals("orange", itemName);


    }

    @Test
    void getItemById2() throws Exception {
        String itemName = itemController.getItemById(2).getName();
        assertEquals("orange", itemName);
    }

    @Test
    void getItemByIdThrowsErrorOrInvalidId() throws Exception {
        assertThrows(Exception.class, (Executable) itemController.getItemById(0));
    }


    @Test
    void getItemByIdReturnsNullForNonexistentId() throws Exception {
        assertNull(itemController.getItemById(100));
    }
    @Test
    void getItemByIdReturnsNullForNonexistentId2() throws Exception {
        assertNull(itemController.getItemById(90));
    }    @Test
    void getItemByIdReturnsNullForNonexistentId3() throws Exception {
        assertNull(itemController.getItemById(95));
    }
    @Test
    void getItemByIdReturnsNullForNonexistentId4() throws Exception {
        assertNull(itemController.getItemById(17));
    }



    @Test
    void getItemByIdReturnsItemWithCorrectId() throws Exception {
        Item item = itemController.getItemById(1);
        assertNotNull(item);
        assertEquals(1, item.getId());
    }


    @Test
    void getItemByIdReturnsItemWithCorrectId2() throws Exception {
        Item item = itemController.getItemById(2);
        assertNotNull(item);
        assertEquals(2, item.getId());
    }
    @Test
    void getAllItems() throws Exception {
        List<Item> items = itemController.getAllItems();
        assertFalse(items.isEmpty());
        for (Item item : items) {
            assertNotNull(item.getName());
            assertNotNull(item.getPrice());
            assertNotNull(item.getIsActive());
            assertNotNull(item.getCreatedDate());
            assertNotNull(item.getUpdatedDate());
        }

    }

    @Test
    void testGetAllItemsReturnsCorrectNumberOfItems() {
        List<Item> items = itemController.getAllItems();
        assertEquals(2, items.size());
    }


    @Test
    void testGetAllActiveItemsReturnsOnlyActiveItems() {
        List<Item> activeItems = itemController.getAllActiveItems();
        for (Item item : activeItems) {
            assertTrue(item.getIsActive());
        }
    }


    @Test
    void testGetAllActiveItemsReturnsCorrectNumberOfItems() {
        List<Item> activeItems = itemController.getAllActiveItems();
        int expectedCount = 2;
        assertEquals(expectedCount, activeItems.size());
    }

}
