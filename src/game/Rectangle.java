package game;

public class Rectangle {
    Vector2D position; // vị trí hình chữ nhật (góc trên bên trái)
    int width; // chiều rộng hcn
    int height; // chiều cao hcn

    public Rectangle() {
        this(new Vector2D(), 1, 1);
    }

    public Rectangle(Vector2D position, int width, int height) {
        this.position = position;
        this.width = width;
        this.height = height;
    }

    /**
     * @param other
     * @return true: nếu hình chữ nhật được gọi (this) có phần
     * giao với hình chữ nhật truyền vào (other)
     * @return false: nếu 2 hình chữ nhật ko giao nhau
     */
    public boolean intersects(Rectangle other) {
        // TODO: 1. Triển khai phần code kiểm tra va chạm giữa 2 hình chữ nhật ở đây
        int distSubX = Math.abs((int)((this.position.x + (this.width/2)) - (other.position.x + (other.width)/2)));
        int distW = (this.width + other.width)/2;
        int distSubY =Math.abs((int)((this.position.y + (this.height/2)) - (other.position.y + (other.height)/2)));
        int distH = (this.height + other.height)/2;
        if(distSubX <= distW && distSubY <= distH)
            return true;
        return false;
    }

    //TODO: 2. Chạy hàm main này để test
    public static void main(String[] args) {
        Rectangle rect1 = new Rectangle(new Vector2D(5, 5), 3, 3);
        Rectangle rect2 = new Rectangle(new Vector2D(4, 4), 3, 3);
        Rectangle rect3 = new Rectangle(new Vector2D(10, 10), 3, 3);
        System.out.println(String.format("rect1 intersects rect2: %s (correct: true)", rect1.intersects(rect2)));
        System.out.println(String.format("rect2 intersects rect1: %s (correct: true)", rect2.intersects(rect1)));
        System.out.println(String.format("rect1 intersects rect3: %s (correct: false)", rect1.intersects(rect3)));
        System.out.println(String.format("rect3 intersects rect2: %s (correct: false)", rect3.intersects(rect2)));
    }
}
