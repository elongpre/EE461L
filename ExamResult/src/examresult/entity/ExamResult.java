package examresult.entity;

import java.io.Serializable;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class ExamResult implements Serializable{

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	Key idNumber;
	private String name;
	private String grade1;
	private String grade2;
	
	public void ExamResult(){
		name="";
		grade1="";
		grade2="";
	}
	
	public void ExamResult(Key idNumber, String name, String grade1, String grade2){
		this.idNumber=idNumber;
		this.name=name;
		this.grade1=grade1;
		this.grade2=grade2;
	}

	public Key getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(Key idNumber) {
		this.idNumber = idNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGrade1() {
		return grade1;
	}

	public void setGrade1(String grade1) {
		this.grade1 = grade1;
	}

	public String getGrade2() {
		return grade2;
	}

	public void setGrade2(String grade2) {
		this.grade2 = grade2;
	}
	
	
}
