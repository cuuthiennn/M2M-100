package Repository;

import java.util.HashMap;
import java.util.List;

import Entity.ClassRoom;
import Entity.Student;

public class Repository {
	HashMap<String, ClassRoom> listClassRoom;

	public Repository() {
		listClassRoom = new HashMap<>();
	}

	public HashMap<String, ClassRoom> getListClassRoom() {
		return listClassRoom;
	}
	
	public void showAllList() {
		for (String key : listClassRoom.keySet()) {
			System.out.println("===================== " + key + " =====================");
			listClassRoom.get(key).printList();
		}
	}
}
