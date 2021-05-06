import java.util.ArrayList;
import java.util.*;
import java.io.*;


public class StudentManagement {

    private ArrayList<Student> dsSinhVien;
     
    public StudentManagement() {
        dsSinhVien = new ArrayList<Student>();
    }

    public ArrayList<Student> getDSSV() {
        return dsSinhVien;
    }

    public void setDsSinhVien(ArrayList<Student> dsSinhVien) {
        this.dsSinhVien = dsSinhVien;
    }   
    
    
    public boolean readStudent(String fileName) {
        //code here
		 try{  
			 File myObj = new File("DSSV.txt");  
			 Scanner myReader = new Scanner(myObj);  
       
		     while (myReader.hasNextLine()) { 
			 
			 String data = myReader.nextLine();  			 
            String[] arStr = data.split("\\,");
			
            ArrayList<String> temp = new ArrayList<String>();
		    for (String item : arStr) {
				temp.add(item);
			}
			
			 if((temp.get(0)).matches("\\d+")) {
				 
				 int a = Integer.parseInt(temp.get(0));
				 int b = Integer.parseInt(temp.get(4));
				 double c = Double.parseDouble(temp.get(5));
				 
				 Student itst = new ITStudent(a, temp.get(1), temp.get(2),temp.get(3),b,c);
				dsSinhVien.add(itst);
			 }
			 else {
				 int a = Integer.parseInt(temp.get(4));
				 double b = Double.parseDouble(temp.get(5));
				 Student mst = new MathStudent(temp.get(0), temp.get(1), temp.get(2),temp.get(3),a,b);
				dsSinhVien.add(mst);
			    }
			 			
		     }
		 myReader.close();  
			  
		 }
		 catch (Exception e) {    
			 return false;  
		 }
        return true;
    }
    
    public boolean addStudent(Student A) {
        //code here
		//KT IT
		for(int i=0 ; i < dsSinhVien.size() ; i++ ) { 
			if ( (A instanceof ITStudent) && (dsSinhVien.get(i) instanceof ITStudent)  && 
			(((ITStudent ) A ).getMSSV() == ((ITStudent) dsSinhVien.get(i)).getMSSV()) )	
		return false ;
		}
		//KT MATH
		for(int i=0 ; i < dsSinhVien.size() ; i++ ) {
			if ( A instanceof MathStudent && dsSinhVien.get(i) instanceof MathStudent &&
            ((MathStudent ) A ).getMSSV().equals(((MathStudent) dsSinhVien.get(i)).getMSSV()))	
		    return false ;
		}
		
		// addStudent 
		if ( A instanceof ITStudent || A instanceof MathStudent) {
		dsSinhVien.add(A);
		}
		
        return true;
    }

    public boolean addStudentByIndex(Student A, int index) {
        //code here
		//KT IT
		for(int i=0 ; i < dsSinhVien.size() ; i++ ) {
			if ( (A instanceof ITStudent) && (dsSinhVien.get(i) instanceof ITStudent)  && 
			(((ITStudent ) A ).getMSSV() == ((ITStudent) dsSinhVien.get(i)).getMSSV()) )	
		return false ;
		}
		//KT MATH
		for(int i=0 ; i < dsSinhVien.size() ; i++ ) {
			if ( A instanceof MathStudent && dsSinhVien.get(i) instanceof MathStudent &&
            ((MathStudent ) A ).getMSSV().equals(((MathStudent) dsSinhVien.get(i)).getMSSV()))	
		    return false ;
		}
		
		// addStudent 
		if ( A instanceof ITStudent || A instanceof MathStudent) {
		dsSinhVien.add(index,A);
		}
		
        return true;
    }   
    
    public boolean deleteStudentByIndex(int index){
        //code here 
		//delete
		if ( index > dsSinhVien.size() || index < 0) {
			return false;
		}
		dsSinhVien.remove(index);
        return true;
    }
        
    public ArrayList<Student> searchStudent(int n,String str){
        ArrayList<Student> dsTemp = new ArrayList<Student>();
        switch(n){
            case 1:{//Tìm theo Nam vao truong 
                //code here
				
				for (int i =0 ; i < dsSinhVien.size() ; i ++ ) {
					if (dsSinhVien.get(i).getNamVaoHoc() == Integer.parseInt(str) ) {
						dsTemp.add(dsSinhVien.get(i));
					}
				}		
                break;
            }
            case 2:{//Tìm theo Lớp
                //code here   
			    for (int i =0 ; i < dsSinhVien.size() ; i++ ) {
					if((dsSinhVien.get(i).getLop()).equals(str)) {
						dsTemp.add(dsSinhVien.get(i));
					}
				}					
                break;
            }            
        }
        return dsTemp;
    }
    
