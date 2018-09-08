package dao;

import java.util.ArrayList;
import java.util.List;

import model.Item;

public class ItemDao {
	
	private static List<Item> items = new ArrayList<Item>();
	
	public static Item insert(Item item) {
		item.setTotalCost();
		items.add(item);
		return item;
	}
	
	public static List<Item> getItems(){
		return items;
	}
	
	public static Item updateQuantity(int id, int quantity) {
		items.get(id).setQuantity(items.get(id).getQuantity() + quantity);
		items.get(id).setTotalCost();
		return items.get(id);
	}
	
	public static int productExists(Long id) {
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getProduct().getId() == id) {
				return i;
			}
		}
		return -1;
	}
}
