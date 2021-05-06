public class MathStudent extends Student {

	private String MSSV;
	
	public MathStudent() {
		super();
		this.MSSV = "";
	}
	
	public MathStudent(String MSSV , String hoLot , String ten , String lop , int namVaoHoc , double diemTrungBinh) {
		 super(hoLot,ten,lop,namVaoHoc,diemTrungBinh);
		 this.MSSV = MSSV ;
	}
	 
	public String getMSSV() {
		return this.MSSV;
	}
	
	public void setMSSV(String MSSV) {
		this.MSSV = MSSV ;
	}
	
}