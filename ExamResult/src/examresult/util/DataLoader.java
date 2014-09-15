package examresult.util;

import examresult.dao.ExamResultDAO;

public class DataLoader {
	
	public static void loadData() {
		ExamResultDAO.INSTANCE.add("000", "test student", "67", "76");	
	}
}
