public class Practice02_BasketCount {
    public static void main(String[] args) {
        int numOfApples = 120;
        int sizeOfBucket = 10;
        int numOfBucket = numOfApples%sizeOfBucket > 0 ? numOfApples/sizeOfBucket +1 : numOfApples/sizeOfBucket;
        System.out.println("필요한 바구니의 수 : " +numOfBucket);
    }
}
