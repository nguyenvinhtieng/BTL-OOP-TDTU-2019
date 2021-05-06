
public class Student {

    protected String hoLot;//Ho va ten lot
    protected String ten;//Ten
    protected String lop;//Lop
    protected int namVaoHoc;
    protected double diemTrungBinh;

    public Student(){       
        this.hoLot = "";
        this.ten = "";
        this.lop = "";
        this.namVaoHoc = 2020;
        this.diemTrungBinh = 0;
    }
    
    public Student(String hoLot, String ten, String lop, int namVaoHoc, double diemTrungBinh) {        
        this.hoLot = hoLot;
        this.ten = ten;
        this.lop = lop;
        this.namVaoHoc = namVaoHoc;
        this.diemTrungBinh = diemTrungBinh;
    }

    public String getHoLot() {
        return hoLot;
    }

    public void setHoLot(String hoLot) {
        this.hoLot = hoLot;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public int getNamVaoHoc(){
        return this.namVaoHoc;
    }
    
    public double getDiemTrungBinh(){
        return this.diemTrungBinh;
    }
    
    public String toString(){
        return hoLot + " " + ten + " - " + lop + " - " + namVaoHoc + " - " + diemTrungBinh;
    }
    
   
}
