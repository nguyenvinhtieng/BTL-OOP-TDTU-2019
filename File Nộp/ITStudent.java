public class ITStudent extends Student {
	private int MSSV;
	
	public ITStudent() {
		super();
		this.MSSV = 0;
	}
	
	public ITStudent(int MSSV , String hoLot , String ten , String lop , int namVaoHoc , double diemTrungBinh) {
		 super(hoLot,ten,lop,namVaoHoc,diemTrungBinh);
		 this.MSSV = MSSV ;
	}
	 
	public int getMSSV() {
		return this.MSSV;
	}
	
	public void setMSSV(int MSSV) {
		this.MSSV = MSSV ;
	}
	

}