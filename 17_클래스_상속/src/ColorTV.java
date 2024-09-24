public class ColorTV extends TV{
    private int ColorCount;

    public int getColorCount() {
        return this.ColorCount;
    }

    public void setColorCount(int ColorCount) {
        this.ColorCount = ColorCount;
    }

    public void printInfo(){
        System.out.println(getSize()+"인치" +" "+ getColorCount()+"컬러");
    }
}
