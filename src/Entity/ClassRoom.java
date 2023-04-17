package Entity;

import java.util.ArrayList;
import java.util.List;

public class ClassRoom {
	private List<Student> listStudent;
	public ClassRoom() {
		listStudent = new ArrayList();
	}
	
	public ClassRoom(List<Student> listStudent) {
		super();
		this.listStudent = listStudent;
	}

	public List<Student> getListStudent() {
		return listStudent;
	}

	public void printList(List<Student> listStudent) {
		for(Student x : listStudent) {
			System.out.println(x.toString());
		}
	}
	
	
}