    public ArrayList<Student> sort(ArrayList<Student> listStu){
        ArrayList<Student> dsTemp = new ArrayList<Student>();   
        ArrayList<Student> masosinhvien = new ArrayList<Student>(); 		
        //code here   
		
         int[] kiemtra = new int[dsSinhVien.size()];
		 int vitri = 0;
		 int kichthuoc = 0;
		double max;
		for(int k = 0 ; k < dsSinhVien.size() ;k ++) {
			
			
			int j=0;
			max = 0;
			for(int i=0 ; i < dsSinhVien.size() ; i++  ) {
				boolean dk = true;
				for(int m = 0 ; m < kichthuoc ; m++){
				if (i == kiemtra[m]) dk = false;
				}
				if(dk) {	
				 if(dsSinhVien.get(i).getDiemTrungBinh() > max ) {
					 max = dsSinhVien.get(i).getDiemTrungBinh() ;
					 j=i;
					}
				}
			
			}
			
			
			
				for(int i=0 ; i < dsSinhVien.size() ; i++  ) {
					boolean dk = true;
					for(int m = 0 ; m < kichthuoc ; m++){
					if (i == kiemtra[m]) dk = false;
					}
					
					if(dk){
				 if(dsSinhVien.get(i).getDiemTrungBinh() == max )
				 {
					 String name1 = dsSinhVien.get(j).getTen();
					 String name2 = dsSinhVien.get(i).getTen();
					 
					 if(name1.charAt(0) > name2.charAt(0)) {
						 j=i;
					 }
					 
					 
					 
					 if(name1.length() > 1 && name2.length() > 1 ) {
						 if(name1.charAt(0) == name2.charAt(0) && name1.charAt(1) > name2.charAt(1)) {
							 j=i;
						 }
					 }
					 
					 if(name1.length() > 2 && name2.length() > 2 ) {
						 if(name1.charAt(0) == name2.charAt(0) && name1.charAt(1) == name2.charAt(1) 
							 && name1.charAt(2) > name2.charAt(2)) {
							 j=i;
						 }
					 }
					 
					 if(name1.length() > 3 && name2.length() > 3 ) {
						 if(name1.charAt(0) == name2.charAt(0) && name1.charAt(1) == name2.charAt(1) 
							 && name1.charAt(2) == name2.charAt(2) && name1.charAt(3) > name2.charAt(3)) {
							 j=i;
						 }
					 }
					 
 
				 }	 
			}
		}
			
			dsTemp.add(dsSinhVien.get(j));
			//masosinhvien.add(dsSinhVien.get(j).getMSSV());
	        //System.out.println(dsTemp.getMSSV(j));
		    //dsSinhVien.remove(j);
			kichthuoc++;
			kiemtra[vitri]=j;
			vitri ++;
		}
        return dsTemp;
    } 
    
    // -------- Write file function---------
    
    public boolean writeStudent(String fileName, ArrayList<Student> DSSV) throws IOException{
        FileWriter fw = new FileWriter(fileName); 
        for (int i = 0; i < DSSV.size(); i++) {
            if(DSSV.get(i) instanceof ITStudent){
                ITStudent A = (ITStudent)DSSV.get(i);
                fw.write(Integer.toString(A.getMSSV()) + " - " + A.toString());
            }else{
                MathStudent A = (MathStudent)DSSV.get(i);
                fw.write(A.getMSSV() + " - " + A.toString());
            }
            fw.write("\r\n");
        }
     
        fw.close();
        return true;
    }
    
    public boolean writeFile(String fileName) throws IOException{
        writeStudent(fileName, dsSinhVien);        
        return true;
    }    
    
    public boolean writeFile(String fileName, int namVaoTruong) throws IOException{
        ArrayList<Student> dsTemp = searchStudent(1,Integer.toString(namVaoTruong));
        writeStudent(fileName, dsTemp);        
        return true;
    }
    
    public boolean writeFile(String fileName, String text) throws IOException{
        if(text.equals("Sort")){
            ArrayList<Student> dsTemp = sort(dsSinhVien);
            writeStudent(fileName, dsTemp);            
        }
        else{
            ArrayList<Student> dsTemp = searchStudent(2,text);
            writeStudent(fileName, dsTemp);
        }        
        return true;
    }
}
